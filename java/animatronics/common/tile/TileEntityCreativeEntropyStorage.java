package animatronics.common.tile;

import animatronics.api.energy.ITEStoresEntropy;

public class TileEntityCreativeEntropyStorage extends TileEntityPrimary implements ITEStoresEntropy {

	public TileEntityCreativeEntropyStorage() {
		super();
		setSlotsNum(0);
		maxEntropy = 100000;
	}
	
	public void updateEntity() 
	{
		super.updateEntity();
		entropy = maxEntropy;
	}

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
}
