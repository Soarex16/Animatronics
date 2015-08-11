package animatronics.common.tile;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import animatronics.Animatronics;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiHeatCollapser;
import animatronics.client.render.RenderPatterns;
import animatronics.common.inventory.ContainerHeatCollapser;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import animatronics.utils.misc.MiscUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityHeatCollapser extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI{
	
	private int range = 4;
	public int currentBurnTime, maxBurnTime;
	public static float entropyGenerated = 2F;
	public static boolean harmEntities = true;
	int i = 0;
	public TileEntityHeatCollapser() {
		super();
		this.setSlotsNum(1);
		this.setMaxEntropy(500);
	}

	public boolean canUpdate(){
		return true;
	}
	
	@Override
	public void updateEntity() {
		
		if(i <  50){
			i++;
			if(worldObj.isRemote) System.out.println("Server: " + entropy);
			if(!worldObj.isRemote) System.out.println("Client: " + entropy);
		}
		if(currentBurnTime == 0 && entropy < maxEntropy){
			if(getStackInSlot(0) != null && getStackInSlot(0).stackSize != 0 && TileEntityFurnace.isItemFuel(getStackInSlot(0))){
				maxBurnTime = currentBurnTime = TileEntityFurnace.getItemBurnTime(getStackInSlot(0))/4;
				decrStackSize(0, 1);
			}
		}
		if(currentBurnTime > 0){
			if(entropy < maxEntropy){
				for(Object e: worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord-range, yCoord-range, zCoord-range, xCoord+range, yCoord+range, zCoord+range))){
					((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.wither.id, 20, 1));
				}
				currentBurnTime--;
				entropy += entropyGenerated;
			}
		}
		if(entropy > maxEntropy)
			entropy = maxEntropy;
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
		MiscUtils.readEntropy(this, i);
		currentBurnTime = i.getInteger("burn");
		maxBurnTime = i.getInteger("maxburn");
		super.readFromNBT(i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
		MiscUtils.writeEntropy(this, i);
		i.setInteger("burn", currentBurnTime);
		i.setInteger("maxburn", maxBurnTime);
    	super.writeToNBT(i);
    }


}
