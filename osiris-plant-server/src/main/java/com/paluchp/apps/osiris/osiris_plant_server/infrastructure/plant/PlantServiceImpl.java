package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;

import com.paluchp.apps.osiris.models.plant.*;
import com.paluchp.apps.osiris.osiris_plant_server.api.plant.PlantService;
import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.exceptions.Ex;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PlantServiceImpl implements PlantService {

  private final PlantEntityRepository repo;
  private final PlantMapper mapper;

  private final PlantLifeCycleStageEntityRepository stageRepo;

  @Override
  public PlantDto createPlant(PlantCreateRequestDto plantCreateRequestDto) {
    PlantEntity entity = mapper.toEntity(plantCreateRequestDto);
    entity.getStages().forEach(stage -> stage.setPlant(entity));

    PlantEntity persisted = repo.save(entity);
    return mapper.toDto(persisted);
  }

  @Override
  public List<PlantDto> getPlants() {
    return repo.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public PlantDto getPlant(UUID plantId) {
    PlantEntity entity =
        repo.findById(plantId).orElseThrow(Ex.notFound(PlantEntity.class, plantId));
    return mapper.toDto(entity);
  }

  @Override
  public PlantDto updatePlant(UUID plantId, PlantUpdateRequestDto plantUpdateRequestDto) {
    PlantEntity entity =
        repo.findById(plantId).orElseThrow(Ex.notFound(PlantEntity.class, plantId));
    mapper.updateEntity(entity, plantUpdateRequestDto);
    PlantEntity persisted = repo.save(entity);
    return mapper.toDto(persisted);
  }

  @Override
  public void deletePlant(UUID plantId) {
    repo.deleteById(plantId);
  }

  @Override
  public PlantLifeCycleStageDto updatePlantStage(
      UUID plantId,
      UUID stageId,
      PlantLifeCycleStageUpdateRequestDto plantLifeCycleStageUpdateRequestDto) {

    PlantLifeCycleStageEntity stageEntity =
        stageRepo.findById(stageId)
            .filter(stage -> stage.getPlant().getId().equals(plantId))
            .orElseThrow(Ex.notFound(PlantLifeCycleStageEntity.class, stageId));
    mapper.updateEntity(stageEntity, plantLifeCycleStageUpdateRequestDto);
    PlantLifeCycleStageEntity persisted = stageRepo.save(stageEntity);
    return mapper.toDto(persisted);
  }
}
