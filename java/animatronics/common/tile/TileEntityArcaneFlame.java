package animatronics.common.tile;

import animatronics.Animatronics;
import animatronics.client.render.RenderPatterns;
import animatronics.utils.handler.ClientTickHandler;
import net.minecraft.tileentity.TileEntity;

public class TileEntityArcaneFlame extends TileEntity {
	
	public boolean canUpdate() {
		return true;
	}
	
	double cY = 0;

	public void updateEntity() {
		RenderPatterns.spawnFlame(worldObj, xCoord+0.5, yCoord+0.4, zCoord+0.5, 0x006600, 0.9F);
		if(Math.random() < 0.4){
			Animatronics.proxy.setSparkleFXCorrupt(true);
			Animatronics.proxy.sparkleFX(getWorldObj(), xCoord+0.5, yCoord+1.5, zCoord+0.5, (float)Math.random(), (float)Math.random(), (float)Math.random(), 1, 10);
		}
	}
}
