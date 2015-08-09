package animatronics.common.tile;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiHeatCollapser;
import animatronics.common.inventory.ContainerHeatCollapser;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityHeatCollapser extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI {
	
	public int currentBurnTime, currentMaxBurnTime;
	public static float entropyGenerated = 5;
	public static boolean harmEntities = true;
	
	public TileEntityHeatCollapser() {
		super();
		this.setSlotsNum(1);
		this.setMaxEntropy(200);
	}

	public boolean canUpdate(){
		return true;
	}
	
	@Override
	public void updateEntity() {
		if(worldObj.isRemote){
			if(getStackInSlot(0)!=null){
				if(currentBurnTime == 0 && getEntropy() < getMaxEntropy()){
					currentMaxBurnTime=this.currentBurnTime=TileEntityFurnace.getItemBurnTime(getStackInSlot(0));
					if(currentBurnTime > 0){
						currentBurnTime--;
						setEntropy(getEntropy() + 5);
						getStackInSlot(0).stackSize--;
						markDirty();
					}
				}
			}
		}
		super.updateEntity();
	}
	
	@Override
	public Container getContainer(EntityPlayer player){
		return new ContainerHeatCollapser(player.inventory, this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public GuiContainer getGui(EntityPlayer player){
		return new GuiHeatCollapser(getContainer(player), this);
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
