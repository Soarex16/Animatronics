package animatronics.common.block;

import animatronics.Animatronics;
import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITERequiresEntropy;
import animatronics.client.gui.GuiEntropyCrusher;
import animatronics.common.inventory.ContainerEntropyCrusher;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class TileEntityEntropyCrusher extends TileEntityPrimary implements ITERequiresEntropy, ITileEntityHasGUI {
	
	public TileEntityEntropyCrusher() {
		super();
		setSlotsNum(3);
		maxEntropy = 10000;
	}
	
	public void updateEntity() {
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.62F, yCoord+0.58F, zCoord+0.6F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.62F, yCoord+0.58F, zCoord+0.38F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.38F, yCoord+0.58F, zCoord+0.6F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
		Animatronics.proxy.lightingBoltFX(worldObj, xCoord+0.38F, yCoord+0.58F, zCoord+0.38F, xCoord+0.5F, yCoord+0.25F, zCoord+0.5F, 5, worldObj.rand.nextLong(), 10, 8, 5);
	}
	

	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

	@Override
	public Container getContainer(EntityPlayer player) {
		return new ContainerEntropyCrusher(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player) {
		return new GuiEntropyCrusher(getContainer(player), this);
	}

}
