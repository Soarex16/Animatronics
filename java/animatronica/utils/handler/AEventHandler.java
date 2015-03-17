package animatronica.utils.handler;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import animatronica.Animatronica;
import animatronica.utils.config.AnimatronicaConfiguration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AEventHandler{
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Animatronica.MOD_ID)){
			AnimatronicaConfiguration.syncConfig();
		}
	}
	
	/*@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent event) {
		if (!event.showAdvancedItemTooltips) {
					event.toolTip.add(EnumChatFormatting.GRAY + "T-T");
		}
	}*/
}
