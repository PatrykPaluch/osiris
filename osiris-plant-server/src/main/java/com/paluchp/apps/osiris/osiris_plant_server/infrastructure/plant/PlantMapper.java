package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;

import com.paluchp.apps.osiris.models.plant.*;
import com.paluchp.apps.osiris.osiris_plant_server.CentralMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = CentralMapperConfig.class)
public interface PlantMapper {

  PlantEntity toEntity(PlantCreateRequestDto plantDto);

  void updateEntity(@MappingTarget PlantEntity plantEntity, PlantUpdateRequestDto plantDto);

  PlantDto toDto(PlantEntity plantEntity);

  PlantLifeCycleStageDto toDto(PlantLifeCycleStageEntity plantLifeCycleStageEntity);

  void updateEntity(
      @MappingTarget PlantLifeCycleStageEntity plantLifeCycleStageEntity,
      PlantLifeCycleStageUpdateRequestDto plantLifeCycleStageUpdateRequestDto);

}
