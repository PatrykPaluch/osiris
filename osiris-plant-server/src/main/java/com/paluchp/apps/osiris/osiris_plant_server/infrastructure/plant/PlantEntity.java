package com.paluchp.apps.osiris.osiris_plant_server.infrastructure.plant;


import com.paluchp.apps.osiris.osiris_plant_server.infrastructure.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "plant")
public class PlantEntity extends BaseEntity {
  private String name;
  private String description;
  private UUID image;

  @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
  private List<PlantLifeCycleStageEntity> stages;
}
