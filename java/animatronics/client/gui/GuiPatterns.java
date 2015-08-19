package animatronics.client.gui;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import animatronics.Animatronics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiPatterns{
	
	public static final int TEXT_COLOR = 4210752;
	
	public static float zLevel;
	
	public static void renderSlot(GuiContainer container, Slot slot, int x, int y) {
        ResourceLocation slotTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		container.drawTexturedModalRect(x + slot.xDisplayPosition - 1, y + slot.yDisplayPosition - 1, 0, 0, 18, 18);
	}
	
	public static void drawGradientRect(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_) {
        float f = (float)(p_73733_5_ >> 24 & 255) / 255.0F;
        float f1 = (float)(p_73733_5_ >> 16 & 255) / 255.0F;
        float f2 = (float)(p_73733_5_ >> 8 & 255) / 255.0F;
        float f3 = (float)(p_73733_5_ & 255) / 255.0F;
        float f4 = (float)(p_73733_6_ >> 24 & 255) / 255.0F;
        float f5 = (float)(p_73733_6_ >> 16 & 255) / 255.0F;
        float f6 = (float)(p_73733_6_ >> 8 & 255) / 255.0F;
        float f7 = (float)(p_73733_6_ & 255) / 255.0F;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f2, f3, f);
        tessellator.addVertex((double)p_73733_3_, (double)p_73733_2_, (double)zLevel);
        tessellator.addVertex((double)p_73733_1_, (double)p_73733_2_, (double)zLevel);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex((double)p_73733_1_, (double)p_73733_4_, (double)zLevel);
        tessellator.addVertex((double)p_73733_3_, (double)p_73733_4_, (double)zLevel);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
	
	public static void drawToolTip(List tooltip, int x, int y) {
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT + GL11.GL_LIGHTING_BIT);
        FontRenderer font = Minecraft.getMinecraft().fontRenderer;
        if (!tooltip.isEmpty())
        {
        	GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            int var5 = 0;
            Iterator var6 = tooltip.iterator();

            while (var6.hasNext())
            {
                String var7 = (String)var6.next();
                int var8 = font.getStringWidth(var7);

                if (var8 > var5)
                {
                    var5 = var8;
                }
            }

            int var15 = x + 12;
            int var16 = y - 12;
            int var9 = 8;

            if (tooltip.size() > 1)
            {
                var9 += 2 + (tooltip.size() - 1) * 10;
            }

            zLevel = 300.0F;
            
            int var10 = -267386864;
            
            drawGradientRect(var15 - 3, var16 - 4, var15 + var5 + 3, var16 - 3, var10, var10);
            drawGradientRect(var15 - 3, var16 + var9 + 3, var15 + var5 + 3, var16 + var9 + 4, var10, var10);
            drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 + var9 + 3, var10, var10);
            drawGradientRect(var15 - 4, var16 - 3, var15 - 3, var16 + var9 + 3, var10, var10);
            drawGradientRect(var15 + var5 + 3, var16 - 3, var15 + var5 + 4, var16 + var9 + 3, var10, var10);
            int var11 = 1347420415;
            int var12 = (var11 & 16711422) >> 1 | var11 & -16777216;
            drawGradientRect(var15 - 3, var16 - 3 + 1, var15 - 3 + 1, var16 + var9 + 3 - 1, var11, var12);
            drawGradientRect(var15 + var5 + 2, var16 - 3 + 1, var15 + var5 + 3, var16 + var9 + 3 - 1, var11, var12);
            drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 - 3 + 1, var11, var11);
            drawGradientRect(var15 - 3, var16 + var9 + 2, var15 + var5 + 3, var16 + var9 + 3, var12, var12);

            for (int var13 = 0; var13 < tooltip.size(); ++var13)
            {
                String var14 = (String)tooltip.get(var13);

                font.drawStringWithShadow(var14, var15, var16, -1);

                if (var13 == 0)
                {
                    var16 += 2;
                }

                var16 += 10;
            }
            zLevel = 0.0F;
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
        GL11.glPopAttrib();
    }
}
