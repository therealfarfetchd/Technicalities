package com.technicalitiesmc.base.weather;

import com.technicalitiesmc.api.TechnicalitiesAPI;
import com.technicalitiesmc.api.weather.IWeatherSimulator;
import com.technicalitiesmc.base.TechnicalitiesKt;
import com.technicalitiesmc.lib.util.DefaultCapabilityProvider;
import elec332.core.util.RegistryHelper;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Elec332 on 16-1-2018.
 */
public class WeatherHandler {

    private static final ResourceLocation NAME = new ResourceLocation(TechnicalitiesKt.MODID, "weather_cap");

    public static void preInit(){
        RegistryHelper.registerEmptyCapability(IWeatherSimulator.class);
        DefaultCapabilityProvider.registerWorldCapabilityProvider(NAME, TechnicalitiesAPI.getWorldWeatherCap(), WorldWeatherHandler::new);
    }

}
