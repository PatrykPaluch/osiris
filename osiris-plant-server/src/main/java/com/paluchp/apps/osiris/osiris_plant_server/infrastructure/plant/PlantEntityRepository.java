package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlantEntityRepository extends ListCrudRepository<PlantEntity, UUID> {
}
