package animatronics.utils.item.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import animatronics.utils.item.ItemBase;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorBase extends ItemArmor{

	private String modId;
	private String type;

	public ItemArmorBase(ArmorMaterial material, String unlicalizedName, String armorType, int armorIndex){
		super(material, 0, armorIndex);
		setUnlocalizedName(unlicalizedName);
		type = armorType;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}
	
	public ItemArmorBase setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
	
	public String getModId(){
		return modId.toLowerCase();
	}
	
	public ItemArmorBase setModId(String value){
		modId = value;
		return this;
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack iStack){
		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack legs = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);
	}

	public String getArmorTexture(ItemStack iStack, Entity entity, int slot, String string){
		return getModId() + ":textures/armors/" + type + "_layer_" + (armorType != 2 ? 1 : 2) + ".png";
	}
}