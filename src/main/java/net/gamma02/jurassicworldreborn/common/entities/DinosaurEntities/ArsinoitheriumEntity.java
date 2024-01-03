package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import com.github.alexthe666.citadel.animation.Animation;
import net.gamma02.jurassicworldreborn.client.sounds.SoundHandler;
import net.gamma02.jurassicworldreborn.client.render.entity.animation.EntityAnimation;
import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntity;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class ArsinoitheriumEntity extends DinosaurEntity
{
    public ArsinoitheriumEntity(Level world, EntityType<ArsinoitheriumEntity> type) { super(world, type, DinosaurHandler.ARSINOITHERIUM); }
    public SoundEvent getSoundForAnimation(Animation animation) {

        switch (EntityAnimation.getAnimation(animation)) {
            case SPEAK:
                return SoundHandler.ARSINOITHERIUM_LIVING;
            case CALLING:
                return SoundHandler.ARSINOITHERIUM_LIVING;
            case MATING:
                return SoundHandler.ARSINOITHERIUM_THREAT;
            case DYING:
                return SoundHandler.ARSINOITHERIUM_DEATH;
            case INJURED:
                return SoundHandler.ARSINOITHERIUM_HURT;
            case BEGGING:
                return SoundHandler.ARSINOITHERIUM_THREAT;
            default:
                return null;
        }
    }
}

