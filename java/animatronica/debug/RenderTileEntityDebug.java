package animatronica.debug;

import java.util.Random;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class RenderTileEntityDebug  extends TileEntitySpecialRenderer {
	
	 public void renderTileEntityAt(TileEntity tile, double par2, double par4, double par6, float par8) {
		 RenderHelper.disableStandardItemLighting();
			Tessellator tesselator = Tessellator.instance;
	        RenderHelper.disableStandardItemLighting();
	        float var4 = ((TileEntityDebug)tile).renderIndex;
	        float var5 = 0.0F;
	        
	        float balance = ((TileEntityDebug)tile).getBalanse(); 
	        
	        int color = 0x00ffff;
	        
	        int energyCapacity = 10000;
	        
	        float colorRRender = 0.0F;
	        float colorGRender = 1.0F;
	        float colorBRender = 1.0F;
	        
	        float colorRNormal = 0.0F;
	        float colorGNormal = 1.0F;
	        float colorBNormal = 1.0F;
	        
	        float colorRHot = 1.0F;
	        float colorGHot = 0.0F;
	        float colorBHot = 0.0F;
	        
	        float colorRCold = 0.0F;
	        float colorGCold = 0.0F;
	        float colorBCold = 1.0F;
	        
	        int size = 10000;
	        if(balance!=1.0F)
	        {
	        	if(balance<1.0F)
	        	{
	            	float diff = balance;
	            	if(diff < 0.01F)
	            		diff = 0.0F;
	            	colorRRender = (colorRNormal*diff) + (colorRCold*(1.0F-diff));
	            	colorGRender = (colorGNormal*diff) + (colorGCold*(1.0F-diff));
	            	colorBRender = (colorBNormal*diff) + (colorBCold*(1.0F-diff));
	        	}
	        	if(balance>1.0F)
	        	{
	            	float diff = 2.0F-balance;
	            	if(diff < 0.01F)
	            		diff = 0.0F;
	            	colorRRender = (colorRNormal*diff) + (colorRHot*(1.0F-diff));
	            	colorGRender = (colorGNormal*diff) + (colorGHot*(1.0F-diff));
	            	colorBRender = (colorBNormal*diff) + (colorBHot*(1.0F-diff));
	        	}
	        }
	        
	        Random rand = new Random(432L);
	        GL11.glDisable(GL11.GL_TEXTURE_2D);
	        GL11.glShadeModel(GL11.GL_SMOOTH);
	        GL11.glEnable(GL11.GL_BLEND);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
	        GL11.glDisable(GL11.GL_ALPHA_TEST);
	        GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glDepthMask(false);
	        GL11.glPushMatrix();
	        GL11.glTranslated(par2+0.5, par4+0.5, par6+0.5);
	        GL11.glScalef(0.0000075F*size, 0.0000075F*size, 0.0000075F*size);
	        for (int var7 = 0; (float)var7 < (energyCapacity)/50; ++var7)
	        {
	        		        	
	        	World worldObj = tile.getWorldObj();
	        	
	        	GL11.glRotatef(rand.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
	            GL11.glRotatef(rand.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(rand.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(rand.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
	            GL11.glRotatef(rand.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
	            GL11.glRotatef(rand.nextFloat() * 360.0F + var4 * 90.0F, 0.0F, 0.0F, 1.0F);
	        	
	            tesselator.startDrawing(6);
	            
	            float var8 = rand.nextFloat() * 20.0F + 5.0F + var5 * 10.0F;
	            float var9 = rand.nextFloat() * 2.0F + 1.0F + var5 * 2.0F;

	            tesselator.setColorOpaque_F(colorRRender, colorGRender, colorBRender);
	            tesselator.addVertex(0.0D, 0.0D, 0.0D);
	            if(balance!=1.0F)
	            {
	            	if(balance<1.0F)
	            	{
	            		tesselator.setColorRGBA_F(colorRRender, colorGRender, colorBRender, 10);
	            	}
	            	if(balance>1.0F)
	            	{
	            		tesselator.setColorRGBA_F(colorRRender, colorGRender, colorBRender, 10);
	            	}
	            }else
	            {
	            	tesselator.setColorRGBA_F(colorRRender, colorGRender, colorBRender,10);
	            }
	            tesselator.addVertex(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
	            tesselator.addVertex(0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
	            tesselator.addVertex(0.0D, (double)var8, (double)(1.0F * var9));
	            tesselator.addVertex(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
	            tesselator.draw();
	        }

	        GL11.glPopMatrix();
	        GL11.glDepthMask(true);
	        GL11.glDisable(GL11.GL_CULL_FACE);
	        GL11.glDisable(GL11.GL_BLEND);
	        GL11.glShadeModel(GL11.GL_FLAT);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	        GL11.glEnable(GL11.GL_ALPHA_TEST);
	        RenderHelper.enableStandardItemLighting();
	    }

		protected ResourceLocation getEntityTexture(Entity entity) {
			return null;
		}
}
