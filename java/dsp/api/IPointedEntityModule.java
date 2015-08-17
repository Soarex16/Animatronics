package dsp.api;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface IPointedEntityModule extends IModule{
	public void addEntityInfo(EntityPlayer player, Entity e, List<String> left, List<String> right, String pagename);

}
