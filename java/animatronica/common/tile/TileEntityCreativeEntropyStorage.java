package animatronica.common.tile;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class TileEntityCreativeEntropyStorage extends TileEntityPrimary {

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
