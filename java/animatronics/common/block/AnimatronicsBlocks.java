package animatronics.common.block;

import net.minecraft.block.material.Material;
import animatronics.Animatronics;
import animatronics.debug.BlockDebug;
import animatronics.utils.block.ItemBlockAnimatronics;

public class AnimatronicsBlocks {
	
	public static BlockDebug blockDebug;
	public static BlockCreativeEntropyStorage blockCreativeEntropyStorage;
	public static BlockArcaneFlame blockArcaneFlame;
	public static BlockHeatCollapser blockHeatCollapser;
	public static BlockSunCollector blockSunCollector;
	public static BlockMoonPrism blockMoonPrism;
	public static BlockEntropyFurnace blockEntropyFurnace;
	
	public static void init() {
		blockDebug = new BlockDebug();
		blockCreativeEntropyStorage = new BlockCreativeEntropyStorage();
		blockArcaneFlame = new BlockArcaneFlame();
		blockEntropyFurnace = new BlockEntropyFurnace();
		blockHeatCollapser = new BlockHeatCollapser();
		blockSunCollector = new BlockSunCollector(); 
		blockMoonPrism = new BlockMoonPrism();
	}

}
