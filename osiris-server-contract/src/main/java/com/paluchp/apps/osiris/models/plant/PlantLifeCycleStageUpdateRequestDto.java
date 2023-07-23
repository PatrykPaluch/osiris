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
public class PlantLifeCycleStageUpdateRequestDto {

  @NotNull
  @Size(max = 255)
  private String description;

  @IntPercent
  private int groundMoistureMin;

  @IntPercent
  private int groundMoistureMax;

  @IntPercent
  private int airMoistureMin;

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
