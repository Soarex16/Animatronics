package dsp.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class DebugScreenCategory {
	
	
	private String name;
	private List<String> pages;
	
	/**
	 * @param displayName Name of category that'd be displayed while rendering debug screen.
	 */
	public DebugScreenCategory(String displayName){
		this.name = displayName;
		pages = new ArrayList<String>();
		pages.add("Minecraft");
	}
	
	public List<String> getPageList(){
		return pages;
	}
	/**
	 * Method that called every tick to change displayed info to current.
	 * Minecraft can be get using Minecraft.getMinecraft()
	 * MinecraftServer can be get using MinecraftServer.getServer()
	 * @param left Strings that'd be displayed on left side of the screen.
	 * @param right Strings that'd be displayed on right side of the screen.
	 * @param player Player that uses the debug screen (Minecraft.getMinecraft().thePlayer)
	 * @param world  Minecraft world. (Minecraft.getMinecraft().theWorld)
	 * @param modderInfo Used to hide info that useless for common users. Can be toggled by pressing [TAB] key.
	 */
	public abstract void processInfo(List<String> left, List<String> right, EntityPlayer player, World world, boolean modderInfo, String page);

	public String getName(){
		return name;
	}
	
	public String booleanString(boolean b){
		return DebugScreenPlusAPI.booleanString(b);
	}
	
	public void addPage(String name){
		pages.add(name);
	}
}
