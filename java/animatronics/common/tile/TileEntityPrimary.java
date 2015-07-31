package animatronics.common.tile;

import java.util.UUID;

import animatronics.api.energy.ITEHasEntropy;
import animatronics.utils.block.tileentity.ITileEntityHasGUI;
import animatronics.utils.config.AnimatronicaConfiguration;
import animatronics.utils.misc.EnergyUtils;
import animatronics.utils.misc.Vector3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;

public abstract class TileEntityPrimary extends TileEntity implements ITEHasEntropy ,ISidedInventory {
	
	private ItemStack[] inventoryContents = new ItemStack[1];
	int entropy;
	int maxEntropy = AnimatronicaConfiguration.maxEntropy;
	public Vector3 storageCoord;
	UUID uuid = UUID.randomUUID();
	
	public abstract int[] getOutputSlots();
	
	public TileEntityPrimary(){
		super();
	}
	
	public void setSlotsNum(int i)
	{
		inventoryContents = new ItemStack[i];
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
		loadInventory(this, i);
		EnergyUtils.loadEntropyState(this, i);
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
    	EnergyUtils.saveEntropyState(this, i);
    }
	
	public void saveInventory(TileEntity tileEntity, NBTTagCompound saveTag)
	{/*
			IInventory tile = (IInventory) tileEntity;
	        NBTTagList nbttaglist = new NBTTagList();
	        for (int i = 0; i < tile.getSizeInventory(); ++i)
	        {
	            if (tile.getStackInSlot(i) != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                tile.getStackInSlot(i).writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        saveTag.setTag("Items", nbttaglist);
		}*/
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
	{/*
			IInventory tile = (IInventory) tileEntity;
			for(int i = 0; i < tile.getSizeInventory(); ++i)
			{
				tile.setInventorySlotContents(i, null);
			}
	        NBTTagList nbttaglist = loadTag.getTagList("Items", 10);
	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            byte b0 = nbttagcompound1.getByte("Slot");
	
	            if (b0 >= 0 && b0 < tile.getSizeInventory())
	            {
	            	tile.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
	            }
		}*/
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
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, -10, nbttagcompound);
    }
	
	@Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
		if(net.getNetHandler() instanceof INetHandlerPlayClient)
			if(pkt.func_148853_f() == -10)
				this.readFromNBT(pkt.func_148857_g());
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
