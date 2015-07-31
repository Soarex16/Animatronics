package animatronics.common.block;

import animatronics.Animatronics;
import animatronics.debug.BlockDebug;
import animatronics.utils.block.ItemBlockAnimatronica;
import net.minecraft.block.material.Material;

public class AnimatronicaBlocks {
	
	public static BlockDebug blockDebug;
	public static BlockCreativeEntropyStorage blockCreativeEntropyStorage;
	public static BlockArcaneFlame blockArcaneFlame;
	
	public static void init() {
		
		blockDebug = new BlockDebug("blockDebug", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		blockCreativeEntropyStorage = new BlockCreativeEntropyStorage("blockCreativeEntropyStorage", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		blockArcaneFlame = new BlockArcaneFlame("blockArcaneFlame", Animatronics.MOD_ID, Material.cloth, ItemBlockAnimatronica.class);
	}

}
