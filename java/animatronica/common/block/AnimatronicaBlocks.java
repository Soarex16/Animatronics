package animatronica.common.block;

import animatronica.Animatronica;
import animatronica.debug.BlockDebug;
import animatronica.utils.block.ItemBlockAnimatronica;
import net.minecraft.block.material.Material;

public class AnimatronicaBlocks {
	
	public static BlockDebug blockDebug;
	public static BlockCreativeEntropyStorage blockCreativeEntropyStorage;
	public static BlockArcaneFlame blockArcaneFlame;
	
	public static void init() {
		
		blockDebug = new BlockDebug("blockDebug", Animatronica.MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		blockCreativeEntropyStorage = new BlockCreativeEntropyStorage("blockCreativeEntropyStorage", Animatronica.MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		blockArcaneFlame = new BlockArcaneFlame("blockArcaneFlame", Animatronica.MOD_ID, Material.cloth, ItemBlockAnimatronica.class);
	}

}
