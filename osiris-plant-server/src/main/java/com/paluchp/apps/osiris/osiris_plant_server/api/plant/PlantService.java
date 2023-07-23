package com.paluchp.apps.osiris.osiris_plant_server.api.plant;

import com.paluchp.apps.osiris.models.plant.*;

import java.util.List;
import java.util.UUID;

public interface PlantService {
  PlantDto createPlant(PlantCreateRequestDto plantCreateRequestDto);

  List<PlantDto> getPlants();

  PlantDto getPlant(UUID plantId);

  PlantDto updatePlant(UUID plantId, PlantUpdateRequestDto plantUpdateRequestDto);

  void deletePlant(UUID plantId);

  PlantLifeCycleStageDto updatePlantStage(
      UUID plantId, UUID stageId, PlantLifeCycleStageUpdateRequestDto plantLifeCycleStageUpdateRequestDto);
}
