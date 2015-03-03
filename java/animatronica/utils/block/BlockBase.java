package animatronica.utils.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockBase extends Block{

	private final String modId;
	
	public BlockBase(String unlocalizedName, String mod, Material material){
		super(material);
		setBlockName(unlocalizedName);
		modId = mod;
		GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
	}
	
	public String getModId(){
		return modId.toLowerCase();
	}
	
	public Block setBlockTextureName(String name){
		textureName = getModId() + ":" + name;
		return this;
	}
}
