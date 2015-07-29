package animatronica.debug;

import animatronica.Animatronica;
import animatronica.api.energy.ITERequiresEntropy;
import animatronica.client.render.RenderPatterns;
import animatronica.common.tile.TileEntityPrimary;
import animatronica.utils.block.tileentity.ITileEntityHasGUI;
import animatronica.utils.misc.WorldUtils;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityDebug extends  TileEntityPrimary implements ITERequiresEntropy , ITileEntityHasGUI{
	
	public TileEntityDebug() {
		super();
		this.setSlotsNum(1);
		this.setEntropy(1000);
	}

	public boolean canUpdate(){
		return true;
	}
	
	public double anim;
	
	public void updateEntity(){
		super.updateEntity();
		anim+=0.9;
		/*	if (this.worldObj.rand.nextInt(9 - Animatronica.proxy.particleCount(2)) == 0) {
				Animatronica.proxy.wispFX3(this.worldObj, this.xCoord + 0.5F, this.yCoord + 0.5F, this.zCoord + 0.5F, this.xCoord + 0.3F + this.worldObj.rand.nextFloat() * 0.4F, this.yCoord + 0.5F, this.zCoord + 0.3F + this.worldObj.rand.nextFloat() * 0.4F, 0.5F, 4, true, -0.025F);
			}*/
		//	if (this.worldObj.rand.nextInt(15 - Animatronica.proxy.particleCount(4)) == 0) {
		//		Animatronica.proxy.wispFX3(this.getWorldObj(), this.xCoord + 0.5F, this.yCoord + 0.5F, this.zCoord + 0.5F, this.xCoord + 0.4F + this.worldObj.rand.nextFloat() * 0.2F, this.yCoord + 0.5F, this.zCoord + 0.4F + this.worldObj.rand.nextFloat() * 0.2F, 0.25F, 1, true, -0.02F);
		//	}
		RenderPatterns.spawnFlame(worldObj, xCoord + 0.5, yCoord + 0.4, zCoord + 0.5, 0xFF3900, 0.4F);
		if(worldObj.isRemote){
			return;
		}
		if(worldObj.getTotalWorldTime() % 50 == 0){
			if(!canWork()){
				return;
			}
		}
		if(worldObj.getTotalWorldTime() % (2000) == 0){
			if(getStackInSlot(0) == null){
				setInventorySlotContents(0, new ItemStack(Items.cookie));
			}else{
				if(getStackInSlot(0).stackSize < getInventoryStackLimit()){
					getStackInSlot(0).stackSize++;
				}
				if(getStackInSlot(0).stackSize > 60){
					WorldUtils.dropItemInRandomCoords(worldObj, new ItemStack(Items.wheat), xCoord, yCoord, zCoord);
				}
			}
		}
	}
	
	public boolean canWork(){
		return true; 
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack iStack){
		return false;
	}

	@Override
	public void markDirty(){
		super.markDirty();
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public ItemStack decrStackSize(int slot, int quantity){
		ItemStack stack = super.decrStackSize(slot, quantity);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		return stack;
	}

	@Override
	public Packet getDescriptionPacket(){
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity)super.getDescriptionPacket();
		NBTTagCompound dataTag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		writeToNBT(dataTag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, dataTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet){
		super.onDataPacket(net, packet);
		NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		readFromNBT(tag);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	@Override
	public Container getContainer(EntityPlayer player){
		return new ContainerDebug(player.inventory, this);
	}

	@Override
	public GuiContainer getGui(EntityPlayer player){
		return new GuiDebug(player.inventory, this);
		//return new GuiDebug(new ContainerDebug(player.inventory, this), this);
	}
	
	@Override
	public int[] getOutputSlots() {
		return new int[0];
	}
	/* CAN CAUSE LAGS
	@SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }*/
}