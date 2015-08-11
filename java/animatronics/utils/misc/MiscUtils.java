package animatronics.utils.misc;

import java.util.Hashtable;

import org.lwjgl.opengl.GL11;

import animatronics.api.energy.ITEHasEntropy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class MiscUtils {
	
	public static Hashtable<String,ResourceLocation> locTable = new Hashtable<String,ResourceLocation>();
	
	public static int pixelatedTextureSize(int current, int max, int textureSize) {
		if(current > max)
			current = max;
    	float m = (float)current/max*100;
    	float n = m/100*textureSize;
    	return (int)n;
	}
	
	@SideOnly(Side.CLIENT)
	public static void bindTexture(String mod, String texture)
	{
		if(locTable.contains(mod+":"+texture))
			Minecraft.getMinecraft().getTextureManager().bindTexture(locTable.get(mod+":"+texture));
		else
		{
			ResourceLocation loc = new ResourceLocation(mod,texture);
			locTable.put(mod+":"+texture, loc);
			Minecraft.getMinecraft().getTextureManager().bindTexture(loc);	
		}
	}
	
	@SideOnly(Side.CLIENT)
    public static boolean drawScaledTexturedRect(int x, int y, IIcon icon, int width, int height, float zLevel)
    {
        if(icon == null)
        {
            return false;
        }
        else
        {
        	bindTexture("minecraft", "textures/atlas/blocks.png");
            double minU = icon.getMinU();
            double maxU = icon.getMaxU();
            double minV = icon.getMinV();
            double maxV = icon.getMaxV();
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(x + 0, y + height, zLevel, minU, minV + ((maxV - minV) * (double)height) / 16D);
            tessellator.addVertexWithUV(x + width, y + height, zLevel, minU + ((maxU - minU) * (double)width) / 16D, minV + ((maxV - minV) * (double)height) / 16D);
            tessellator.addVertexWithUV(x + width, y + 0, zLevel, minU + ((maxU - minU) * (double)width) / 16D, minV);
            tessellator.addVertexWithUV(x + 0, y + 0, zLevel, minU, minV);
            tessellator.draw();
            return true;
        }
    }
	
	@SideOnly(Side.CLIENT)
    public static void drawTexture(int x, int y, IIcon icon, int width, int height, float zLevel)
    {
        for(int i = 0; i < width; i += 16)
        {
            for(int j = 0; j < height; j += 16)
            {
                drawScaledTexturedRect(x + i, y + j, icon, Math.min(width - i, 16), Math.min(height - j, 16),zLevel);
            }
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
