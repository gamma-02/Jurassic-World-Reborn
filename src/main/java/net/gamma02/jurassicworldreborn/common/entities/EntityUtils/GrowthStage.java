package net.gamma02.jurassicworldreborn.common.entities.EntityUtils;

import net.gamma02.jurassicworldreborn.Jurassicworldreborn;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.chat.contents.TranslatableContents;

public enum GrowthStage {
    ADULT, INFANT, JUVENILE, /*FLUORESCENT*/ADOLESCENT, SKELETON;

    // Enum#values() is not being cached for security reasons. DONT PERFORM CHANGES ON THIS ARRAY
    public static final GrowthStage[] VALUES = GrowthStage.values();

    public String getLocalization() {
        return MutableComponent.create( new TranslatableContents("growth_stage" + this.name().toLowerCase() + ".name")).getString();
    }
}