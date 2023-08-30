package net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurList;

import java.util.ArrayList;

import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities.*;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Diet;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.FoodType;
import net.gamma02.jurassicworldreborn.common.util.TimePeriod;
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

import java.util.ArrayList;

public class MussaurusDinosaur extends Dinosaur {
    public static final double SPEED = 0.32F;
    public MussaurusDinosaur() {
        super();
        this.setName("Mussaurus");
        this.setDinosaurClass(MussaurusEntity.class);
        this.setDinosaurType(DinosaurType.SCARED);
        this.setFlee(true);
        this.setTimePeriod(TimePeriod.TRIASSIC);
        this.setEggColorMale(0x6F9845, 0x211F16);
        this.setEggColorFemale(0x526024, 0x222611);
        this.setHealth(2, 16);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setStrength(1, 2);
        this.setMaximumAge(this.fromDays(30));
        this.setEyeHeight(0.25F, 1.2F);
        this.setSizeX(0.25F, 1F);
        this.setSizeY(0.2F, 0.9F);
        this.setStorage(9);
        this.setDiet(Diet.HERBIVORE.get());
        this.setBones("arm_bones", "leg_bones", "neck_vertebrae", "pelvis", "ribcage", "shoulder", "skull", "tail_vertebrae", "teeth");
        this.setHeadCubeName("Head1");
        this.setScale(0.6F, 0.1F);
        this.setFlockSpeed(1.10F);
        this.setMaxHerdSize(20);
        this.setAttackBias(-500.0);
        this.setImprintable(true);
        this.setOffset(0.0F, 0.0F, 0.5F);
        this.setBreeding(false, 2, 6, 20, false, true);
        String[][] recipe = {
                        {"", "pelvis", "","",""},
                        {"tail_vertebrae", "ribcage", "shoulder", "neck_vertebrae", "skull"},
                        {"leg_bones", "leg_bones", "arm_bones", "arm_bones", "teeth"}};
        this.setRecipe(recipe);
        
        ArrayList<ResourceKey<Biome>> biomeList = new ArrayList<>();
        Stream<TagKey<Biome>> tags = Arrays.stream(new TagKey[]{ BiomeTags.IS_FOREST, Tags.Biomes.IS_PLAINS});
        ArrayList<Biome> allBiomes = new ArrayList<>(ForgeRegistries.BIOMES.getValues());

        for (Biome biome:
                allBiomes) {
            var key = ForgeRegistries.BIOMES.getResourceKey(biome);
            if(key.isPresent() && tags.anyMatch((tag) -> ForgeRegistries.BIOMES.tags().getTag(tag).contains(biome))){
                biomeList.add(key.get());
            }
        }
        this.setSpawn(1, biomeList);
        this.enableSkeleton();
        
    }
}
