package net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurList;

import net.gamma02.jurassicworldreborn.common.entities.DinosaurEntities.AchillobatorEntity;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.EntityUtils.Diet;
import net.gamma02.jurassicworldreborn.common.util.TimePeriod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class AchillobatorDinosaur extends Dinosaur
{
    public static final double SPEED = 0.4F;
    public AchillobatorDinosaur() {
        super();
        this.setName("Achillobator");
        this.setDinosaurType(DinosaurType.AGGRESSIVE);
        this.setDinosaurClass(AchillobatorEntity.class);
        this.setTimePeriod(TimePeriod.CRETACEOUS);
        this.setEggColorMale(0x7A7268, 0x7E4941);
        this.setEggColorFemale(0xE1DFDC, 0x675C58);
        this.setHealth(6, 40);
        this.setSpeed((SPEED -0.05), SPEED);
        this.setStorage(27);
        this.setStrength(2, 10);
        this.setAttackBias(1200.0);
        this.setAttackSpeed(1.9);
        this.setMaximumAge(fromDays(45));
        this.setEyeHeight(0.45F, 1.6F);
        this.setSizeX(0.5F, 1.0F);
        this.setSizeY(0.5F, 1.8F);
        this.setDiet(Diet.CARNIVORE.get());
        this.setBones("arm_bones", "foot_bones", "leg_bones", "neck_vertebrae", "ribcage", "shoulder", "skull", "claw", "pelvis", "tail_vertebrae", "tooth");
        this.setHeadCubeName("Head");
        this.setScale(1.3F, 0.2F);
        this.setBreeding(false,2, 4, 30, false, true);
        this.setMaxHerdSize(10);
        this.setCanClimb(true);
        this.setImprintable(true);
        this.setDefendOwner(true);
        this.setStorage(27);
        this.setJumpHeight(3);
        this.shouldDefendOffspring();
        String[][] recipe = {
                {"", "","neck_vertebrae","skull"},
                {"tail_vertebrae", "ribcage","shoulder","tooth"},
                {"leg_bones", "leg_bones", "arm_bones", "claw"},
                {"foot_bones", "foot_bones", "", ""}};
        this.setRecipe(recipe);

        ArrayList<ResourceKey<Biome>> biomeList = new ArrayList<>();
        TagKey<Biome>[] tags = (new TagKey[]{ Tags.Biomes.IS_DENSE, BiomeTags.IS_FOREST, BiomeTags.IS_SAVANNA, BiomeTags.IS_JUNGLE});
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
        doSkeletonCheck();
    }

    protected void doSkeletonCheck(){
        this.enableSkeleton();

    }
}
