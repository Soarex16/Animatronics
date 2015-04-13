package animatronica.debug;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import animatronica.client.render.RenderPatterns;
import animatronica.utils.block.tileentity.TileEntityInventoryBase;
import animatronica.utils.misc.WorldUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityDebug extends  TileEntityInventoryBase {
	
	public TileEntityDebug() {
		super("Cookie generator", true, 1);
	}

	public boolean canUpdate(){
		return true;
	}
	
	public double anim;
	
	public void updateEntity(){
		super.updateEntity();
		anim+=0.9;
		RenderPatterns.spawnFlame(worldObj, xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, 0xFF3900, 0.4F);
		
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
				if(getStackInSlot(0).stackSize > 48){
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
	
	@SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }
}