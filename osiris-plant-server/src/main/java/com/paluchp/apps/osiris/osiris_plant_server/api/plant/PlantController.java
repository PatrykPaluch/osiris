package com.paluchp.apps.osiris.osiris_plant_server.api.plant;

import com.paluchp.apps.osiris.api.PlantApi;
import com.paluchp.apps.osiris.models.plant.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class PlantController implements PlantApi {

  private final PlantService plantService;

  @Override
  public ResponseEntity<PlantDto> createPlant(PlantCreateRequestDto plantCreateRequestDto) {
    PlantDto responseDto = plantService.createPlant(plantCreateRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  @Override
  public ResponseEntity<List<PlantDto>> getPlants() {
    List<PlantDto> responseDto = plantService.getPlants();
    return ResponseEntity.ok(responseDto);
  }

  @Override
  public ResponseEntity<PlantDto> getPlant(UUID plantId) {
    PlantDto responseDto = plantService.getPlant(plantId);
    return ResponseEntity.ok(responseDto);
  }

  @Override
  public ResponseEntity<PlantDto> updatePlant(UUID plantId, PlantUpdateRequestDto plantUpdateRequestDto) {
    PlantDto responseDto = plantService.updatePlant(plantId, plantUpdateRequestDto);
    return ResponseEntity.ok(responseDto);
  }

  @Override
  public ResponseEntity<Void> deletePlant(UUID plantId) {
    plantService.deletePlant(plantId);
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<PlantLifeCycleStageDto> updatePlantStage(
      UUID plantId, UUID stageId, PlantLifeCycleStageUpdateRequestDto plantLifeCycleStageUpdateRequestDto) {
    PlantLifeCycleStageDto responseDto =
        plantService.updatePlantStage(plantId, stageId, plantLifeCycleStageUpdateRequestDto);
    return ResponseEntity.ok(responseDto);
  }
}
