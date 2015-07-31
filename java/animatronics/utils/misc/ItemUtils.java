package animatronics.utils.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import animatronics.utils.helper.NBTHelper;

public class ItemUtils{

	/** 
	 *  List of all items in the game.
	 */
	public static List<Item> itemList = Lists.newArrayList(Item.itemRegistry.iterator());

	/*public static void numberOfUses(ItemStack iStack, List list){
		if(iStack.getMaxDamage() + 1 - iStack.getItemDamage() < iStack.getMaxDamage() / 3){
			chatFormatting = EnumChatFormatting.RED;
		}else if(iStack.getMaxDamage() + 1 - iStack.getItemDamage() < iStack.getMaxDamage() / 1.4){
			chatFormatting = EnumChatFormatting.YELLOW;
		}else{
			chatFormatting = EnumChatFormatting.GREEN;
		}	
		list.add(I18n.getString("numberOfUses") + " " + chatFormatting + (iStack.getMaxDamage() + 1 - iStack.getItemDamage()));
	}*/

	public static ItemStack getItemStack(Object inputObject){
		if(inputObject instanceof ArrayList){
			if(((ArrayList)inputObject).size() > 0){
				Object obj = ((ArrayList)inputObject).get(0);
				if(obj instanceof ItemStack){
					return (ItemStack)inputObject;
				}else if(obj instanceof Item){
					return new ItemStack((Item)obj);
				}else if(obj instanceof Block){
					return new ItemStack((Block)obj);
				}
			}
		}
		if(inputObject instanceof Item){
			return new ItemStack((Item)inputObject);
		}else if(inputObject instanceof Block){
			return new ItemStack((Block)inputObject);
		}else if(inputObject instanceof ItemStack){
			return (ItemStack)inputObject;
		}
		return null;
	}

	/** 
	 * @author King Lemming 
	 */
	public static boolean areItemStacksEqualNoNBT(ItemStack stackA, ItemStack stackB){
		if(stackB == null || stackA == null){
			return false;
		}
		return stackA.getItem() == stackB.getItem() && (stackA.getItemDamage() == OreDictionary.WILDCARD_VALUE ? true : stackB.getItemDamage() == OreDictionary.WILDCARD_VALUE ? true : !stackA.getHasSubtypes() ? true : stackB.getItemDamage() == stackA.getItemDamage());
	}

	/** 
	 * @author King Lemming 
	 */
	public static boolean itemsEqualWithMetadata(ItemStack stackA, ItemStack stackB, boolean checkNBT){
		return stackA == null ? stackB == null ? true : false : stackB != null && stackA.getItem() == stackB.getItem() && stackA.getItemDamage() == stackB.getItemDamage() && (!checkNBT || doNBTsMatch(stackA.stackTagCompound, stackB.stackTagCompound));
	}

	public static void consumeCurrentItem(EntityPlayer player, int count){
		if(player.capabilities.isCreativeMode){
			return;
		}
		if(player.getCurrentEquippedItem().stackSize <= 0){
			player.setCurrentItemOrArmor(0, null);
		}else{
			player.getCurrentEquippedItem().splitStack(count);
		}
	}

	/** 
	 * @author King Lemming 
	 */
	public static boolean doNBTsMatch(NBTTagCompound nbtA, NBTTagCompound nbtB){
		return nbtA == null ? nbtB == null ? true : false : nbtB == null ? false : nbtA.equals(nbtB);
	}

	public static ItemStack createNewWrittenBook(String author, String title, String[] pageText){
		ItemStack book = new ItemStack(Items.written_book);
		NBTTagCompound nbt = NBTHelper.checkNBT(book);

		nbt.setString("author", author);
		nbt.setString("title", title);
		NBTTagList pages = new NBTTagList();
		for(int i = 0; i < pageText.length; i++){
			pages.appendTag(new NBTTagString(String.valueOf((i + 1))));
		}
		book.setTagInfo("pages", pages);
		return book;
	}

	public static ItemStack cloneStack(ItemStack stack, int stackSize){
		if(stack == null) {
			return null;
		}
		ItemStack retStack = stack.copy();
		retStack.stackSize = stackSize;
		return retStack;
	}
}