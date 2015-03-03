package animatronica.utils.helper;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/** 
 * @author Agravaine
 */
public class ItemStackHash{

	private ItemStack iStack;

	private boolean doCheckNBT = false;
	private boolean doCheckStackSize = false;
	private boolean doCheckDamage = false;

	public ItemStackHash(Block block){
		this(block, 1);
	}

	public ItemStackHash(Block block, int count){
		this(block, count, 0);
	}

	public ItemStackHash(Block block, int count, int damage){
		this(Item.getItemFromBlock(block), count, damage);
	}

	public ItemStackHash(Item item){
		this(item, 1);
	}

	public ItemStackHash(Item item, int count){
		this(item, count, 0);
	}

	public ItemStackHash(Item item, int count, int damage){
		iStack = new ItemStack(Preconditions.checkNotNull(item, "Item is null!"), count, damage);
	}

	public ItemStackHash(ItemStack itemStack){
		iStack = Preconditions.checkNotNull(itemStack, "ItemStack is null!");
	}

	private ItemStackHash(){
		throw new UnsupportedOperationException("Unsupported empty constructor!");
	}

	public ItemStackHash setDoCheckDamage(){
		doCheckDamage = true;
		return this;
	}

	public ItemStackHash setDoCheckStackSize(){
		doCheckStackSize = true;
		return this;
	}

	public ItemStackHash setDoCheckNBT(){
		doCheckNBT = true;
		return this;
	}

	public ItemStackHash setChecks(ItemStackHash parent){
		doCheckNBT = parent.doCheckNBT;
		doCheckDamage = parent.doCheckDamage;
		doCheckStackSize = parent.doCheckStackSize;
		return this;
	}

	public ItemStack toItemStack(){ 
		return iStack;
	}

	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + Item.getIdFromItem(iStack.getItem());
		result = prime * result + (doCheckDamage ? iStack.getItemDamage() : 0);
		result = prime * result + (doCheckStackSize ? iStack.stackSize : 0);
		result = prime * result + (doCheckNBT && iStack.hasTagCompound() ? iStack.stackTagCompound.hashCode() : 0);
		return result;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof ItemStackHash)){
			return false;
		}

		ItemStackHash hashStack = (ItemStackHash)obj;

		if(Item.getIdFromItem(iStack.getItem()) != Item.getIdFromItem(hashStack.iStack.getItem())){
			return false;
		}

		if(doCheckDamage && iStack.getItemDamage() != hashStack.iStack.getItemDamage()){
			return false;
		}

		if(doCheckNBT && iStack.stackTagCompound != hashStack.iStack.stackTagCompound){
			return false;
		}

		if(doCheckStackSize && iStack.stackSize != hashStack.iStack.stackSize){
			return false;
		}

		return true;
	}

	public String toString(){
		return iStack.toString();
	}
}
