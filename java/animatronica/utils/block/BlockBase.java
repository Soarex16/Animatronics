package animatronica.utils.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockBase extends Block{

	private final String modId;
	
	//public BlockBase(String unlocalizedName, String mod, Material material)
	public BlockBase(String unlocalizedName, String mod, Material material, Class itemBlockClass){
		super(material);
		setBlockName(unlocalizedName);
		modId = mod;
		
		if(itemBlockClass == null)
		{
			GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
		}else
		{
			GameRegistry.registerBlock(this, itemBlockClass, getUnlocalizedName().substring(5));
		}
		
		//GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
	}
	
	public String getModId(){
		return modId.toLowerCase();
	}
	
	public Block setBlockTextureName(String name){
		textureName = getModId() + ":" + name;
		return this;
	}
}
