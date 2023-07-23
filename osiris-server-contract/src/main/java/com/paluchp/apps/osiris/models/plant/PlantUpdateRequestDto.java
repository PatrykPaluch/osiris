package com.paluchp.apps.osiris.models.plant;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Data
public class PlantUpdateRequestDto {

  @NotNull
  @Size(min = 3, max = 255)
  private String name;

  @NotNull
  @Size(max = 255)
  private String description;

  private UUID image;
}
