package net.gamma02.jurassicworldreborn.common.blocks.machines.cleaner;

import net.gamma02.jurassicworldreborn.common.blocks.machines.modBlockEntities;
import net.gamma02.jurassicworldreborn.common.network.Network;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fluids.capability.wrappers.BlockWrapper;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class CleanerBlock extends BaseEntityBlock {
    public CleanerBlock(Properties p_49224_) {
        super(p_49224_);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CleanerBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return (world1, pos, state1, instance) -> {
            if (instance instanceof CleanerBlockEntity) {
                ((CleanerBlockEntity) instance).tick(world1, pos, state1, (CleanerBlockEntity) instance);
            } else {
                super.getTicker(world, state, type).tick(world1, pos, state1, instance);
            }
        };
    }





    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        boolean b = false;
        if(pLevel.getBlockEntity(pPos) instanceof CleanerBlockEntity e && pPlayer instanceof ServerPlayer p){
            Network.<CleanerBlockEntity>sendOpenPacket(pPos, p.containerCounter, e.getDisplayName(), modBlockEntities.modScreenTypes.CleanerScreenType.get(), modBlockEntities.CLEANING_STATION.get(), p);
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
