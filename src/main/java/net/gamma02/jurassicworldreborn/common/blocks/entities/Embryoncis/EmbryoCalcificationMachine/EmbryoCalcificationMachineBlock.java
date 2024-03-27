package net.gamma02.jurassicworldreborn.common.blocks.entities.Embryoncis.EmbryoCalcificationMachine;

import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.gamma02.jurassicworldreborn.common.blocks.base.BaseMachineBlock;
import net.gamma02.jurassicworldreborn.common.blocks.entities.Embryoncis.EmbryonicMachine.EmbryonicMachineBlock;
import net.gamma02.jurassicworldreborn.common.blocks.entities.Embryoncis.EmbryonicMachine.EmbryonicMachineBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmbryoCalcificationMachineBlock extends BaseMachineBlock {

//    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static BooleanProperty EGG = BooleanProperty.create("egg");

    public static final VoxelShape NORTH_SHAPE = Shapes.join(Block.box(1.5, 0, 4, 14.5, 7, 16), Block.box(0.5, 0, 5, 15.5, 8, 15), BooleanOp.OR);
    public static final VoxelShape WEST_SHAPE = Shapes.join(Block.box(4, 0, 1.5, 16, 7, 14.5), Block.box(5, 0, 0.5, 15, 8, 15.5), BooleanOp.OR);
    public static final VoxelShape SOUTH_SHAPE = Shapes.join(Block.box(1.5, 0, 0, 14.5, 7, 12), Block.box(0.5, 0, 1, 15.5, 8, 11), BooleanOp.OR);
    public static final VoxelShape EAST_SHAPE = Shapes.join(Block.box(0, 0, 1.5, 12, 7, 14.5), Block.box(1, 0, 0.5, 11, 8, 15.5), BooleanOp.OR);


    public EmbryoCalcificationMachineBlock(Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState(this.getSetDefaultValues().setValue(EGG, false));
//        Jurassicworldreborn.setRenderType(this, RenderType.cutoutMipped());
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(EGG);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EmbryoCalcificationMachineBlockEntity(pPos, pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
//                MenuProvider menuprovider = this.getMenuProvider(pState, pLevel, pPos);
            if (pLevel.getBlockEntity(pPos) instanceof EmbryoCalcificationMachineBlockEntity e ) {
                pPlayer.openMenu(e);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return (pLevel1, pPos, pState1, pBlockEntity) -> {
            if(pLevel1.getBlockEntity(pPos) instanceof EmbryoCalcificationMachineBlockEntity dnaSequencer){
                dnaSequencer.tick(pLevel1, pPos, pState1, dnaSequencer);
            }else{
                EmbryoCalcificationMachineBlock.super.getTicker(pLevel, pState, pBlockEntityType);
            }
        };
    }

    @Override
    @NotNull
    public  VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case NORTH -> NORTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> Block.box(1, 0, 1, 15, 14, 15);
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}
