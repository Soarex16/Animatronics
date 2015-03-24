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
	
	@Override
	public void updateEntity(){
		worldObj.getTileEntity(xCoord, yCoord, zCoord);
		worldObj.spawnParticle("smoke", xCoord+0.5, yCoord+0.5, zCoord+0.5, 0, 0, 0);
	}
	
}
