package com.paluchp.apps.osiris.models.error;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Data
public class ConstraintViolationResponseDto {
  private List<ViolationDto> violations;
}
