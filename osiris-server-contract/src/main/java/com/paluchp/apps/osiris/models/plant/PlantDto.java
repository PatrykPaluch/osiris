package com.paluchp.apps.osiris.models.plant;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Data
public class PlantDto {
  private UUID id;
  private String name;
  private String description;
  private UUID image;
  private List<PlantLifeCycleStageDto> stages;
}
