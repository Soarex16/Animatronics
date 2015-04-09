package animatronica.common.block;

import net.minecraft.block.material.Material;
import animatronica.Animatronica;
import animatronica.debug.BlockDebug;
import animatronica.utils.block.ItemBlockAnimatronica;

public class AnimatronicaBlocks {
	
	public static BlockDebug blockDebug;
	
	public static void init() {
		
		blockDebug = new BlockDebug("blockDebug", Animatronica.MOD_ID, Material.iron, ItemBlockAnimatronica.class);

		
	}

}
