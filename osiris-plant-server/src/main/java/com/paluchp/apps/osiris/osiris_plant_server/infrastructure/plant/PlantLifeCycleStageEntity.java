package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;

import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.BaseEntity;
import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.enums.Frequency;
import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.enums.PlantLifeCycleStage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "plant_life_cycle_stage")
public class PlantLifeCycleStageEntity extends BaseEntity {

  @Enumerated(EnumType.STRING)
  private PlantLifeCycleStage stage;

  @ManyToOne(fetch = FetchType.LAZY)
  private PlantEntity plant;
  private String description;
  private int groundMoistureMin;
  private int groundMoistureMax;
  private int airMoistureMin;
  private int airMoistureMax;
  private int temperatureMin;
  private int temperatureMax;
  @Enumerated(EnumType.STRING)
  private Frequency wateringFrequency;
}
