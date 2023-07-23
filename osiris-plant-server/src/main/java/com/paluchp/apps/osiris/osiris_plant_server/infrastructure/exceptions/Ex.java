package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.exceptions;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.UUID;
import java.util.function.Supplier;

@UtilityClass
public final class Ex {

  public static Supplier<ResourceNotFoundException> notFound(@NonNull String resourceName, @NonNull UUID id) {
    return () -> new ResourceNotFoundException(resourceName, id);
  }

  public static Supplier<ResourceNotFoundException> notFound(@NonNull Class<?> entityClass, @NonNull UUID id) {
    return () -> new ResourceNotFoundException(entityClass, id);
  }

}
