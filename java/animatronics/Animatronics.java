package animatronics;

import java.util.UUID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import animatronics.api.crafting.EntropyFurnaceRecipes;
import animatronics.client.gui.CreativeTabAnimatronics;
import animatronics.common.block.AnimatronicsBlocks;
import animatronics.common.integration.DebugScreenIntegration;
import animatronics.common.item.AnimatronicsItems;
import animatronics.network.proxy.CommonProxy;
import animatronics.utils.config.AnimatronicsConfiguration;
import animatronics.utils.helper.UtilRegistry;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import dsp.api.DebugScreenPlusAPI;

@Mod(modid = Animatronics.MOD_ID, name = Animatronics.MOD_NAME, version = Animatronics.MOD_VERSION, guiFactory = Animatronics.ANIMATRONICS_GUI_FACTORY)
public class Animatronics {
	
	@Instance(Animatronics.MOD_ID)
	public static Animatronics instance;
	
	public static final String MOD_ID = "Animatronics";
	public static final String MOD_NAME = "Animatronics : biomechanic wizardry";
	public static final String MOD_VERSION = "0.1291.57a";
	public static final String ANIMATRONICS_GUI_FACTORY= "animatronics.utils.config.AnimatronicsConfigGuiFactory";
		
	public static final SimpleNetworkWrapper packetSender = NetworkRegistry.INSTANCE.newSimpleChannel(Animatronics.MOD_ID);
	public static final Logger logger = LogManager.getLogger(MOD_NAME);
	
	@SidedProxy(clientSide = "animatronics.network.proxy.ClientProxy", serverSide= "animatronics.network.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Configuration configFile;
	public static CreativeTabs creativeTabAnimatronics = new CreativeTabAnimatronics();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		AnimatronicsConfiguration.init(event.getModConfigurationDirectory() + "/Animatronics" + "/Animatronics.cfg");
		UtilRegistry.registerAll();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		AnimatronicsBlocks.init();
		AnimatronicsItems.init();
		
		proxy.registerAll();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		DebugScreenPlusAPI.addPageToExistingCategory("Animatronics", "Held item");
		DebugScreenPlusAPI.addPageToExistingCategory("Animatronics", "Pointed block");
		DebugScreenPlusAPI.registerModule(new DebugScreenIntegration.HeldItem(), MOD_ID);
		DebugScreenPlusAPI.registerModule(new DebugScreenIntegration.PointedBlock(), MOD_ID);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {}

	public static GameProfile AnimatronicsFakePlayerProfile = new GameProfile(UUID.fromString("11d2c6d2-c663-4d82-8a29-2999e1fc8a79"), "[Animatronics]");
}