package animatronics.common.tile;

import animatronics.api.AnimatronicsAPI;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.client.gui.GuiEntropyFurnace;
import animatronics.common.inventory.ContainerEntropyFurnace;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import animatronics.utils.misc.EnergyUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEntropyFurnace extends TileEntityPrimary implements ITERequiresEntropy, ITileEntityHasGUI{

	public TileEntityEntropyFurnace() {
		setSlotsNum(2);
		setMaxEntropy(500);
		AnimatronicsAPI.addRecipeToEntropyFurnace(Items.apple, 0, 0, null);
	}

	@Override
	public Container getContainer(EntityPlayer player) {
		return new ContainerEntropyFurnace(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player) {
		// TODO Auto-generated method stub
		return new GuiEntropyFurnace(getContainer(player), this);
	}

	@Override
	public void updateEntity() {
	//	System.out.println("lol");
		EnergyUtils.manage(this, 0.5F, 0.5F, 0.5F);
		if(getStackInSlot(0) != null){
			if(AnimatronicsAPI.getFurnaceRecipeList().containsKey(getStackInSlot(0))){
				System.out.println("true");
			}
		}
		super.updateEntity();
	}
	
	@Override
	public int[] getOutputSlots() {
		
		return new int[0];
	}

}
