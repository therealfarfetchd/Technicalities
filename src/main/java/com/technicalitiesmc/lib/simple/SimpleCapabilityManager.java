package com.technicalitiesmc.lib.simple;

import com.google.common.base.Throwables;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

/**
 * Manages the registration of "simple capabilities" to the {@link CapabilityManager}.
 *
 * @see SimpleCapability
 */
public enum SimpleCapabilityManager {
    INSTANCE;

    /**
     * Registers all the classes marked with {@link SimpleCapability @SimpleCapability} to the {@link CapabilityManager} without a default
     * implementation nor storage solution.
     */
    @SuppressWarnings("unchecked")
    public void init(ASMDataTable dataTable) {
        dataTable.getAll(SimpleCapability.class.getName()).forEach(data -> {
            try {
                Class<?> owner = Class.forName(data.getClassName()), clazz = owner;
                if (!data.getObjectName().equals(data.getClassName())) {
                    clazz = owner.getDeclaredField(data.getObjectName()).getAnnotation(CapabilityInject.class).value();
                }
                CapabilityManager.INSTANCE.register(clazz, new Capability.IStorage() {

                    @Override
                    public NBTBase writeNBT(Capability capability, Object instance, EnumFacing side) {
                        return null;
                    }

                    @Override
                    public void readNBT(Capability capability, Object instance, EnumFacing side, NBTBase nbt) {
                    }

                }, () -> null);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        });
    }

}
