package animatronica;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import animatronica.client.gui.CreativeTabAnimatronica;
import animatronica.network.proxy.CommonProxy;
import animatronica.test.BlockTest;
import animatronica.test.ItemTest;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.helper.UtilRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = Animatronica.MOD_ID, name = Animatronica.MOD_NAME, version = Animatronica.MOD_VERSION)
public class Animatronica {
	
	@Instance(Animatronica.MOD_ID)
	public static Animatronica instance;
	
	public static final String MOD_ID = "Animatronica";
	public static final String MOD_NAME = "Animatronica : biomechanic wizardry";
	public static final String MOD_VERSION = "0.1291.2a";
	
	public static final Logger logger = LogManager.getLogger(MOD_NAME);
	
	@SidedProxy(clientSide = "animatronica.network.proxy.ClientProxy", serverSide= "animatronica.network.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTabAnimatronica = new CreativeTabAnimatronica("Animatronica");
	
	public static BlockTest blockTest;
	
	public static ItemTest itemTest;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		AnimatronicaConfiguration.init(event.getModConfigurationDirectory() + "/Animatronica" + "/Animatronica.cfg");
		UtilRegistry.registerAll();
		
		blockTest = new BlockTest("blockTest", MOD_ID, Material.iron);
		
		itemTest = new ItemTest("itemTest", MOD_ID, 0);
		
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
}
