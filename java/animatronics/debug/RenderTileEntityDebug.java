package animatronics.debug;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.render.RenderPatterns;
import animatronics.common.item.AnimatronicaItems;
import animatronics.utils.handler.ClientTickHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTileEntityDebug extends TileEntitySpecialRenderer{

	public final static ResourceLocation textureModelBlockDebug = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/modelBlockDebug.png");
	public final static ModelBlockDebug modelBlockDebug = new ModelBlockDebug();	
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		TileEntityDebug tileDebug = (TileEntityDebug) tile;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		bindTexture(textureModelBlockDebug);
			GL11.glPushMatrix();
				GL11.glPushMatrix();
					GL11.glRotated(tileDebug.anim, 0, 1, 0);
					modelBlockDebug.renderModel(0.0625F);
				GL11.glPopMatrix();
				GL11.glTranslated(0,1,0);
				float radius = 1.5F;
				double rads = ClientTickHandler.ticksInGame * Math.PI / 180;
				double cX = Math.cos(rads) * radius;
				double cZ = Math.sin(rads) * radius;
			GL11.glPushMatrix();
			RenderPatterns.renderStack(tileDebug.getWorldObj() , tileDebug.getStackInSlot(0),tileDebug, 0, 0.1, 0, 0.4, 0.4, 0.4, true, 1.0F, true);
				GL11.glTranslated(-cX, 0, -cZ);
				ItemStack wheatStack = new ItemStack(Items.wheat);
				RenderPatterns.renderStack(tileDebug.getWorldObj(), wheatStack, tileDebug, 0, 0.1, 0, 0.7, 0.7, 0.7, true, 1.0F, true);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				GL11.glTranslated(cX, 0, cZ);
				ItemStack cocoaStack = new ItemStack(Items.dye, 1, 3);
				RenderPatterns.renderStack(tileDebug.getWorldObj(), cocoaStack, tileDebug, 0, 0.1, 0, 0.7, 0.7, 0.7, true, 1.0F, true);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		GL11.glPopMatrix();		
	}
	
	public static void renderInInventory(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		 Minecraft.getMinecraft().renderEngine.bindTexture(textureModelBlockDebug);
			GL11.glPushMatrix();
			modelBlockDebug.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();	
	}
}
