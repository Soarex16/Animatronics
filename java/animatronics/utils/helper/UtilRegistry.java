package animatronics.utils.helper;

import net.minecraftforge.common.MinecraftForge;
import animatronics.Animatronics;
import animatronics.utils.handler.AEventHandler;
import animatronics.utils.handler.AGuiHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class UtilRegistry {

	public static void registerAll(){
		if(FMLCommonHandler.instance().getSide().isClient()){
			clientRegistry();
		}
		serverRegistry();
	}

	public static void clientRegistry(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronics.instance, new AGuiHandler());
		FMLCommonHandler.instance().bus().register(new AEventHandler());
		MinecraftForge.EVENT_BUS.register(new AEventHandler());
	}

	public static void serverRegistry(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronics.instance, new AGuiHandler());
		FMLCommonHandler.instance().bus().register(new AEventHandler());
		MinecraftForge.EVENT_BUS.register(new AEventHandler());
	}
}
