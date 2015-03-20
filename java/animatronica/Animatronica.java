package animatronica;

import java.util.UUID;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import animatronica.api.energy.ItemEnergyFocus;
import animatronica.client.gui.CreativeTabAnimatronica;
import animatronica.debug.BlockDebug;
import animatronica.debug.BlockMisc;
import animatronica.debug.ItemDebug;
import animatronica.network.proxy.CommonProxy;
import animatronica.utils.block.ItemBlockAnimatronica;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.helper.UtilRegistry;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


@Mod(modid = Animatronica.MOD_ID, name = Animatronica.MOD_NAME, version = Animatronica.MOD_VERSION, guiFactory = Animatronica.ANIMATRONICA_GUI_FACTORY)
public class Animatronica {
	
	@Instance(Animatronica.MOD_ID)
	public static Animatronica instance;
	
	public static final String MOD_ID = "Animatronica";
	public static final String MOD_NAME = "Animatronica : biomechanic wizardry";
	public static final String MOD_VERSION = "0.1291.12a";
	public static final String ANIMATRONICA_GUI_FACTORY= "animatronica.utils.config.AnimatronicaConfigGuiFactory";
	
	public static final Logger logger = LogManager.getLogger(MOD_NAME);
	
	@SidedProxy(clientSide = "animatronica.network.proxy.ClientProxy", serverSide= "animatronica.network.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Configuration configFile;
	public static CreativeTabs creativeTabAnimatronica = new CreativeTabAnimatronica("Animatronica");
	
	public static BlockMisc blockMisc;
	public static BlockDebug blockTest;
	
	public static ItemDebug itemTest;
	
	public static ItemEnergyFocus itemEnergyFocus;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		AnimatronicaConfiguration.init(event.getModConfigurationDirectory() + "/Animatronica" + "/Animatronica.cfg");
		
		UtilRegistry.registerAll();
		
		blockMisc = new BlockMisc("blockMisc", MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		
		blockTest = new BlockDebug("blockDebug", MOD_ID, Material.iron, ItemBlockAnimatronica.class);
		
		itemTest = new ItemDebug("itemDebug", MOD_ID, 0);
		
		itemEnergyFocus = new ItemEnergyFocus("itemEnergyFocus", MOD_ID, 0);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerAll();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {

	}
	
	public String getModId(){
		return MOD_ID;
	}

	public String getModName(){
		return MOD_NAME;
	}

	public String getModVersion(){
		return MOD_VERSION;
	}
	
	public static GameProfile AnimatronicaFakePlayerProfile = new GameProfile(UUID.fromString("11d2c6d2-c663-4d82-8a29-2999e1fc8a79"), "[Animatronica]");
}