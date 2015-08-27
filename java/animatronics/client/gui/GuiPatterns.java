package animatronics.client.gui;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import animatronics.Animatronics;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiPatterns{
	
	public static final int TEXT_COLOR = 4210752;
	
	public static int getGuiXSize(GuiContainer gui) {
        try {
            return (Integer)ReflectionHelper.getPrivateValue((Class)GuiContainer.class, (Object)gui, (String[])new String[]{"xSize", "f", "field_146999_f"});
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static int getGuiYSize(GuiContainer gui) {
        try {
            return (Integer)ReflectionHelper.getPrivateValue((Class)GuiContainer.class, (Object)gui, (String[])new String[]{"ySize", "g", "field_147000_g"});
        }
        catch (Exception e) {
            return 0;
        }
    }

    public static float getGuiZLevel(Gui gui) {
        try {
            return ((Float)ReflectionHelper.getPrivateValue((Class)Gui.class, (Object)gui, (String[])new String[]{"zLevel", "e", "field_73735_i"})).floatValue();
        }
        catch (Exception e) {
            return 0.0f;
        }
    }
	
	public static void renderSlot(GuiContainer container, Slot slot, int x, int y) {
        ResourceLocation slotTex = new ResourceLocation(Animatronics.MOD_ID.toLowerCase(), "textures/gui/elements/Slot_base.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(slotTex);
		container.drawTexturedModalRect(x + slot.xDisplayPosition - 1, y + slot.yDisplayPosition - 1, 0, 0, 18, 18);
	}
	
	public static void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6) {
        float var7 = (float)(par5 >> 24 & 255) / 255.0f;
        float var8 = (float)(par5 >> 16 & 255) / 255.0f;
        float var9 = (float)(par5 >> 8 & 255) / 255.0f;
        float var10 = (float)(par5 & 255) / 255.0f;
        float var11 = (float)(par6 >> 24 & 255) / 255.0f;
        float var12 = (float)(par6 >> 16 & 255) / 255.0f;
        float var13 = (float)(par6 >> 8 & 255) / 255.0f;
        float var14 = (float)(par6 & 255) / 255.0f;
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        Tessellator var15 = Tessellator.instance;
        var15.startDrawingQuads();
        var15.setColorRGBA_F(var8, var9, var10, var7);
        var15.addVertex((double)par3, (double)par2, 300.0);
        var15.addVertex((double)par1, (double)par2, 300.0);
        var15.setColorRGBA_F(var12, var13, var14, var11);
        var15.addVertex((double)par1, (double)par4, 300.0);
        var15.addVertex((double)par3, (double)par4, 300.0);
        var15.draw();
        GL11.glShadeModel((int)7424);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glEnable((int)3553);
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
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
        GL11.glPopAttrib();
    }
}
