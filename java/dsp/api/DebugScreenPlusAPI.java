
package dsp.api;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * DebugScreen+ API.
 * @author abcdmult 
 * @version 1.1.1710.b1
 */
public class DebugScreenPlusAPI {
	
	public static Hashtable<Material, String> materials = new Hashtable<Material, String>();
	public static Hashtable<CreativeTabs, String> cretiveTabs = new Hashtable<CreativeTabs, String>();
	public static String [] colors = {"white", "orange", "magenta", "light blue", "yellow", "lime", "pink", "gray", "light gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

	
	/**
	 * Registers category.
	 * @param category Category to register.
	 */
	public static void registerCategory(DebugScreenCategory category, String modid){
		MinecraftForge.EVENT_BUS.post(new EventRegisterCategory(category, modid));
	}
	/**
	 * Registers module.
	 * @param module
	 */
	public static void registerModule(IModule module, String modid){
		MinecraftForge.EVENT_BUS.post(new EventRegisterModule(module, modid));
	}
	
	
	public static void addPageToExistingCategory(String pageName, String categoryName){
		MinecraftForge.EVENT_BUS.post(new EventAddPageToCategory(pageName, categoryName));
	}
	/**
	 * Fancy string.
	 * @param b Value
	 * @return Green (if b is true) or red (if b is false) string with value of b.
	 */
	public static String booleanString(boolean b){
		return b? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false";	
	}
	/**
	 * Minecraft instance.
	 * @return Minecraft.
	 */
	public static Minecraft getMinecraft(){
		return Minecraft.getMinecraft();
	}
	/**
	 * Pointed entity.
	 * @return Pointed entity.
	 */
	public static Entity getPointedEntity(){
		return getMinecraft().pointedEntity;
	}
	
	/**
	 * Minecraft Server instance.
	 * @return Minecraft server.
	 */
	public static MinecraftServer getServer(){
		return MinecraftServer.getServer();
	}
	
	/**
	 * Pointed block.
	 * @param w
	 * @param p
	 * @return
	 */
	public static Block pointedBlock(World w){
		MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(64, 1F);
		if(mop != null) return w.getBlock(mop.blockX, mop.blockY,mop.blockZ);
		return Blocks.air;
	}
	
	public static MovingObjectPosition pointedObject(EntityPlayer p, World w){
		MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(15, 1F);
        return mop;
	}
}
