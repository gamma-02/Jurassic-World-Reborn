package net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurList;


import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities.*;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Diet;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.SleepTime;
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

public class TylosaurusDinosaur extends Dinosaur
{
    public static final double SPEED = 0.75F;
    public TylosaurusDinosaur()
    {
        super();

        this.setName("Tylosaurus");
        this.setDinosaurType(DinosaurType.NEUTRAL);
        this.setDinosaurClass(TylosaurusEntity.class);
        this.setTimePeriod(TimePeriod.CRETACEOUS);
        this.setEggColorMale(0x187D75, 0x15544F);
        this.setEggColorFemale(0x798A8F, 0x101517);
        this.setHealth(10, 40);
        this.setSpeed((SPEED -0.65), SPEED);
        this.setStrength(5, 30);
        this.setMaximumAge(fromDays(60));
        this.setEyeHeight(0.35F, 2.35F);
        this.setSizeX(0.45F, 4.5F);
        this.setSizeY(0.25F, 2.95F);
        this.setStorage(54);
        this.setDiet((Diet.CARNIVORE.get()));
        this.setBones("front_flipper", "hind_flipper", "inner_teeth", "ribcage", "skull", "spine", "tail_fluke", "tail_vertebrae", "tooth");
        this.setHeadCubeName("Main head");
        this.setScale(2.2F, 0.15F);
        this.setOffset(0.0F, 0.0F, 1.0F);
        this.shouldDefendOffspring();
        this.setBirthType(BirthType.LIVE_BIRTH);
        this.setAttackBias(500);
        this.setMarineAnimal(true);
        this.givesDirectBirth();
        this.setBreeding(true, 1, 4, 60, false, true);
        this.setImprintable(false);
        this.setStorage(54);
        String[][] recipe =     {
                {"tail_fluke", "tail_vertebrae", "spine", "ribcage", "skull"},
                {"", "", "", "inner_teeth", "tooth"},
                {"hind_flipper", "hind_flipper", "", "front_flipper", "front_flipper"}};
        this.setRecipe(recipe);
        this.enableSkeleton();
        ArrayList<ResourceKey<Biome>> biomeList = new ArrayList<>();
        Stream<TagKey<Biome>> tags = Arrays.stream(new TagKey[]{Tags.Biomes.IS_WATER, BiomeTags.IS_OCEAN});
        ArrayList<Biome> allBiomes = new ArrayList<>(ForgeRegistries.BIOMES.getValues());

        for (Biome biome:
                allBiomes) {
            var key = ForgeRegistries.BIOMES.getResourceKey(biome);
            if(key.isPresent() && tags.anyMatch((tag) -> ForgeRegistries.BIOMES.tags().getTag(tag).contains(biome))){
                biomeList.add(key.get());
            }
        }
        this.setSpawn(1, biomeList);    }
}
