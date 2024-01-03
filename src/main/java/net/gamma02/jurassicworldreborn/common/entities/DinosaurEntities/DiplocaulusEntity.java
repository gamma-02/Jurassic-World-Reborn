package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import net.gamma02.jurassicworldreborn.common.entities.SwimmingDinosaurEntity;import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class DiplocaulusEntity extends SwimmingDinosaurEntity {

    public DiplocaulusEntity(Level world, EntityType<DiplocaulusEntity> type) {
        super(world, type, DinosaurHandler.DIPLOCAULUS);
        this.target(AlvarezsaurusEntity.class, BeelzebufoEntity.class, Squid.class, CompsognathusEntity.class, LeptictidiumEntity.class);
    }
}

