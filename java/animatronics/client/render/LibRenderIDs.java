package animatronics.client.render;

import java.lang.reflect.Field;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class LibRenderIDs {
	
	public static int idBlockDebug, idMoonPrism, idFabricator, idGatewayMirror, idNothing;
	
	public static synchronized void init() throws IllegalArgumentException, IllegalAccessException{
		for(Field f : LibRenderIDs.class.getFields()){
			f.setInt(null, RenderingRegistry.getNextAvailableRenderId());
		}
	}
}
