package net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities;

import com.github.alexthe666.citadel.animation.Animation;
import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.gamma02.jurassicworldreborn.client.sounds.SoundHandler;
import net.gamma02.jurassicworldreborn.client.render.entity.animation.EntityAnimation;
import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntity;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import net.gamma02.jurassicworldreborn.common.entities.ai.LeapingMeleeEntityAI;
import net.gamma02.jurassicworldreborn.common.entities.ai.RaptorLeapEntityAI;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

import java.util.Locale;

public class CompsognathusEntity extends DinosaurEntity {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(CompsognathusEntity.class, EntityDataSerializers.INT);

    public CompsognathusEntity(Level world, EntityType<CompsognathusEntity> type) {
        super(world, type, DinosaurHandler.COMPSOGNATHUS);
        this.setVariant(this.getRandom().nextInt(6));
        this.doesEatEggs(true);
        this.target(DodoEntity.class, OthnieliaEntity.class, MicroceratusEntity.class, MicroraptorEntity.class, CrassigyrinusEntity.class, LeptictidiumEntity.class, Player.class
, Animal.class, Villager.class, Goat.class);
        this.addTask(0, new LeapingMeleeEntityAI(this, this.dinosaur.getAttackSpeed()));
        this.addTask(1, new RaptorLeapEntityAI(this));
        this.addTask(1, new CompyHurtByTarget());//im sorry what - past gamma_02 | oh, it's a subclass name, i was confuzled - future gamma_02
    }

//    @Override
//    public EntityAIBase getAttackAI() {
//        return new RaptorLeapEntityAI(this);
//    }todo:AI

    @Override
    public int calculateFallDamage(float distance, float damageMultiplier) {
        if (this.getAnimation() != EntityAnimation.LEAP_LAND.get()) {
            return super.calculateFallDamage(distance, damageMultiplier);
        }
        return 0;
    }
    @Override
    public SoundEvent getSoundForAnimation(Animation animation)
    {
        switch (EntityAnimation.getAnimation(animation))
        {
            case SPEAK:
                return SoundHandler.COMPSOGNATHUS_LIVING;
            case DYING:
                return SoundHandler.COMPSOGNATHUS_DEATH;
            case INJURED:
                return SoundHandler.COMPSOGNATHUS_HURT;
            case CALLING:
                return SoundHandler.COMPSOGNATHUS_CALL;
            case BEGGING:
                return SoundHandler.COMPSOGNATHUS_THREAT;
        }

        return null;
    }
    class CompyHurtByTarget extends HurtByTargetGoal {


        public CompyHurtByTarget() {
            super(CompsognathusEntity.this);
        }

        public void start() {
            if (CompsognathusEntity.this.herd.size() >= 3) {
                super.start();
                if (CompsognathusEntity.this.isBaby()) {
                    this.alertOthers();
                    this.stop();
                }
            }
        }

        protected void alertOther(DinosaurEntity creatureIn, LivingEntity LivingEntityIn) {
            if (creatureIn instanceof CompsognathusEntity && !creatureIn.isBaby() && creatureIn != null) {
                super.alertOther(creatureIn, LivingEntityIn);
            }


        }
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("Variant", this.entityData.get(VARIANT));
    }


    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.entityData.set(VARIANT, nbt.getInt("Variant"));
    }

    public void setVariant(int value){
        this.entityData.set(VARIANT, value);
    }

    public int getVariant(){
        return this.entityData.get(VARIANT);
    }

    public ResourceLocation getTexture(){
        switch(getVariant()){
            case 0: default: return texture("nostripes");
            case 1: return texture("stripes");
            case 2: return texture("lightstripes");
            case 3: return texture("orange");
            case 4: return texture("blue");
            case 5: return texture("purple");
        }
    }
    private ResourceLocation texture(String variant){
        String formattedName = this.dinosaur.getName().toLowerCase(Locale.ENGLISH).replaceAll(" ", "_");
        String baseTextures = "textures/entities/" + formattedName + "/";
        String texture = baseTextures + formattedName;
        return isMale()?new ResourceLocation(Jurassicworldreborn.modid, texture + "_male_" + "adult" + "_" + variant + ".png"):new ResourceLocation(Jurassicworldreborn.modid, texture + "_female_" + "adult" + "_" + variant +".png");
    }
}


