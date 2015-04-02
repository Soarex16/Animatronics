package animatronica.debug;

import net.minecraft.entity.passive.EntitySheep;
import animatronica.Animatronica;
import animatronica.common.tile.TileAnimatronica;

public class TileEntityDebug extends TileAnimatronica {
	
	public boolean canUpdate(){
		return true;
	}
	
	public double rotate;
	
	@Override
	public void updateEntity() {
		rotate+=0.9;
		
		Animatronica.proxy.sparkleFX(worldObj, xCoord+0.5F, yCoord + 1.0F, zCoord + 0.5F, (float)Math.random(), (float)Math.random(), (float)Math.random(), (float)(Math.random()*1.5F), 50);
/*
		Animatronica.proxy.setWispFXDistanceLimit(false);
		Animatronica.proxy.wispFX(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.075F, 0.75F, 0.075F, (float) Math.random() * 4 + 1F, (float) (Math.random() - 0.5F), 5F * (float) Math.sqrt(10/(30F + yCoord)), (float) (Math.random() - 0.5F));

		for(int i = 0; i < 1; i++)
			Animatronica.proxy.wispFX(worldObj, xCoord + 0.5, yCoord + 75, zCoord + 0.5, 0.075F, 0.75F, 0.075F, (float) Math.random() * 7 + 4F, (float) (Math.random() - 0.5F) * 3F, 0F, (float) (Math.random() - 0.5F) * 3F);
		Animatronica.proxy.setWispFXDistanceLimit(true);
*/
	}
}
