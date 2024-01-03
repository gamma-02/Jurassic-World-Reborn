package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import net.gamma02.jurassicworldreborn.client.sounds.SoundHandler;
import net.gamma02.jurassicworldreborn.client.render.entity.animation.EntityAnimation;
import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntity;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import com.github.alexthe666.citadel.animation.LegSolver;
import com.github.alexthe666.citadel.animation.LegSolverQuadruped;
import com.github.alexthe666.citadel.animation.Animation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class TriceratopsEntity extends DinosaurEntity {
    public LegSolverQuadruped legSolver;

    public TriceratopsEntity(Level world, EntityType<TriceratopsEntity> type) {
        super(world, type, DinosaurHandler.TRICERATOPS);
    }

    @Override
    protected LegSolver createLegSolver() {
        return this.legSolver = new LegSolverQuadruped(0.2F, 1.2F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public SoundEvent getSoundForAnimation(Animation animation) {
        switch (EntityAnimation.getAnimation(animation)) {
            case SPEAK:
                return SoundHandler.TRICERATOPS_LIVING;
            case CALLING:
                return SoundHandler.TRICERATOPS_LIVING;
            case DYING:
                return SoundHandler.TRICERATOPS_DEATH;
            case INJURED:
                return SoundHandler.TRICERATOPS_HURT;
		default:
			break;
        }

        return null;
    }
}

