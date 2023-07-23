package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.config;


import com.paluchp.apps.osiris.models.error.ConstraintViolationResponseDto;
import com.paluchp.apps.osiris.models.error.ViolationDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@Primary
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private static ViolationDto mapFieldErrors(ConstraintViolation<?> violation) {
    return new ViolationDto()
        .setFieldName(violation.getPropertyPath().toString())
        .setMessage(violation.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleValidationException(ConstraintViolationException ex) {
    log.info("Constrain violation exception: {}", ex.getMessage());
    List<ViolationDto> violations =
        ex.getConstraintViolations()
            .stream()
            .map(GlobalExceptionHandler::mapFieldErrors)
            .toList();
    return createConstraintViolationResponse(violations);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    log.info("Constrain violation exception");
    List<ViolationDto> violations =
        ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(this::mapFieldError)
            .toList();

    return createConstraintViolationResponse(violations);
  }

  private ViolationDto mapFieldError(FieldError fieldError) {
    return new ViolationDto()
        .setFieldName(fieldError.getField())
        .setMessage(fieldError.getDefaultMessage());
  }

  private ResponseEntity<Object> createConstraintViolationResponse(List<ViolationDto> violations) {
    ConstraintViolationResponseDto responseDto =
        new ConstraintViolationResponseDto().setViolations(violations);

    return ResponseEntity.badRequest().body(responseDto);
  }
}
