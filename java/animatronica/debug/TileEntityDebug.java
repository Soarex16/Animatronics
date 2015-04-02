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

		Animatronica.proxy.setWispFXDistanceLimit(false);
		Animatronica.proxy.wispFX(worldObj, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 0.075F, 0.75F, 0.075F, (float) Math.random() * 5 + 1F, (float) (Math.random() - 0.5F), 10F * (float) Math.sqrt(10/(30F + yCoord)), (float) (Math.random() - 0.5F));

		for(int i = 0; i < 2; i++)
			Animatronica.proxy.wispFX(worldObj, xCoord + 0.5, yCoord + 75, zCoord + 0.5, 0.075F, 0.75F, 0.075F, (float) Math.random() * 15 + 4F, (float) (Math.random() - 0.5F) * 4F, 0F, (float) (Math.random() - 0.5F) * 4F);
		Animatronica.proxy.setWispFXDistanceLimit(true);
	}
}
