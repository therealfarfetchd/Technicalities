package com.technicalitiesmc.mechanical.client.renderer;

import com.technicalitiesmc.mechanical.block.BlockHandCrank;
import com.technicalitiesmc.mechanical.proxy.TKMClientProxy;
import com.technicalitiesmc.mechanical.tile.TileHandCrank;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;

import static net.minecraft.client.renderer.GlStateManager.*;

public class TESRHandCrank extends TileEntitySpecialRenderer<TileHandCrank> {
    @Override
    public void render(TileHandCrank te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        IBakedModel model = TKMClientProxy.MODELS.get(TKMClientProxy.HAND_CRANK_LEVER);

        pushMatrix();
        color(1, 1, 1, 1);
        translate(x, y, z);
        translate(0.5, 0.5, 0.5);
        rotate(te.getWorld().getBlockState(te.getPos()).getValue(BlockHandCrank.PROP_FACING));
        translate(-0.5, -0.5, -0.5);

        translate(0.5, -3 / 16.0, 0.5);
        rotate(te.getCrankRotation(partialTicks) * 45, 1, 0, 0);
        translate(-0.5, 3 / 16.0, -0.5);

        RenderHelper.disableStandardItemLighting();
        GlStateManager.shadeModel(Minecraft.isAmbientOcclusionEnabled() ? GL11.GL_SMOOTH : GL11.GL_FLAT);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buf = tessellator.getBuffer();
        buf.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

        buf.setTranslation(-te.getPos().getX(), -te.getPos().getY(), -te.getPos().getZ());
        Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelRenderer().renderModel(te.getWorld(), model, Blocks.STONE.getDefaultState(), te.getPos(), buf, false, 0L);
        buf.setTranslation(0, 0, 0);

        tessellator.draw();
        RenderHelper.enableStandardItemLighting();
        popMatrix();
    }

    private void rotate(EnumFacing facing) {
        switch (facing) {
            case DOWN:
                break;
            case UP:
                rotate(180, 1, 0, 0);
                break;
            case NORTH:
                rotate(90, 1, 0, 0);
                break;
            case SOUTH:
                rotate(180, 0, 1, 0);
                rotate(90, 1, 0, 0);
                break;
            case WEST:
                rotate(90, 0, 1, 0);
                rotate(90, 1, 0, 0);
                break;
            case EAST:
                rotate(270, 0, 1, 0);
                rotate(90, 1, 0, 0);
                break;
        }
    }

    // java forgets about the static import when there's another rotate method :/
    private void rotate(float theta, float x, float y, float z) {
        GlStateManager.rotate(theta, x, y, z);
    }
}
