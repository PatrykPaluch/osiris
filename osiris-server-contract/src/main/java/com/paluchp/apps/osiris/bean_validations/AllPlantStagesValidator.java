package com.paluchp.apps.osiris.bean_validations;

import com.paluchp.apps.osiris.models.plant.LifeCycleStageEnumDto;
import com.paluchp.apps.osiris.models.plant.PlantLifeCycleStageCreateDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllPlantStagesValidator
    implements ConstraintValidator<AllPlantStages, Collection<?>> {
  @Override
  public boolean isValid(
      Collection<?> objects,
      ConstraintValidatorContext constraintValidatorContext) {

    if (objects == null) {
      return true;
    }

    fineMessage(constraintValidatorContext);

    int stagesCount = LifeCycleStageEnumDto.values().length;
    if (objects.size() != stagesCount) {
      return false;
    }

    long distinctStages =
        objects
            .stream()
            .filter(o -> o instanceof PlantLifeCycleStageCreateDto)
            .map(PlantLifeCycleStageCreateDto.class::cast)
            .map(PlantLifeCycleStageCreateDto::getStage)
            .distinct()
            .count();

    return distinctStages == stagesCount && distinctStages == objects.size();
  }

  private void fineMessage(ConstraintValidatorContext context) {
    String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
    String message = defaultConstraintMessageTemplate + getStagesNames();

    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
  }

  private String getStagesNames() {
    return Stream.of(LifeCycleStageEnumDto.values())
        .map(LifeCycleStageEnumDto::name)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
