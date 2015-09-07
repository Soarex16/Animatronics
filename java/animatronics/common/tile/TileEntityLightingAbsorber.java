package animatronics.common.tile;

import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITEStoresEntropy;

public class TileEntityLightingAbsorber extends TileEntityPrimary implements ITEStoresEntropy {

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

}
