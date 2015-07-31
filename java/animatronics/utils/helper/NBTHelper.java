package animatronics.utils.helper;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class NBTHelper{

	/**
	 * Used for null-safety
	 * 
	 * @param stack
	 */
	public static NBTTagCompound checkNBT(ItemStack stack){
		if(stack.stackTagCompound == null){
			stack.stackTagCompound = new NBTTagCompound();
		}
		return stack.stackTagCompound;
	}

	/**
	 * Shortcut for NBTTagCompound.hasKey()
	 */
	public static boolean verifyKey(ItemStack stack, String name){
		return stack.stackTagCompound.hasKey(name);
	}

	public static void setInteger(ItemStack stack, String name, int value){
		stack.stackTagCompound.setInteger(name, value);
	}

	public static int getInteger(ItemStack stack, String name){
		return stack.stackTagCompound.getInteger(name);
	}

	public static void decreaseInteger(ItemStack stack, String name, int value){
		if(getInteger(stack, name) > 0){
			setInteger(stack, name, getInteger(stack, name) - value);
		}
	}

	public static void decreaseIntegerIgnoreZero(ItemStack stack, String name, int value){
		setInteger(stack, name, getInteger(stack, name) - value);
	}

	public static void setString(ItemStack stack, String name, String value){
		stack.stackTagCompound.setString(name, value);
	}

	public static String getString(ItemStack stack, String name){
		return stack.stackTagCompound.getString(name);
	}

	public static void setBoolean(ItemStack stack, String name, boolean value){
		stack.stackTagCompound.setBoolean(name, value);
	}

	public static boolean getBoolean(ItemStack stack, String name){
		return stack.stackTagCompound.getBoolean(name);
	}

	public static void invertBoolean(ItemStack stack, String name){
		setBoolean(stack, name, !getBoolean(stack, name));
	}

	public static void setByte(ItemStack stack, String name, byte value){
		stack.stackTagCompound.setByte(name, value);
	}

	public static byte getByte(ItemStack stack, String name){
		if(!verifyKey(stack, name)){
			setByte(stack, name, (byte)0);
		}
		return stack.stackTagCompound.getByte(name);
	}
	/*-----------------------------------------------------------------------------------*/
	
	/**
	 * @param stack - the ItemStack to work with.
	 */
	public static void createNBTTag(ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			return;
		}
		NBTTagCompound itemTag = new NBTTagCompound();
		stack.setTagCompound(itemTag);
	}
	
	/**
	 * @param stack - the ItemStack to work with.
	 * @return NBTTagCompound of the ItemStack
	 */
	public static NBTTagCompound getStackTag(ItemStack stack)
	{
		createNBTTag(stack);
		return stack.getTagCompound();
	}
	
	/**
	 * @param t - the TileEntity
	 * @param saveTag - the tag
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
}
