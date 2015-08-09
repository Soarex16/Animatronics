package animatronics.common.block;

import animatronics.Animatronics;
import animatronics.debug.BlockDebug;
import animatronics.utils.block.ItemBlockAnimatronics;
import net.minecraft.block.material.Material;

public class AnimatronicsBlocks {
	
	public static BlockDebug blockDebug;
	public static BlockCreativeEntropyStorage blockCreativeEntropyStorage;
	public static BlockArcaneFlame blockArcaneFlame;
	
	public static BlockHeatCollapsor blockHeatCollapsor;
	
	public static void init() {
		
		blockDebug = new BlockDebug("blockDebug", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		blockCreativeEntropyStorage = new BlockCreativeEntropyStorage("blockCreativeEntropyStorage", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
		blockArcaneFlame = new BlockArcaneFlame("blockArcaneFlame", Animatronics.MOD_ID, Material.cloth, ItemBlockAnimatronics.class);
	
		blockHeatCollapsor = new BlockHeatCollapsor("blockHeatCollapsor", Animatronics.MOD_ID, Material.iron, ItemBlockAnimatronics.class);
	}

}
