package animatronica.utils.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import animatronica.Animatronica;
import animatronica.utils.config.AnimatronicaConfiguration;

public class AEventHandler{
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Animatronica.MOD_ID)){
			AnimatronicaConfiguration.syncConfig();
		}
	}
}
