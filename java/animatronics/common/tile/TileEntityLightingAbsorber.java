package animatronics.common.tile;

import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITEStoresEntropy;
import net.minecraft.entity.effect.EntityLightningBolt;

public class TileEntityLightingAbsorber extends TileEntityPrimary implements ITEStoresEntropy {

	public boolean animationFinished;
	public int animationState;
	
	
	
	public TileEntityLightingAbsorber() {
		super();
	}

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
	
	public void updateEntity() {
		if(Math.random() < 0.01)
			//if(worldObj.isRaining())
				worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, xCoord, yCoord+3, zCoord));
	}

}
