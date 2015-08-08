package animatronics.common.tile;

import animatronics.api.energy.ITEStoresEntropy;

public class TileEntityHeatCollapsor extends TileEntityPrimary implements ITEStoresEntropy {
	
	public int currentBurnTime, currentMaxBurnTime;
	public static float entropyGenerated = 5;
	
	public TileEntityHeatCollapsor() {
		super();
		this.setSlotsNum(1);
		this.setMaxEntropy(200);
	}

	public boolean canUpdate(){
		return true;
	}
	
	@Override
	public void updateEntity() {
		float entropyGen = entropyGenerated;
		super.updateEntity();
	}
	
	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

}
