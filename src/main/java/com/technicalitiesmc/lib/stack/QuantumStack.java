package com.technicalitiesmc.lib.stack;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class QuantumStack {

    private final ItemStack stack;
    private final float chance;

    private QuantumStack(ItemStack stack, float chance) {
        this.stack = stack;
        this.chance = chance;
    }

    public ItemStack getStack() {
        return stack;
    }

    public float getChance() {
        return chance;
    }

    /**
     * Gets the {@link ItemStack} with a chance.
     *
     * @param random The random number generator.
     * @return The {@link ItemStack} if it succeeded, otherwise {@link ItemStack#EMPTY}.
     */
    public ItemStack create(Random random) {
        return random.nextDouble() < getChance() ? getStack().copy() : ItemStack.EMPTY;
    }

    /**
     * Creates a new {@link QuantumStack} from an {@link ItemStack} and a chance.
     *
     * @param stack  The {@link ItemStack}.
     * @param chance The chance of returning that stack.
     * @return The resulting {@link QuantumStack}.
     */
    public static QuantumStack of(ItemStack stack, float chance) {
        return new QuantumStack(stack, chance);
    }

}
