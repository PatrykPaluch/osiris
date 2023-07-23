package com.paluchp.apps.osiris.api;

import com.paluchp.apps.osiris.models.plant.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Valid
@RequestMapping("/plants")
public interface PlantApi {

  @PostMapping
  ResponseEntity<PlantDto> createPlant(
      @Valid @RequestBody PlantCreateRequestDto plantCreateRequestDto);

  // TODO add pagination & search
  @GetMapping
  ResponseEntity<List<PlantDto>> getPlants();

  @GetMapping("{plantId}")
  ResponseEntity<PlantDto> getPlant(@PathVariable("plantId") UUID plantId);

  @PutMapping("{plantId}")
  ResponseEntity<PlantDto> updatePlant(
      @PathVariable("plantId") UUID plantId,
      @Valid @RequestBody PlantUpdateRequestDto plantUpdateRequestDto);

  @DeleteMapping("{plantId}")
  ResponseEntity<Void> deletePlant(UUID plantId);

  @PutMapping("{plantId}/stages/{stageId}")
  ResponseEntity<PlantLifeCycleStageDto> updatePlantStage(
      @PathVariable("plantId") UUID plantId,
      @PathVariable("stageId") UUID stageId,
      @Valid @RequestBody PlantLifeCycleStageUpdateRequestDto plantLifeCycleStageUpdateRequestDto);

}
