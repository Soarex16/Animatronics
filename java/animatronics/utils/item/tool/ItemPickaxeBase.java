package animatronics.utils.item.tool;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemPickaxeBase extends ItemPickaxe{

	private final String modId;

	public ItemPickaxeBase(String unlocalizedName, String mod, ToolMaterial material){
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

