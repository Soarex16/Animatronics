package animatronics.api;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import animatronics.Animatronics;
import animatronics.api.energy.ITEHasEntropy;
import animatronics.api.misc.Vector3;
import animatronics.network.PacketSender;
import animatronics.utils.config.AnimatronicsConfiguration;
import animatronics.utils.handler.DataStatHandler;
import animatronics.utils.misc.EnergyUtils;

public abstract class TileEntityPrimary extends TileEntity implements ITEHasEntropy ,ISidedInventory {
	
	private ItemStack[] inventoryContents = new ItemStack[1];
	private DataStatHandler tracker;
	protected int entropy;
	protected int maxEntropy = AnimatronicsConfiguration.maxEntropy;
	public Vector3 storageCoord;
	UUID uuid = UUID.randomUUID();
	public int syncTick;
	
	public abstract int[] getOutputSlots();
	
	public TileEntityPrimary(){
		super();
	}
	
	public void setSlotsNum(int i)
	{
		inventoryContents = new ItemStack[i];
	}
	
	public void updateEntity() {
		if(syncTick == 0) {
			if(tracker == null)
				Animatronics.logger.debug("[Animatronics][WARNING][SEVERE]TileEntity "+this+" at pos "+this.xCoord+","+this.yCoord+","+this.zCoord+" has no DataStatTracker attached to it.");
			else
				if(!worldObj.isRemote && tracker.tileNeedsSyncing()) {
					PacketSender.sendPacketToAllAround(worldObj, getDescriptionPacket(), xCoord, yCoord, zCoord, worldObj.provider.dimensionId, 64);
				}
			syncTick = 60;
		} else
			--syncTick;
		EnergyUtils.manage(this, 0.5F, 0.5F, 0.5F);
	}
	
	/* read/write NBT, Entropy, Inventory */
	@Override
    public void readFromNBT(NBTTagCompound i)
    {
		super.readFromNBT(i);
		if(i.hasKey("coordX") && i.hasKey("coordY") && i.hasKey("coordZ"))
		{	
			storageCoord = new Vector3(i.getDouble("coordX"),i.getDouble("coordY"), i.getDouble("coordZ"));
		}else
			this.storageCoord = null;
		EnergyUtils.readEntropy(this, i);
		loadInventory(this, i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
		super.writeToNBT(i);
		if(storageCoord != null)
		{
			i.setDouble("coordX", storageCoord.x);
			i.setDouble("coordY", storageCoord.y);
			i.setDouble("coordZ", storageCoord.z);
		}
    	saveInventory(this, i);
    	EnergyUtils.writeEntropy(this, i);
    }
	
	public void saveInventory(TileEntity tileEntity, NBTTagCompound saveTag)
	{
		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < inventoryContents.length; i++){
			if(inventoryContents[i] != null){
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				inventoryContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		saveTag.setTag("Items", nbttaglist);
	}
	
	public void loadInventory(TileEntity tileEntity, NBTTagCompound loadTag)
	{
		NBTTagList nbttaglist = loadTag.getTagList("Items", 10);
		inventoryContents = new ItemStack[getSizeInventory()];
		for(int i = 0; i < nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			if(slot >= 0 && slot < inventoryContents.length){
				inventoryContents[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
    public Packet getDescriptionPacket()
    {
		S35PacketUpdateTileEntity packet = (S35PacketUpdateTileEntity)super.getDescriptionPacket();
		NBTTagCompound dataTag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		writeToNBT(dataTag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, dataTag);
    }
	
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
    {
		super.onDataPacket(net, packet);
		NBTTagCompound tag = packet != null ? packet.func_148857_g() : new NBTTagCompound();
		readFromNBT(tag);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
	
	@Override
	public int getEntropy() {
		return entropy;
	}

	@Override
	public int getMaxEntropy() {
		return maxEntropy;
	}

	@Override
	public boolean setEntropy(int i) {
		entropy = i;
		return true;
	}

	@Override
	public boolean setMaxEntropy(float f) {
		maxEntropy = (int)f;
		return true;
	}

	@Override
	public UUID getUUID() {
		return uuid;
	}
	
	@Override
	public String getInventoryName() {
		return "animatronics.container.generic";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public int getSizeInventory() {
		return this.inventoryContents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotId) {
		return this.inventoryContents[slotId];
	}
	
	@Override
	public ItemStack decrStackSize(int slotId, int stackSize){
		if(inventoryContents[slotId] != null){
			ItemStack iStack;
			if(inventoryContents[slotId].stackSize <= stackSize){
				iStack = inventoryContents[slotId];
				inventoryContents[slotId] = null;
				markDirty();
				return iStack;
			}else{
				iStack = inventoryContents[slotId].splitStack(stackSize);
				if(inventoryContents[slotId].stackSize == 0){
					inventoryContents[slotId] = null;
				}
				markDirty();
				return iStack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotId){
		if(inventoryContents[slotId] != null){
			ItemStack itemstack = inventoryContents[slotId];
			inventoryContents[slotId] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slotId, ItemStack iStack){
		inventoryContents[slotId] = iStack;
		if(iStack != null && iStack.stackSize > getInventoryStackLimit()){
			iStack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}
	
	@Override
	public int getInventoryStackLimit(){
		return 64;
	}

	@Override
	public void markDirty(){
		super.markDirty();
		onInventoryChanged();
	}

	public void onInventoryChanged(){}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer){
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory(){
		
	}

	@Override
	public void closeInventory(){
		
	}

	@Override
	public boolean isItemValidForSlot(int slotId, ItemStack iStack){
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		if(this.getSizeInventory() > 0)
		{
			if(side == 1)
				return new int[]{0};
			else
			{
				int[] retInt = new int[this.getSizeInventory()-1];
				for(int i = 1; i < this.getSizeInventory(); ++i)
				{
					retInt[i-1] = i;
				}
				return retInt;
			}
		}
		else
			return new int[]{};
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return true;
	}
}