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
import animatronics.api.TileEntityPrimary;
import animatronics.api.energy.ITEStoresEntropy;
import animatronics.client.gui.GuiHeatCollapser;
import animatronics.common.inventory.ContainerHeatCollapser;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityHeatCollapser extends TileEntityPrimary implements ITEStoresEntropy, ITileEntityHasGUI{
	
	private int range = 4;
	public int currentBurnTime, maxBurnTime;
	public static float entropyGenerated = 2F;
	public static boolean harmEntities = true;
	public TileEntityHeatCollapser() {
		super();
		setSlotsNum(1);
		maxEntropy = 500;
	}

	public boolean canUpdate(){
		return true;
	}
	
	@Override
	public void updateEntity() {
		for(int i = 0; i < 4; ++i) {
			double time = (this.worldObj.getWorldTime()+9*i)%36 * 10;
			double timeSin = Math.sin(Math.toRadians(time)) * 0.5D;
			double timeCos = Math.cos(Math.toRadians(time)) * 0.5D;
			double x = xCoord + 0.5D + timeSin;
			double y = yCoord + 1.1D;
			double z = zCoord + 0.5D + timeCos;
			worldObj.spawnParticle("flame", x, y, z, 0, 0.1D, 0);
		}
		if(currentBurnTime == 0 && entropy < maxEntropy) {
			if(getStackInSlot(0) != null && getStackInSlot(0).stackSize != 0 && TileEntityFurnace.isItemFuel(getStackInSlot(0))){
				maxBurnTime = currentBurnTime = TileEntityFurnace.getItemBurnTime(getStackInSlot(0))/8;
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
		maxBurnTime = i.getInteger("maxburn");
		super.readFromNBT(i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
		i.setInteger("burn", currentBurnTime);
		i.setInteger("maxburn", maxBurnTime);
    	super.writeToNBT(i);
    }


}
