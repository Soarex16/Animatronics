package animatronica.common.tile;

import animatronica.api.energy.ITEStoresEntropy;

public class TileEntityCreativeEntropyStorage extends TileEntityPrimary implements ITEStoresEntropy {

	public TileEntityCreativeEntropyStorage() {
		super();
		this.setSlotsNum(0);
		this.setMaxEntropy(100000);
	}
	
	public void updateEntity() 
	{
		this.setEntropy(this.getMaxEntropy());
		super.updateEntity();
	}
}
