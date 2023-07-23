package com.paluchp.apps.osiris.bean_validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@Min(value = 0)
@Max(value = 100)
@ReportAsSingleViolation
public @interface IntPercent {
  String message() default "must be between 0 and 100";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
