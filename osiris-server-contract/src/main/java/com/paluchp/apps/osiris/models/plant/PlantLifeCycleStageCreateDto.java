package com.paluchp.apps.osiris.models.plant;

import com.paluchp.apps.osiris.bean_validations.IntPercent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class PlantLifeCycleStageCreateDto {

  @NotNull
  LifeCycleStageEnumDto stage;

  @NotNull
  @Size(max = 255)
  private String description;

  @NotNull
  @IntPercent
  private int groundMoistureMin;

  @NotNull
  @IntPercent
  private int groundMoistureMax;

  @NotNull
  @IntPercent
  private int airMoistureMin;

  @NotNull
  @IntPercent
  private int airMoistureMax;

  @Min(-100)
  @Max(100)
  private int temperatureMin;

  @Min(-100)
  @Max(100)
  private int temperatureMax;

  @NotNull
  private FrequencyEnumDto wateringFrequency;
}
