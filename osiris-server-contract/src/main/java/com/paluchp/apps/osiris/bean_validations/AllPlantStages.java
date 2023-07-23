package com.paluchp.apps.osiris.bean_validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AllPlantStagesValidator.class})
public @interface AllPlantStages {
  String message() default "All plant stages must present in the request";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
