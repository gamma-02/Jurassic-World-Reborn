package net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurList;

import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities.*;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Diet;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Hybrid;
import net.gamma02.jurassicworldreborn.common.util.TimePeriod;
import java.util.ArrayList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;


public class IndoraptorDinosaur extends Dinosaur implements Hybrid
{
    private ResourceLocation texture;
    public static final double SPEED = 0.45F;

    public IndoraptorDinosaur()
    {
        super();

        this.setName("Indoraptor");
        this.setDinosaurType(DinosaurType.AGGRESSIVE);
        this.setDinosaurClass(IndoraptorEntity.class);
        this.setTimePeriod(TimePeriod.NONE); //TODO, it's a hybrid, what do you do here?
        this.setEggColorMale(0x787878, 0x2B2B2B);
        this.setEggColorFemale(0xE1DFDC, 0x675C58);
        this.setHealth(8, 44);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setStrength(2, 15);
        this.setMaximumAge(fromDays(30));
        this.setEyeHeight(0.55F, 5.4F);
        this.setSizeX(0.2F, 2.8F);
        this.setSizeY(0.2F, 4F);
        this.setStorage(54);
        this.setAttackSpeed(1.6);
        this.setDiet((Diet.CARNIVORE.get()));
        this.setBones( "front_leg_bones", "hind_leg_bones", "foot_bones", "neck_vertebrae", "claw", "pelvis", "ribcage", "shoulder", "skull", "tail_vertebrae", "tooth");
        this.setHeadCubeName("Head");
        this.setScale(1.4F, 0.15F);
        this.setAttackBias(4000);
        this.setBreeding(false, 0, 0, 999, false, false);
        this.setHybrid();
        this.setCanClimb(true);
        this.setJumpHeight(3);
        this.setDefendOwner(true);
        this.setImprintable(true);
        String[][] recipe = {
                {"", "", "","neck_vertebrae","skull"},
                {"tail_vertebrae", "pelvis", "ribcage","shoulder","tooth"},
                {"", "hind_leg_bones", "", "front_leg_bones", "claw"},
                {"", "foot_bones", "", "", ""}};
        this.setRecipe(recipe);
        this.enableSkeleton();

    }

    @Override
    public Class<? extends Dinosaur>[] getDinosaurs() {
        return new Class[]{IndominusDinosaur.class, VelociraptorDinosaur.class};
    }
}
