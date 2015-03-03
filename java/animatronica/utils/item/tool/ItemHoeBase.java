package animatronica.utils.item.tool;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHoeBase extends ItemHoe{

	private final String modId;

	public ItemHoeBase(String unlocalizedName, String mod, ToolMaterial material){
		super(material);
		setUnlocalizedName(unlocalizedName);
		modId = mod;
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	public String getModId(){
		return modId.toLowerCase();
	}

	public ItemHoeBase setTextureName(String name){
		iconString = getModId() + ":" + name;
		return this;
	}
}

