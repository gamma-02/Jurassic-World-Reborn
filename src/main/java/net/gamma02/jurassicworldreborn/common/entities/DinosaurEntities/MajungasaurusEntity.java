package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import com.github.alexthe666.citadel.animation.Animation;
import net.minecraft.world.entity.animal.goat.Goat;
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

public class MajungasaurusEntity extends DinosaurEntity
{
    public MajungasaurusEntity(Level world, EntityType<MajungasaurusEntity> type)
    {
        super(world, type, DinosaurHandler.MAJUNGASAURUS);
        this.target(AchillobatorEntity.class, SpinoraptorEntity.class, TitanisEntity.class, SmilodonEntity.class, MegatheriumEntity.class, ArsinoitheriumEntity.class, AlligatorGarEntity.class, AlvarezsaurusEntity.class, BaryonyxEntity.class, BeelzebufoEntity.class, VelociraptorBlueEntity.class, CeratosaurusEntity.class, VelociraptorCharlieEntity.class, ChasmosaurusEntity.class, ChilesaurusEntity.class, CoelurusEntity.class, CompsognathusEntity.class, CorythosaurusEntity.class, VelociraptorDeltaEntity.class, DilophosaurusEntity.class, DimorphodonEntity.class, DiplocaulusEntity.class, DodoEntity.class, VelociraptorEchoEntity.class, EdmontosaurusEntity.class, GallimimusEntity.class, GuanlongEntity.class, HerrerasaurusEntity.class, HyaenodonEntity.class, HypsilophodonEntity.class, LambeosaurusEntity.class, LeaellynasauraEntity.class, LeptictidiumEntity.class, MammothEntity.class, MetriacanthosaurusEntity.class, MicroceratusEntity.class, MicroraptorEntity.class, MussaurusEntity.class, OrnithomimusEntity.class, OthnieliaEntity.class, OviraptorEntity.class, PachycephalosaurusEntity.class, RugopsEntity.class, ProtoceratopsEntity.class, ProceratosaurusEntity.class, SegisaurusEntity.class, TroodonEntity.class, VelociraptorEntity.class, Player.class
, Animal.class, Villager.class, Goat.class);
    }

    @Override
    public SoundEvent getSoundForAnimation(Animation animation)
    {
        switch (EntityAnimation.getAnimation(animation))
        {
            case SPEAK:
                return SoundHandler.MAJUNGASAURUS_LIVING;
            case DYING:
                return SoundHandler.MAJUNGASAURUS_DEATH;
            case INJURED:
                return SoundHandler.MAJUNGASAURUS_HURT;
            case CALLING:
                return SoundHandler.MAJUNGASAURUS_CALL;
            case ROARING:
                return SoundHandler.MAJUNGASAURUS_ROAR;
            case BEGGING:
                return SoundHandler.MAJUNGASAURUS_THREAT;
        }

        return null;
    }
    @Override
    public SoundEvent getBreathingSound()
    {
        return SoundHandler.MAJUNGASAURUS_BREATHING;
    }
}

