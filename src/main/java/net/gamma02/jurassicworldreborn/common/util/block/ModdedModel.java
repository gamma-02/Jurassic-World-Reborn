package net.gamma02.jurassicworldreborn.common.util.block;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModdedModel<I extends IAnimatable> extends AnimatedGeoModel<I> {

    private ResourceLocation animationLocation;
    private ResourceLocation modelLocation;
    private ResourceLocation textureLocation;

    public ModdedModel(ResourceLocation model, ResourceLocation texture, ResourceLocation animation){
        this.modelLocation = model;
        this.textureLocation = texture;
        this.animationLocation = animation;
    }

    @Override
    public ResourceLocation getModelResource(I i) {
        return this.modelLocation;
    }

    @Override
    public ResourceLocation getTextureResource(I i) {
        return this.textureLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(I i) {
        return this.animationLocation;
    }
}
