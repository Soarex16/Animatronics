package animatronica.utils.helper;

import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * A bunch of helpers for easier item NBT cooldown
 * 
 * @author mak326428
 * 
 */
public class Cooldownable{

	public static final String COOLDOWN_NBT = "animatronica:cooldown";

	/**
	 * Call this onUpdate() in your Item WARNING: you should check for
	 * !world.isRemote
	 * 
	 * @param iStack
	 *            stack to update
	 * @param maxCooldown
	 *            maximum cooldown
	 */
	public static void onUpdate(ItemStack iStack, int maxCooldown){
		NBTHelper.checkNBT(iStack);
		if(!NBTHelper.verifyKey(iStack, COOLDOWN_NBT)){
			NBTHelper.setInteger(iStack, COOLDOWN_NBT, maxCooldown);
		}
		if(NBTHelper.getInteger(iStack, COOLDOWN_NBT) > 0){
			NBTHelper.decreaseInteger(iStack, COOLDOWN_NBT, 1);
		}
	}
	
	/**
	 * Checks for cooldown. Call it when your item needs to be used
	 * 
	 * @param iStack
	 *            Stack to check
	 * @param maxCooldown
	 *            Maximum cooldown
	 * @return True if item's cooldown is zero, returns true and sets it to
	 *         maximum, otherwise false
	 */
	public static boolean canUse(ItemStack iStack, int maxCooldown){
		NBTHelper.checkNBT(iStack);
		if(NBTHelper.getInteger(iStack, COOLDOWN_NBT) > 0){
			return false;
		}else{
			NBTHelper.setInteger(iStack, COOLDOWN_NBT, maxCooldown);
			return true;
		}
	}
	
	/**
	 * Call this addInformation() in your Item
	 * 
	 * @param iStack
	 *            stack to update
	 * @param info
	 *            cooldown text
	 */
	public static void displayCooldown(ItemStack iStack, List info){
		NBTHelper.checkNBT(iStack);
		if(NBTHelper.getInteger(iStack, COOLDOWN_NBT) > 0){
			info.add("Cooldown: " + NBTHelper.getInteger(iStack, COOLDOWN_NBT));
		}else{
			info.add("Cooldown: ready");
		}
	}
}