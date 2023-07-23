package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.exceptions;

import lombok.Getter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Getter
public class OsirisHttpException extends RuntimeException {

  private final String message;
  private final long timestamp;
  private final String url;

  public OsirisHttpException(String message) {
    this.message = message;
    this.timestamp = System.currentTimeMillis();
    this.url = currentRequestUrl();
  }

  private static String currentRequestUrl() {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    if (requestAttributes instanceof ServletRequestAttributes attr) {
      return attr.getRequest().getRequestURL().toString();
    }
    return null;
  }
}
