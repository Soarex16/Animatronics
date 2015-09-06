package animatronics.utils.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;

public class EventHookContainer {
	
	public static IIcon entropy;
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
		player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE+""+"Pasta take over the world!"));
	}
	
	@SubscribeEvent
	public void init(TextureStitchEvent event) {
		if (event.map.getTextureType() == 0) {
			entropy = event.map.registerIcon("animatronics:entropy");
		}
	}
}