package net.gamma02.jurassicworldreborn.common.network;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gamma02.jurassicworldreborn.client.screens.ModScreens;
import net.gamma02.jurassicworldreborn.common.blocks.entities.ModBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class OpenContainerScreenGuiS2CPacket<B extends BlockEntity> implements ModPacket<OpenContainerScreenGuiS2CPacket<B>>{

    public BlockPos entityPos;
     public int containerID;

     public ResourceLocation menuId;

    public Component title;

    public ResourceLocation intendedTypeLocation;

    public OpenContainerScreenGuiS2CPacket(int x, int y, int z, int pContainerId, MenuType<?> pMenuType, Component pTitle, BlockEntityType<B> intendedType){

        entityPos = new BlockPos(x, y, z);
        containerID = pContainerId;
        menuId = ForgeRegistries.MENU_TYPES.getKey(pMenuType);
        title = pTitle;
        intendedTypeLocation = ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(intendedType);

    }

    public OpenContainerScreenGuiS2CPacket(BlockPos pos, int pContainerId, MenuType<?> pMenuType, Component pTitle, BlockEntityType<B> intendedType){

        entityPos = pos;
        containerID = pContainerId;
        menuId = ForgeRegistries.MENU_TYPES.getKey(pMenuType);
        System.out.println(menuId);
        title = pTitle;
        intendedTypeLocation = ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(intendedType);

    }


    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeBlockPos(entityPos).writeVarInt(containerID);
        pBuffer.writeComponent(title).writeResourceLocation(intendedTypeLocation);
        pBuffer.writeUtf(menuId.getNamespace() + ":" + menuId.getPath());
    }

    public static <T extends BlockEntity> OpenContainerScreenGuiS2CPacket<T> read(FriendlyByteBuf pBuffer) {
        BlockPos pos = pBuffer.readBlockPos();
        int id = pBuffer.readVarInt();
        Component title = pBuffer.readComponent();
        BlockEntityType<T> type = (BlockEntityType<T>) ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(pBuffer.readResourceLocation());

        String namespace = pBuffer.readUtf();

        ResourceLocation menuLoc = new ResourceLocation(namespace);

        MenuType<?> menu = ForgeRegistries.MENU_TYPES.getValue(menuLoc);





        return new OpenContainerScreenGuiS2CPacket<T>(pos, id, menu, title, type);
    }


    @Override
    public void handleOnRenderThread(OpenContainerScreenGuiS2CPacket<B> packet, Supplier<NetworkEvent.Context> context) {

        Player player = Minecraft.getInstance().player;
        BlockEntity entity = Minecraft.getInstance().level != null ? Minecraft.getInstance().level.getBlockEntity(packet.entityPos) : null;
        if(entity != null){
            if(ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(entity.getType()).equals(packet.intendedTypeLocation) &&
                    ModScreens.has(ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(packet.intendedTypeLocation)) &&
                    ModBlockEntities.ModScreenTypes.modMenuSupplier.containsKey(packet.menuId)){
                if(RenderSystem.isOnRenderThread()) {
                    AbstractContainerScreen<?> screen = ModScreens.get(ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(packet.intendedTypeLocation)).create(
                            ModBlockEntities.ModScreenTypes.modMenuSupplier.get(packet.menuId)
                                    .create(packet.containerID, player.getInventory(), entity), player.getInventory(), packet.title, entity);
                    player.containerMenu = screen.getMenu();
                    Minecraft.getInstance().setScreen(screen);
                }else{
                    System.out.println("Thread wrong!, %s".formatted(Thread.currentThread().getName()));

                }


            }else{
                if(!ModScreens.has(ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(packet.intendedTypeLocation))){
                    System.out.println("NOT REGISTERED IN MY CUSTOM REGISTERING SYSTEM!");
                }
                System.out.println("WRONG SCREEN OPEN PACKET RECIEVED. IGNORING.");
            }

        }
        context.get().setPacketHandled(true);


    }

    public static <T extends BlockEntity> void handle(OpenContainerScreenGuiS2CPacket<T> packet, Supplier<NetworkEvent.Context> context){

        Network.INSTANCE.ensureRunningOnSameThread(packet, context.get().getNetworkManager(), context.get(), Minecraft.getInstance());

    }


}
