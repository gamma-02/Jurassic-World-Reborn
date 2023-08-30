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

public class TherizinosaurusDinosaur extends Dinosaur
{
    public static final double SPEED = 0.4F;
    public TherizinosaurusDinosaur()
    {
        super();

        this.setName("Therizinosaurus");
        this.setDinosaurType(DinosaurType.AGGRESSIVE);
        this.setDinosaurClass(TherizinosaurusEntity.class);
        this.setTimePeriod(TimePeriod.CRETACEOUS);
        this.setEggColorMale(0x787878, 0x2B2B2B);
        this.setEggColorFemale(0x7F7F7F, 0x272727);
        this.setHealth(10, 50);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setStrength(10, 35);
        this.setMaximumAge(fromDays(65));
        this.setEyeHeight(0.95F, 5.85F);
        this.setSizeX(0.34F, 2.25F);
        this.setSizeY(0.5F, 5.95F);
        this.setStorage(36);
        this.setDiet(Diet.HERBIVORE.get());
        this.setSleepTime(SleepTime.DIURNAL);
        this.setBones("skull", "teeth", "ribcage", "arm_bones", "claw", "foot_bones", "leg_bones", "neck_vertebrae", "pelvis", "shoulder", "tail_vertebrae");
        this.setHeadCubeName("Head");
        this.setScale(3.5F, 0.1F);
        this.setOffset(0.0F, 1.0F, 0.0F);
        this.setAttackSpeed(1);
        this.setAttackBias(800);
        this.shouldDefendOffspring();
        this.setBreeding(false, 2, 6, 20, false, true);
        this.setImprintable(true);
        this.setDefendOwner(true);
        String[][] recipe =
                {{"", "", "", "neck_vertebrae", "skull"},
                        {"tail_vertebrae", "pelvis", "ribcage","shoulder",""},
                        {"", "leg_bones", "", "arm_bones", ""},
                        {"", "foot_bones", "", "claw", ""}};
        this.setRecipe(recipe);
        this.enableSkeleton();
        ArrayList<ResourceKey<Biome>> biomeList = new ArrayList<>();
        Stream<TagKey<Biome>> tags = Arrays.stream(new TagKey[]{Tags.Biomes.IS_PLAINS, BiomeTags.IS_BADLANDS, BiomeTags.IS_SAVANNA, Tags.Biomes.IS_SANDY});
        ArrayList<Biome> allBiomes = new ArrayList<>(ForgeRegistries.BIOMES.getValues());

        for (Biome biome:
                allBiomes) {
            var key = ForgeRegistries.BIOMES.getResourceKey(biome);
            if(key.isPresent() && tags.anyMatch((tag) -> ForgeRegistries.BIOMES.tags().getTag(tag).contains(biome))){
                biomeList.add(key.get());
            }
        }
        this.setSpawn(1, biomeList);
    }
}
