package animatronics.common.block;

import animatronics.debug.BlockDebug;

public class AnimatronicsBlocks {
	
	public static BlockDebug blockDebug;
	public static BlockCreativeEntropyStorage blockCreativeEntropyStorage;
	public static BlockArcaneFlame blockArcaneFlame;
	public static BlockHeatCollapser blockHeatCollapser;
	public static BlockSunCollector blockSunCollector;
	public static BlockMoonPrism blockMoonPrism;
	public static BlockEntropyFurnace blockEntropyFurnace;
	public static BlockFabricatorOfEverything blockFabricatorOfEverything;
	public static BlockGatewayMirror blockGatewayMirror;
	public static BlockNothing blockNothing;
	
	public static void init() {
		blockDebug = new BlockDebug();
		blockCreativeEntropyStorage = new BlockCreativeEntropyStorage();
		blockArcaneFlame = new BlockArcaneFlame();
		blockEntropyFurnace = new BlockEntropyFurnace();
		blockHeatCollapser = new BlockHeatCollapser();
		blockSunCollector = new BlockSunCollector(); 
		blockMoonPrism = new BlockMoonPrism();
		blockFabricatorOfEverything = new BlockFabricatorOfEverything();
		blockGatewayMirror = new BlockGatewayMirror();
		blockNothing = new BlockNothing();
	}

}
