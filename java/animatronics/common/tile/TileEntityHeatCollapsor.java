package animatronics.common.tile;

import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiHeatCollapsor;
import animatronics.common.inventory.ContainerHeatCollapsor;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityHeatCollapsor extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI {
	
	public int currentBurnTime, currentMaxBurnTime;
	public static float entropyGenerated = 5;
	public static boolean harmEntities = true;
	
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
	public Container getContainer(EntityPlayer player){
		return new ContainerHeatCollapsor(player.inventory, this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiContainer getGui(EntityPlayer player){
		return new GuiHeatCollapsor(getContainer(player), this);
	}
	
	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
	
	@Override
    public void readFromNBT(NBTTagCompound i)
    {
		currentBurnTime = i.getInteger("burn");
		currentMaxBurnTime = i.getInteger("burnMax");
		super.readFromNBT(i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
		i.setInteger("burn", currentBurnTime);
		i.setInteger("burnMax", currentMaxBurnTime);
    	super.writeToNBT(i);
    }

}
