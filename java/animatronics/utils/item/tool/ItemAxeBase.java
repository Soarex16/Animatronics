package animatronics.utils.item.tool;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemAxeBase extends ItemAxe{

	private final String modId;
	
	public ItemAxeBase(String unlocalizedName, String mod, ToolMaterial material){
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

