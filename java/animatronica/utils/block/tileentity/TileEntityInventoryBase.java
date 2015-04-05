package animatronica.utils.block.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityInventoryBase extends TileEntity implements IInventory, ITileEntityHasGUI{

	private String inventoryTitle;
	private int slotsCount;
	public ItemStack[] inventoryContents;
	private boolean hasCustomTitle;

	public TileEntityInventoryBase(String name, boolean hasCustomName, int countSlots){
		inventoryTitle = name;
		hasCustomTitle = hasCustomName;
		slotsCount = countSlots;
		inventoryContents = new ItemStack[slotsCount];
	}

	public ItemStack getStackInSlot(int slotId){
		return inventoryContents[slotId];
	}

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

	public ItemStack getStackInSlotOnClosing(int slotId){
		if(inventoryContents[slotId] != null){
			ItemStack itemstack = inventoryContents[slotId];
			inventoryContents[slotId] = null;
			return itemstack;
		}
		return null;
	}

	public void setInventorySlotContents(int slotId, ItemStack iStack){
		inventoryContents[slotId] = iStack;
		if(iStack != null && iStack.stackSize > getInventoryStackLimit()){
			iStack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		inventoryContents = new ItemStack[getSizeInventory()];
		for(int i = 0; i < nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			if(slot >= 0 && slot < inventoryContents.length){
				inventoryContents[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
		if(nbt.hasKey("CustomName", 8)){
			inventoryTitle = nbt.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < inventoryContents.length; i++){
			if(inventoryContents[i] != null){
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				inventoryContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
		if(hasCustomInventoryName()){
			nbt.setString("CustomName", inventoryTitle);
		}
	}

/*	
	@Override
    public void readFromNBT(NBTTagCompound i)
    {
		super.readFromNBT(i);
		loadInventory(this, i);
    }
	
	@Override
    public void writeToNBT(NBTTagCompound i)
    {
    	super.writeToNBT(i);
    	saveInventory(this, i);
    }
*/
	
	public static void saveInventory(TileEntity t, NBTTagCompound saveTag)
	{
		if(t instanceof IInventory)
		{
			IInventory tile = (IInventory) t;
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
	        }
	        saveTag.setTag("Items", nbttaglist);
		}
	}
	
	/**
	 * @param t - the TileEntity
	 * @param loadTag - the tag
	 */
	public static void loadInventory(TileEntity t, NBTTagCompound loadTag)
	{
		if(t instanceof IInventory)
		{
			IInventory tile = (IInventory) t;
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
	        }
		}
	}

	public int getSizeInventory(){
		return slotsCount;
	}

	public String getInventoryName(){
		return inventoryTitle;
	}

	public boolean hasCustomInventoryName(){
		return hasCustomTitle;
	}

	public void setTitle(String name){
		hasCustomTitle = true;
		inventoryTitle = name;
	}

	public int getInventoryStackLimit(){
		return 64;
	}

	public void markDirty(){
		super.markDirty();
		onInventoryChanged();
	}

	public void onInventoryChanged(){}

	public boolean isUseableByPlayer(EntityPlayer entityplayer){
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	public void openInventory(){}

	public void closeInventory(){}

	public boolean isItemValidForSlot(int slotId, ItemStack iStack){
		return true;
	}
}
