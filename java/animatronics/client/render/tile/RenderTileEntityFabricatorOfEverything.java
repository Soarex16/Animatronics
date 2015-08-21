package animatronics.client.render.tile;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import animatronics.client.render.RenderPatterns;
import animatronics.utils.handler.ClientTickHandler;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class RenderTileEntityFabricatorOfEverything extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		//block outline render here...It din't want to render
	}
}
