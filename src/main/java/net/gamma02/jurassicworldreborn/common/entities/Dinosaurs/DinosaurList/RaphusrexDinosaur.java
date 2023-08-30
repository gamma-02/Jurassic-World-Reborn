package net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurList;

import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities.*;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Diet;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Hybrid;
import net.gamma02.jurassicworldreborn.common.util.TimePeriod;
import java.util.ArrayList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

public class RaphusrexDinosaur extends Dinosaur implements Hybrid {
    public static final double SPEED = 0.42F;
    public RaphusrexDinosaur() {
        super();

        this.setName("RaphusRex");
        this.setDinosaurClass(RaphusrexEntity.class);
        this.setDinosaurType(DinosaurType.AGGRESSIVE);
        this.setTimePeriod(TimePeriod.NONE);
        this.setEggColorMale(0x5d4625, 0x18283c);
        this.setEggColorFemale(0x5d4625, 0x382014);
        this.setHealth(10, 80);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setAttackSpeed(2);
        this.setStrength(5, 25);
        this.setMaximumAge(this.fromDays(60));
        this.setEyeHeight(0.6F, 3.8F);
        this.setSizeX(0.2F, 3.0F);
        this.setSizeY(0.4F, 4.0F);
        this.setStorage(54);
        this.setDiet(Diet.CARNIVORE.get());
        this.setBones("arm_bones", "foot_bones", "leg_bones", "neck_vertebrae", "pelvis", "ribcage", "shoulder", "skull", "tail_vertebrae", "tooth");
        this.setHeadCubeName("Head");
        this.setScale(2.4F, 0.1F);
        this.setMaxHerdSize(4);
        this.setAttackBias(1000.0);
        this.setImprintable(true);
        this.setHybrid();
        this.setDefendOwner(true);
        this.setBreeding(false, 2, 4, 60, false, true);

        String[][] recipe = {
                {"", "", "","neck_vertebrae","skull"},
                {"tail_vertebrae", "pelvis", "ribcage","shoulder","tooth"},
                {"", "leg_bones", "leg_bones", "arm_bones", ""},
                {"", "foot_bones", "foot_bones", "", ""}};
        this.setRecipe(recipe);
        this.enableSkeleton();

    }
    public Class<? extends Dinosaur>[] getDinosaurs() {
        return new Class[]{TyrannosaurusDinosaur.class, DodoDinosaur.class};
    }
}
