package animatronica.utils.item.tool;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemShovelBase extends ItemSpade{

	private final String modId;

	public ItemShovelBase(String unlocalizedName, String mod, ToolMaterial material){
		super(material);
		setUnlocalizedName(unlocalizedName);
		modId = mod;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	public String getModId(){
		return modId.toLowerCase();
	}

	public ItemTool setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
}

