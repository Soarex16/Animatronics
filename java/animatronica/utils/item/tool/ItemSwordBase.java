package animatronica.utils.item.tool;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSwordBase extends ItemSword{

	private final String modId;

	public ItemSwordBase(String unlocalizedName, String mod, ToolMaterial material){
		super(material);
		setUnlocalizedName(unlocalizedName);
		modId = mod;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	public String getModId(){
		return modId.toLowerCase();
	}

	public ItemSwordBase setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
}
