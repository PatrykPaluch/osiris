package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.exceptions;


import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;
import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends OsirisHttpException {

  public ResourceNotFoundException(@NonNull String resourceName, @NonNull UUID id) {
    super(createNotFoundMessage(resourceName, id));
  }

  public ResourceNotFoundException(@NonNull Class<?> entityClass, @NonNull UUID id) {
    this(entityClassName(entityClass), id);
  }

  private static String createNotFoundMessage(String resourceName, UUID id) {
    return MessageFormat.format("Resource '{0}' with id {1} not found", resourceName, id);
  }

  private static String entityClassName(Class<?> entityClass) {
    final String entitySuffix = "Entity";
    String className = entityClass.getSimpleName();
    if (className.endsWith(entitySuffix)) {
      return className.substring(0, className.length() - entitySuffix.length());
    }
    return className;
  }
}
