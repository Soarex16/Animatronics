package dsp.api;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface IPlayerModule extends IModule{
	public void addPlayerInfo(EntityPlayer player, List<String> left, List<String> right, String pagename);

}
