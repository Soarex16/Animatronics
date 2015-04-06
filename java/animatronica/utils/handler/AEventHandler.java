package animatronica.utils.handler;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import animatronica.Animatronica;
import animatronica.network.PacketOpenGui;
import animatronica.utils.config.AnimatronicaConfiguration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AEventHandler{

	/*
	@SideOnly(Side.CLIENT)
	@SubscribeEvent    
	public void onAddButton(InitGuiEvent event){
		if(event.gui instanceof GuiInventory){
			event.buttonList.add(new GuiButton(500, 274, 98, 20, 20, ""));
		}else if(event.gui instanceof GuiContainerCreative){
			event.buttonList.add(new GuiButton(500, 287, 140, 20, 20, ""));
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent    
	public void onClickButton(ActionPerformedEvent event){      
		if(event.gui instanceof GuiInventory || event.gui instanceof GuiContainerCreative && event.button.id == 500){
			Animatronica.packetSender.sendToServer(new PacketOpenGui(Animatronica.instance, 2));
		}
	}
*/	
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
