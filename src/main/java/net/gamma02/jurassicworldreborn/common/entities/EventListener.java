package net.gamma02.jurassicworldreborn.common.entities;

import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.gamma02.jurassicworldreborn.common.blocks.wood.DynamicWoodTypeRegistry;
import net.gamma02.jurassicworldreborn.common.entities.animal.CrabEntity;
import net.gamma02.jurassicworldreborn.common.entities.animal.SharkEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.util.ArrayList;
import java.util.HashMap;

import static net.gamma02.jurassicworldreborn.common.CommonRegistries.*;
import static net.gamma02.jurassicworldreborn.common.entities.ModEntities.CRAB_ENTITY_TYPE;
import static net.gamma02.jurassicworldreborn.common.entities.ModEntities.SHARK_ENTITY_TYPE;

@Mod.EventBusSubscriber(modid = Jurassicworldreborn.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventListener {

    @SubscribeEvent
    public static void registerAttributes(final EntityAttributeCreationEvent event){//lord if this works I swear to god.
        HashMap<EntityType<?>, AttributeSupplier.Builder> typeMap = new HashMap<>();
        ModEntities.MOD_ENTITY_TYPES.getEntries().forEach((type) -> {//what the fuck is this abomination that I have created - gamma
            if(type.get().getBaseClass().isAssignableFrom(LivingEntity.class) && !(type.get() == CRAB_ENTITY_TYPE.get() || type.get() == SHARK_ENTITY_TYPE.get())) {
                AttributeSupplier.Builder supplier = DinosaurEntity.createAttributes();
//                try {
//                    ;if(!(type.get() == CRAB_ENTITY_TYPE.get() || type.get() == SHARK_ENTITY_TYPE.get())) {
//                        event.put(type, DinosaurEntity.createAttributes().build());
//                    }
//                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
                if (supplier != null) {
                    event.put(((EntityType<? extends LivingEntity>) type.get()), supplier.build());
                }
            }
        });
        event.put(CRAB_ENTITY_TYPE.get(), CrabEntity.createAttributes().build());
        event.put(ModEntities.SHARK_ENTITY_TYPE.get(), SharkEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void finalizeSetup(final FMLLoadCompleteEvent evt){
        //Make sure the signs are actually added to the sign block entity
        addBlocksToBlockEntity(BlockEntityType.SIGN, DynamicWoodTypeRegistry.getProductsFromProductTypes(DynamicWoodTypeRegistry.ProductType.SIGN, DynamicWoodTypeRegistry.ProductType.WALL_SIGN));

        //Make our logs able to be stripped
        HashMap<Block, Block> logMap = new HashMap<>();
        ArrayList<WoodType> goneThrough = new ArrayList<>();
        for(WoodType type : modWoodTypes){
            if(goneThrough.contains(type)){
                continue;
            }
            goneThrough.add(type);
            logMap.put(DynamicWoodTypeRegistry.getProductFromWoodType(type, DynamicWoodTypeRegistry.ProductType.LOG), DynamicWoodTypeRegistry.getProductFromWoodType(type, DynamicWoodTypeRegistry.ProductType.STRIPPED_LOG));
            logMap.put(DynamicWoodTypeRegistry.getProductFromWoodType(type, DynamicWoodTypeRegistry.ProductType.WOOD), DynamicWoodTypeRegistry.getProductFromWoodType(type, DynamicWoodTypeRegistry.ProductType.STRIPPED_WOOD));

        }

        addLogsToStrippables(logMap);


    }


}
