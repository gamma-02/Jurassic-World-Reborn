package net.gamma02.jurassicworldreborn.common.blocks.ancientplants;

import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class AncientCrop extends CropBlock {

    public static IntegerProperty AGE_5 = BlockStateProperties.AGE_5;

    public int maxAge = 5;
    public final int ageChoice;



    public AncientCrop(Properties pProperties) {
        super(pProperties);
        this.ageChoice = 1;
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE_5, 0));
        Jurassicworldreborn.setRenderType(this, RenderType.cutout());
    }
    public AncientCrop(Properties pProperties, int dif) {
        super(pProperties);
        this.ageChoice = 1;
        Jurassicworldreborn.setRenderType(this, RenderType.cutout());

    }
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE_5;
    }


    @Override
    public int getMaxAge() {
        return this.maxAge;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {

        pBuilder.add(AGE_5);
    }
}
