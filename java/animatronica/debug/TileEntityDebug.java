package animatronica.debug;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDebug extends TileEntity {
	
	public boolean canUpdate(){
		return true;
	}
	
	public double rotate;
	
	@Override
	public void updateEntity(){
		rotate+=0.75;
	}
	
}
