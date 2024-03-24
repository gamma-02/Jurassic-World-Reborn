package net.gamma02.jurassicworldreborn.common.items;

import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.gamma02.jurassicworldreborn.client.sounds.SoundHandler;
import net.gamma02.jurassicworldreborn.common.blocks.ModBlocks;
import net.gamma02.jurassicworldreborn.common.blocks.ancientplants.AncientPlantBlock;
import net.gamma02.jurassicworldreborn.common.blocks.entities.paleobale.PaleoBaleBlock;
import net.gamma02.jurassicworldreborn.common.blocks.fossil.AncientCoralBlock;
import net.gamma02.jurassicworldreborn.common.blocks.wood.DynamicWoodTypeRegistry;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.DinosaurHandler;
import net.gamma02.jurassicworldreborn.common.items.Food.DinosaurMeatItem;
import net.gamma02.jurassicworldreborn.common.items.Fossils.EncasedFaunaFossilBlockItem;
import net.gamma02.jurassicworldreborn.common.items.Fossils.FaunaFossilBlockItem;
import net.gamma02.jurassicworldreborn.common.items.Fossils.FossilItem;
import net.gamma02.jurassicworldreborn.common.items.Fossils.PlasterAndBandageItem;
import net.gamma02.jurassicworldreborn.common.items.genetics.*;
import net.gamma02.jurassicworldreborn.common.items.misc.ActionFigureItem;
import net.gamma02.jurassicworldreborn.common.items.misc.SwarmItem;
import net.gamma02.jurassicworldreborn.common.plants.Plant;
import net.gamma02.jurassicworldreborn.common.plants.PlantHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

public class ModItems {
    public static void init(){

    }

    public static DeferredRegister<Item> modItems = DeferredRegister.create(ForgeRegistries.ITEMS, Jurassicworldreborn.modid);
    public static DeferredRegister<Item> modBlockItems = modItems;



//    public static RegistryObject<Item> ARAUCARIA_SAPLING = modBlockItems.register("araucaria_sapling", () -> new BlockItem(ModBlocks.AraucariaSapling.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

//    public static RegistryObject<Item> GINKGO_SAPLING = modBlockItems.register("ginkgo_sapling", () -> new BlockItem(ModBlocks.GinkgoSapling.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

//    public static RegistryObject<Item> CALAMITES_SAPLING = modBlockItems.register("calamites_sapling", () -> new BlockItem(ModBlocks.CalamitesSapling.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

//    public static RegistryObject<Item> PHOENIX_SAPLING = modBlockItems.register("phoenix_sapling", () -> new BlockItem(ModBlocks.PhoenixSapling.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

//    public static RegistryObject<Item> PSARONIUS_SAPLING = modBlockItems.register("psarons_sapling", () -> new BlockItem(ModBlocks.PsaroniusSapling.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
//
    public static RegistryObject<Item> PLASTER_AND_BANDAGE = modItems.register("plaster_and_bandage", () -> new PlasterAndBandageItem(new Item.Properties().tab(TabHandler.ITEMS)));

    public static RegistryObject<Item> MOSQUITO_AMBER = modItems.register("amber_mosquito", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));
    public static RegistryObject<Item> APHID_AMBER = modItems.register("amber_aphid", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));

    public static RegistryObject<Item> SEA_LAMPREY = modItems.register("sea_lamprey", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));

    public static RegistryObject<Item> ENCASED_FAUNA_FOSSIL = modItems.register("encased_fauna_item", () -> new EncasedFaunaFossilBlockItem(ModBlocks.ENCASED_FAUNA_FOSSIL.get(), new Item.Properties().tab(TabHandler.FOSSILS)));

//    public static RegistryObject<Item> DEFAULT_BONE = modItems.register("missing_bone", () -> new Item(new Item.Properties()));

    public static final FoodProperties SHARK_MEAT_RAW_PROP = new FoodProperties.Builder().meat().nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties SHARK_MEAT_COOKED_PROP = new FoodProperties.Builder().meat().nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties CRAB_MEAT_RAW_PROP = new FoodProperties.Builder().meat().nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties CRAB_MEAT_COOKED_PROP = new FoodProperties.Builder().meat().nutrition(5).saturationMod(0.6F).build();

    public static final RegistryObject<Item> SHARK_MEAT_RAW = modItems.register("raw_shark_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(SHARK_MEAT_RAW_PROP)));
    public static final RegistryObject<Item> SHARK_MEAT_COOKED = modItems.register("cooked_shark_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(SHARK_MEAT_COOKED_PROP)));
    public static final RegistryObject<Item> CRAB_MEAT_RAW = modItems.register("raw_crab_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CRAB_MEAT_RAW_PROP)));
    public static final RegistryObject<Item> CRAB_MEAT_COOKED = modItems.register("cooked_crab_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(CRAB_MEAT_COOKED_PROP)));

    public static final FoodProperties GOAT_RAW_PROP = new FoodProperties.Builder().meat().nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties GOAT_COOKED_PROP = new FoodProperties.Builder().meat().nutrition(6).saturationMod(10.3F).build();
    public static final RegistryObject<Item> GOAT_RAW = modItems.register("raw_goat_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(GOAT_RAW_PROP)));
    public static final RegistryObject<Item> GOAT_COOKED = modItems.register("cooked_goat_meat", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(GOAT_COOKED_PROP)));


    public static final RegistryObject<SwarmItem> PLANKTON = modBlockItems.register("plankton", () -> new SwarmItem(ModBlocks.PLANKTON_SWARM.get(), new Item.Properties().tab(TabHandler.ITEMS)));
    public static final RegistryObject<SwarmItem> KRILL = modBlockItems.register("krill", () -> new SwarmItem(ModBlocks.KRILL_SWARM.get(), new Item.Properties().tab(TabHandler.ITEMS)));

    public static final RegistryObject<RecordItem> JURASSICRAFT_THEME_DISC = modBlockItems.register("disc_jurassicraft_theme", () -> new RecordItem(101/*dont ask*/, () -> SoundHandler.JURASSICRAFT_THEME, new Item.Properties().tab(TabHandler.ITEMS), 4740));
    public static final RegistryObject<RecordItem> TROODONS_AND_RAPTORS_DISC = modBlockItems.register("disc_troodons_and_raptors", () -> new RecordItem(102, () -> SoundHandler.TROODONS_AND_RAPTORS, new Item.Properties().tab(TabHandler.ITEMS), 1760));
    public static final RegistryObject<RecordItem> DONT_MOVE_A_MUSCLE_DISC = modBlockItems.register("disc_dont_move_a_muscle", () -> new RecordItem(103, () -> SoundHandler.DONT_MOVE_A_MUSCLE, new Item.Properties().tab(TabHandler.ITEMS), 2040));

//    public static final RegistryObject<DNAItem> DNA = modItems.register("dna", () -> new DNAItem(new Item.Properties().tab(TabHandler.ITEMS)));
    public static final RegistryObject<PlantDNAItem> PLANT_DNA = modItems.register("plant_dna", () -> new PlantDNAItem(PlantHandler.EMPTY, new Item.Properties().tab(TabHandler.ITEMS)));

    public static final RegistryObject<StorageDiscItem> STORAGE_DISC = modItems.register("storage_disc", () -> new StorageDiscItem(new Item.Properties().tab(TabHandler.ITEMS)));

    public static final RegistryObject<BlockItem> GYPSUM_BRICKS = registerBlockItem("gypsum_bricks", ModBlocks.GYPSUM_BRICKS);

    public static final RegistryObject<ActionFigureItem> DISPLAY_BLOCK = modItems.register("display_block_item", () -> new ActionFigureItem(new Item.Properties().tab(TabHandler.DECORATIONS)));

    public static final RegistryObject<Item> FROZEN_LEECH_ITEM = modItems.register("frozen_leech", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));

    public static final RegistryObject<Item> EMPTY_TEST_TUBE = modItems.register("empty_test_tube", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));

    public static final RegistryObject<Item> DNA_NUCLEOTIDES = modItems.register("dna_base_material", () -> new Item(new Item.Properties().tab(TabHandler.ITEMS)));

//    public static final RegistryObject<SoftTissueItem> SOFT_TISSUE = modItems.register("soft_tissue");

//    public static final RegistryObject<DinosaurEggItem> DINO_EGG = modItems.register("none_egg_item", () -> new DinosaurEggItem(new Item.Properties().tab(TabHandler.DNA), Dinosaur.EMPTY));

    public static final RegistryObject<FaunaFossilBlockItem> FAUNA_FOSSIL_BLOCK = modBlockItems.register("fauna_fossil_block_item", () -> new FaunaFossilBlockItem(ModBlocks.FAUNA_FOSSIL.get(), new Item.Properties().tab(TabHandler.FOSSILS)));





    static{



//
        for(WoodType woodType : DynamicWoodTypeRegistry.woodTypes){
            for(DynamicWoodTypeRegistry.ProductType type : DynamicWoodTypeRegistry.ProductType.vals()){
    //            Block block = DynamicWoodTypeRegistry.getProductFromWoodType(woodType, type);
                if(type == DynamicWoodTypeRegistry.ProductType.WALL_SIGN){
                    continue;
                }else if(type == DynamicWoodTypeRegistry.ProductType.SIGN){
                    modItems.register(woodType.name() + "_" + type.getProductName(), () -> type.signItemFunction.apply(DynamicWoodTypeRegistry.getProductFromWoodType(woodType, DynamicWoodTypeRegistry.ProductType.SIGN), DynamicWoodTypeRegistry.getProductFromWoodType(woodType, DynamicWoodTypeRegistry.ProductType.WALL_SIGN)));
                    continue;
                }
                modItems.register(woodType.name() + "_" + type.getProductName(), () -> type.itemFunction.apply(DynamicWoodTypeRegistry.getProductFromWoodType(woodType, type)));

            }
        }
    }

    public static final ArrayList<RegistryObject<BlockItem>> modBlocks = new ArrayList<>();

    public static final HashMap<Dinosaur, RegistryObject<DinosaurEggItem>> dinoEggs = new LinkedHashMap<>();
    public static final HashMap<Dinosaur, RegistryObject<HatchedEggItem>> hatchedDinoEggs = new LinkedHashMap<>();





    public static HashMap<Dinosaur, LinkedHashMap<String, RegistryObject<Item>>> BONES = new HashMap<>();
    public static HashMap<Dinosaur, LinkedHashMap<String, RegistryObject<Item>>> FRESH_BONES = new HashMap<>();
    public static ArrayList<RegistryObject<Item>> ALL_BONES = new ArrayList<>();
    public static HashMap<Dinosaur, RegistryObject<DNAItem>> DINOSAUR_DNA = new HashMap<>();
    public static HashMap<Dinosaur, RegistryObject<SoftTissueItem>> SOFT_TISSUE = new HashMap<>();
    public static HashMap<Dinosaur, RegistryObject<Item>> MEATS = new HashMap<>();
    public static HashMap<Dinosaur, RegistryObject<Item>> STEAKS = new HashMap<>();

    public static ArrayList<Supplier<Item>> ALL_MEATS = new ArrayList<>();
    public static ArrayList<String> USED_IDS = new ArrayList<>();
    public static HashMap<Plant, RegistryObject<Item>> PLANT_DNAS = new HashMap<>();

    public static void register(IEventBus bus) {

        //make sure all the dinosaurs are registered :D
//        DinosaurHandler.doDinosInit();

        //automatically register all the blocks :)

        for(RegistryObject<Block>/*auto*/ a : ModBlocks.modBlocks.getEntries()){
//            System.out.println(a.getId());
            ResourceLocation location = a.getId();
            if(compare(location)){
                continue;
            }
            String name = correct(location.getPath());
//            String name = location.getPath().contains("block") ? location.getPath().replace("block", "item") : location.getPath().concat("_item");
//            System.out.println(name);

            modBlocks.add(registerBlockItem(location.getPath(), a));
        }


        for(Dinosaur a : Dinosaur.DINOSAUR_IDS.keySet()){

            String dinoName = a.getName();

            String formattedName = dinoName.toLowerCase(Locale.ROOT).replaceAll(" ", "_");

            String path = dinoName.toLowerCase(Locale.ROOT).replaceAll(" ", "_");

            if(a == Dinosaur.EMPTY)
                continue;

            RegistryObject<SoftTissueItem> softTissue = modItems.register("soft_tissue/soft_tissue_" + formattedName, () -> new SoftTissueItem(new Item.Properties().tab(TabHandler.DNA), a));
            if(!a.givesDirectBirth()) {

                RegistryObject<DinosaurEggItem> egg = modItems.register("egg/egg_" + path, () -> new DinosaurEggItem(new Item.Properties(), a));
                dinoEggs.put(a, egg);

            }
            
            RegistryObject<HatchedEggItem> hatchedEgg = modItems.register("hatched_egg/egg_" + path, () -> new HatchedEggItem(new Item.Properties(), a));
            RegistryObject<DNAItem> dinoDna = modItems.register("dna/dna_" + formattedName, () -> new DNAItem(new Item.Properties(), a));


            SOFT_TISSUE.put(a, softTissue);
            DINOSAUR_DNA.put(a, dinoDna);

            hatchedDinoEggs.put(a, hatchedEgg);


            //Register other dinosaur-dependent items
            registerFossilBonesForDino(a);
            registerFreshBonesForDino(a);
            registerMeatsForDino(a);

        }

        for(Plant p : PlantHandler.getPrehistoricPlantsAndTrees()){
            String name = p.getFormattedName();

            name = "dna/plants/dna_".concat(name);

            PLANT_DNAS.put(p, modItems.register(name, () -> new PlantDNAItem(p, new Item.Properties())));


        }

        modItems.register(bus);

//        System.out.println("Registering blocks");




//        modBlockItems.register(bus);
    }


    private static String correct(String path) {//wtf - gamma
        return path;
    }

    private static boolean compare(ResourceLocation location) {
        return location.getPath().equals("display_block") || location.getPath().equals("gypsum_bricks");
    }


    @Nullable
    public static RegistryObject<Item> registerSingleBone(String boneName, Supplier<Item> sup, Dinosaur dino, boolean fresh){
//        BONES.put(dino, modItems.register(dino.getName().toUpperCase(Locale.ROOT).concat(":").concat(boneName), sup));//this is going to error. Need arrayList of bones, this will do for now
        if(dino == DinosaurHandler.BLUE || dino == DinosaurHandler.CHARLIE || dino == DinosaurHandler.DELTA || dino == DinosaurHandler.ECHO){
            return null;
        }
        String formattedDinoName = dino.getName().toLowerCase().replaceAll(" ", "_");
        String id = "/" + formattedDinoName + "_" + boneName;
        if(fresh){
            id = "fresh_bones".concat(id);
        }else{
            id = "bones".concat(id);
        }
//        if(( (boneName.equals("skull") && !skullExemptDinos.contains(formattedDinoName) ) ||( boneName.equals("tooth") && teethDinos.contains(formattedDinoName)) ) && !fresh ){
//            id = "fossil/" + boneName + "_" + formattedDinoName;
//        }



        try {
            if(USED_IDS.contains(id))
                return null;
            USED_IDS.add(id);
            RegistryObject<Item> item = modItems.register(id, sup);
            ALL_BONES.add(item);
            return item;
        }catch(IllegalArgumentException e){
            Jurassicworldreborn.getLogger().error("GOT YEETED BY " + e);
//            e.printStackTrace();
        }

        return null;
    }

    public static void registerFossilBonesForDino(Dinosaur dinosaur){

        if(dinosaur.isHybrid || dinosaur == Dinosaur.EMPTY || dinosaur.getBones() == null)//make sure the dinosaur isn't a hybrid
            return;



        LinkedHashMap<String, RegistryObject<Item>> DINO_BONES = new LinkedHashMap<>();
        for(String s : dinosaur.getBones()){
            RegistryObject<Item> item = registerSingleBone(s, () -> new FossilItem(new Item.Properties().tab(TabHandler.FOSSILS), s, false, dinosaur), dinosaur, false);
            if(item != null)
                DINO_BONES.put(s, item);
        }
        BONES.put(dinosaur, DINO_BONES);
    }

    public static void registerFreshBonesForDino(Dinosaur dino){

        LinkedHashMap<String, RegistryObject<Item>> fresh_bones = new LinkedHashMap<>();
        if(dino.getBones() == null){
            return;
        }
        for(String s : dino.getBones()){
            RegistryObject<Item> item = registerSingleBone(s, () -> new FossilItem(new Item.Properties().tab(TabHandler.FOSSILS), s, true, dino), dino, true);
            if(item != null)
                fresh_bones.put(s, item);
        }

        FRESH_BONES.put(dino, fresh_bones);
    }


    public static RegistryObject<Item> registerSingleRawMeat(Supplier<Item> sup, Dinosaur dino){
        return modItems.register("meat/meat_" + dino.getName().toLowerCase(Locale.ROOT).replaceAll(" ", "_"), sup);

    }

    public static RegistryObject<Item> registerSingleSteak(Supplier<Item> sup, Dinosaur dino){
        return modItems.register("meat/steak_" + dino.getName().toLowerCase().replaceAll(" ", "_"), sup);
    }

    public static void registerMeatsForDino(Dinosaur dino){
        List<MobEffectInstance> cookedEffects = dino.applyMeatEffect(new ArrayList<>(), true);
        FoodProperties.Builder cookedProperties = new FoodProperties.Builder().nutrition(8).meat();
        for(MobEffectInstance i : cookedEffects){
            cookedProperties.effect(() -> i, 0.9f);
        }

        List<MobEffectInstance> rawEffects = dino.applyMeatEffect(new ArrayList<>(), false);
        FoodProperties.Builder rawProperties = new FoodProperties.Builder().nutrition(3).meat();
        for(MobEffectInstance i : rawEffects){
            rawProperties.effect(() -> i, 0.9f);
        }
        RegistryObject<Item> rawMeat = registerSingleRawMeat(() -> new DinosaurMeatItem(new Item.Properties().food(rawProperties.build()).tab(TabHandler.FOODS), false, dino), dino);
        RegistryObject<Item> steak = registerSingleSteak(() -> new DinosaurMeatItem(new Item.Properties().food(cookedProperties.build()).tab(TabHandler.FOODS), true, dino), dino);
        MEATS.put(dino, rawMeat);
        STEAKS.put(dino, steak);
        ALL_MEATS.add(rawMeat);
        ALL_MEATS.add(steak);
    }

    public static RegistryObject<BlockItem> registerBlockItem(String name, Block block){

        final CreativeModeTab tab;
        if( block instanceof AncientPlantBlock || block instanceof AncientCoralBlock || block instanceof PaleoBaleBlock){
            tab = CreativeModeTab.TAB_DECORATIONS;
        }else{
            tab = CreativeModeTab.TAB_BUILDING_BLOCKS;
        }

        return modItems.register(name, () -> new BlockItem(block, new Item.Properties().tab(tab)));
    }

    public static RegistryObject<BlockItem> registerBlockItem(String name, Supplier<Block> block){

        final CreativeModeTab tab;
        if( block instanceof AncientPlantBlock || block instanceof AncientCoralBlock || block instanceof PaleoBaleBlock){
            tab = CreativeModeTab.TAB_DECORATIONS;
        }else{
            tab = TabHandler.BLOCKS;
        }

        return modItems.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


}
