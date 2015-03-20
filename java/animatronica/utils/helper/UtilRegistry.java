package animatronica.utils.helper;

import animatronica.Animatronica;
import animatronica.utils.handler.AEventHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import animatronica.utils.handler.AGuiHandler;

public class UtilRegistry {

	public static void registerAll(){
		if(FMLCommonHandler.instance().getSide().isClient()){
			clientRegistry();
		}
		serverRegistry();
	}

	public static void clientRegistry(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronica.instance, new AGuiHandler());
		FMLCommonHandler.instance().bus().register(new AEventHandler());
		MinecraftForge.EVENT_BUS.register(new AEventHandler());
	}

	public static void serverRegistry(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronica.instance, new AGuiHandler());
		FMLCommonHandler.instance().bus().register(new AEventHandler());
		MinecraftForge.EVENT_BUS.register(new AEventHandler());
	}
}
