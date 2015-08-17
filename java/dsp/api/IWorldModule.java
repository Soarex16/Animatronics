package dsp.api;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IWorldModule extends IModule{
	public void addWorldInfo(EntityPlayer player, World world, List<String> left, List<String> right, String pagename);
}
