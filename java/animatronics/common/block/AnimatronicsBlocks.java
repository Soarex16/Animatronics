package animatronics.common.block;

import java.lang.reflect.Field;

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
	public static BlockEntropyCrusher blockEntropyCrusher;
	public static BlockLightingAbsorber blockLightingAbsorber;
	
	public static void init_test() throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		for(Field f : AnimatronicsBlocks.class.getFields()){
			f.set(null, f.getType().newInstance());
		}
	}

}
