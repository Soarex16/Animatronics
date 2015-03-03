package animatronica.utils.misc;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.google.common.collect.Lists;

public class BlockUtils{
	
	/** 
	 *  List of all blocks in the game.
	 */
	public static List<Block> blockList = Lists.newArrayList(Block.blockRegistry.iterator());
}
