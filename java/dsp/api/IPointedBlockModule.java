package dsp.api;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

public interface IPointedBlockModule extends IModule{
	public void addBlockInfo(EntityPlayer player, Block block, List<String> left, List<String> right, String pagename);

}
