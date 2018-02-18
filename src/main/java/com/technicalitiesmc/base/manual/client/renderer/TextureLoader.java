package com.technicalitiesmc.base.manual.client.renderer;

import com.technicalitiesmc.base.TechnicalitiesKt;
import net.minecraft.util.ResourceLocation;

public final class TextureLoader {
    public static final ResourceLocation LOCATION_MANUAL_BACKGROUND = new ResourceLocation(TechnicalitiesKt.MODID, "textures/gui/manual.png");
    public static final ResourceLocation LOCATION_MANUAL_TAB = new ResourceLocation(TechnicalitiesKt.MODID, "textures/gui/manual_tab.png");
    public static final ResourceLocation LOCATION_MANUAL_SCROLL = new ResourceLocation(TechnicalitiesKt.MODID, "textures/gui/manual_scroll.png");
    public static final ResourceLocation LOCATION_MANUAL_MISSING = new ResourceLocation(TechnicalitiesKt.MODID, "textures/gui/manual_missing.png");

    public static final TextureLoader INSTANCE = new TextureLoader();

    // --------------------------------------------------------------------- //

    private TextureLoader() {
    }
}
