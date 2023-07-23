package com.paluchp.apps.osiris.models.plant;

import com.paluchp.apps.osiris.bean_validations.AllPlantStages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Data
public class PlantCreateRequestDto {

  @NotNull
  @Size(min = 3, max = 255)
  private String name;

  @NotNull
  @Size(max = 255)
  private String description;

  private UUID image;

  @NotNull
  @AllPlantStages
  private List<@Valid PlantLifeCycleStageCreateDto> stages;
}
