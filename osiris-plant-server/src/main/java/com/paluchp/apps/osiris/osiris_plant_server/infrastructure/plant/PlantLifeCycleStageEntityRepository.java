package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;

import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.enums.PlantLifeCycleStage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlantLifeCycleStageEntityRepository extends CrudRepository<PlantLifeCycleStageEntity, UUID> {

  List<PlantLifeCycleStageEntity> findAllByPlantId(UUID plantId);

  Optional<PlantLifeCycleStageEntity> findByPlantIdAndStage(UUID plantId, PlantLifeCycleStage stage);
}
