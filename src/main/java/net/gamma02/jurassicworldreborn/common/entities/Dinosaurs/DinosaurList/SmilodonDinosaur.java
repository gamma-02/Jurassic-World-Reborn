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


public class SmilodonDinosaur extends Dinosaur {
    public static final double SPEED = 0.40F;
    public SmilodonDinosaur() {
        super();

        this.setName("Smilodon");
        this.setDinosaurClass(SmilodonEntity.class);
        this.setDinosaurType(DinosaurType.AGGRESSIVE);
        this.setTimePeriod(TimePeriod.PALEOGENE);
        this.setEggColorMale(0xac7620, 0x191103);
        this.setEggColorFemale(0xc28e3c, 0x4e3208);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setAttackSpeed(1.9);
        this.setHealth(6, 30);
        this.setStrength(4, 10);
        this.setMaximumAge(this.fromDays(45));
        this.setEyeHeight(0.45F, 1.7F);
        this.setSizeX(0.5F, 1.0F);
        this.setSizeY(0.5F, 1.8F);
        this.setStorage(20);
        this.setDiet(Diet.CARNIVORE.get());
        this.setSleepTime(SleepTime.DIURNAL);
        this.setBones("skull", "tail_vertebrae", "front_leg_bones", "ribcage", "hind_leg_bones", "neck_vertebrae", "pelvis", "shoulder", "tooth");
        this.setHeadCubeName("Head");
        this.setScale(0.55F, 0.1F);
        this.setImprintable(true);
        this.setDefendOwner(true);
        this.setBirthType(BirthType.LIVE_BIRTH);
        this.setMammal(true);
        this.setMaxHerdSize(40);
        this.setAttackBias(600.0);
        this.setCanClimb(true);
        this.setBreeding(true,2, 5, 50, false, true);
        this.setJumpHeight(3);
        String[][] recipe =     {
                { "tail_vertebrae", "pelvis", "ribcage","neck_vertebrae", "skull"},
                { "hind_leg_bones", "", "front_leg_bones", "shoulder", "tooth"}};
        this.setRecipe(recipe);
        doSkeletonCheck();
        ArrayList<ResourceKey<Biome>> biomeList = new ArrayList<>();
        TagKey<Biome>[] tags = (new TagKey[]{BiomeTags.IS_SAVANNA, Tags.Biomes.IS_CONIFEROUS, Tags.Biomes.IS_PLAINS, BiomeTags.IS_FOREST, BiomeTags.IS_BADLANDS, Tags.Biomes.IS_SNOWY, Tags.Biomes.IS_COLD});
        ArrayList<Biome> allBiomes = new ArrayList<>(ForgeRegistries.BIOMES.getValues());

        biomeList = new ArrayList<>(allBiomes.stream().filter((biome ->{
            boolean accept = false;
            
            for(var tag : tags){
                if(ForgeRegistries.BIOMES.tags().getTag(tag).contains(biome)){
                    accept = true;
                }
            }
            return accept;
            
        })).map((biome) -> ForgeRegistries.BIOMES.getResourceKey(biome).get()).toList());
        this.setSpawn(1, biomeList);
this.init();
    }

    protected void doSkeletonCheck(){
        this.enableSkeleton();
    }
}
