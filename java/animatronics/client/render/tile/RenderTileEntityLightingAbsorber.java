package animatronics.client.render.tile;

import org.lwjgl.opengl.GL11;

import animatronics.Animatronics;
import animatronics.client.model.ModelLightingAbsorber;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityLightingAbsorber extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureLightingAbsorber = new ResourceLocation(Animatronics.MOD_ID + ":" + "textures/models/modelLightingAbsorber.png");
	private static final ModelLightingAbsorber modelLightingAbsorber = new ModelLightingAbsorber();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			GL11.glTranslated(x+0.5, y+0.75, z+0.5);
			GL11.glRotatef(180, 0F, 0F, 1F);
			bindTexture(textureLightingAbsorber);
			GL11.glPushMatrix();
				modelLightingAbsorber.renderBlockBox(0.03125F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				modelLightingAbsorber.renderBlockDoors(0.03125F);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
				modelLightingAbsorber.renderBlockCoil(0.03125F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
