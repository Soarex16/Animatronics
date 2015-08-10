package animatronics.common.tile;

import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiSunCollector;
import animatronics.common.inventory.ContainerSunCollector;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.AxisAlignedBB;

public class TileEntitySunCollector extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI {
	
	public boolean isWorking = false;
	public float entropyGenerated = 1;
	public int range = 4;

	public TileEntitySunCollector() {
		super();
		this.setSlotsNum(0);
		this.setMaxEntropy(250);
	}
	
	public boolean canUpdate() {
		return true;
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(Math.random() < 0.01) {
			if(worldObj.canBlockSeeTheSky(xCoord, yCoord+1, zCoord) && !worldObj.isRaining() && worldObj.isDaytime()) {
				isWorking = true;
				setEntropy((int)(getEntropy()+entropyGenerated));
				if(worldObj.getWorldTime() % 24000 >= 5000 && worldObj.getWorldTime() % 24000 <= 7000) {
					for(Object e: worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord-range, yCoord-range, zCoord-range, xCoord+range, yCoord+range, zCoord+range))) {
						((EntityLivingBase)e).setFire(400);
					}	
				}
			}
		}	
	}
	
	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}

	@Override
	public Container getContainer(EntityPlayer player) {
		return new ContainerSunCollector(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player) {
		return new GuiSunCollector(getContainer(player), this);
	}

}
