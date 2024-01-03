package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import com.github.alexthe666.citadel.animation.Animation;
import net.gamma02.jurassicworldreborn.client.sounds.SoundHandler;
import net.gamma02.jurassicworldreborn.client.render.entity.animation.EntityAnimation;
import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntity;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class GuanlongEntity extends DinosaurEntity {

    public GuanlongEntity(Level world, EntityType<GuanlongEntity> type) {
        super(world, type, DinosaurHandler.GUANLONG);
        this.target(AlvarezsaurusEntity.class, TitanisEntity.class, SmilodonEntity.class, ArsinoitheriumEntity.class, ChilesaurusEntity.class, CoelurusEntity.class, CompsognathusEntity.class, DodoEntity.class, GallimimusEntity.class, HyaenodonEntity.class, HypsilophodonEntity.class, LeaellynasauraEntity.class, LeptictidiumEntity.class, MicroceratusEntity.class, MicroraptorEntity.class, MussaurusEntity.class, OrnithomimusEntity.class, OthnieliaEntity.class, OviraptorEntity.class, SegisaurusEntity.class, TroodonEntity.class, Player.class
, ProtoceratopsEntity.class, Animal.class, Villager.class);
    }

    public SoundEvent getSoundForAnimation(Animation animation) {
        switch (EntityAnimation.getAnimation(animation)) {
            case SPEAK:
                return SoundHandler.GUANLONG_LIVING;
            case DYING:
                return SoundHandler.GUANLONG_DEATH;
            case INJURED:
                return SoundHandler.GUANLONG_HURT;
            default:
                return null;
        }
    }
}

