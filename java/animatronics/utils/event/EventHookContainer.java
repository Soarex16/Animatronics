package animatronics.utils.event;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class EventHookContainer {
	/*
	@SubscribeEvent
	public void ItemTooltip(ItemTooltipEvent event){
			
		FMLCommonHandler.instance().bus().register(event);
		
		ItemStack itemStack = event.itemStack;
		EntityPlayer entityPlayer = event.entityPlayer;
		List<String> toolTip = event.toolTip;
		boolean showAdvancedItemTooltips = event.showAdvancedItemTooltips;
	}*/
	
	@SubscribeEvent
	public void playerLoggedIn(PlayerLoggedInEvent event){
			EntityPlayer player = event.player;
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE+""+EnumChatFormatting.OBFUSCATED+"Pasta take over the world!"));
	}
}