package com.paluchp.apps.osiris.models.plant;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class PlantLifeCycleStageDto {
  LifeCycleStageEnumDto stage;
  private String description;
  private int groundMoistureMin;
  private int groundMoistureMax;
  private int airMoistureMin;
  private int airMoistureMax;
  private int temperatureMin;
  private int temperatureMax;
  private FrequencyEnumDto wateringFrequency;
}
