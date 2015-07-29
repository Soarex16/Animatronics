package animatronica.common.tile;

import animatronica.Animatronica;
import animatronica.client.render.RenderPatterns;
import animatronica.utils.event.ClientTickHandler;
import net.minecraft.tileentity.TileEntity;

public class TileEntityArcaneFlame extends TileEntity {
	
	public boolean canUpdate() {
		return true;
	}
	
	double cY = 0;

	public void updateEntity() {
		RenderPatterns.spawnFlame(worldObj, xCoord+0.5, yCoord+0.4, zCoord+0.5, 0x006600, 0.9F);
		if(Math.random() < 0.4){
			Animatronica.proxy.setSparkleFXCorrupt(true);
			Animatronica.proxy.sparkleFX(getWorldObj(), xCoord+0.5, yCoord+1.5, zCoord+0.5, (float)Math.random(), (float)Math.random(), (float)Math.random(), 1, 10);
		}
	}
}
