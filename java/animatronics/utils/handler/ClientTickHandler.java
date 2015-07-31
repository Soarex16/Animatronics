package animatronics.utils.handler;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientTickHandler {
	
	public static int ticksInGame = 0;
	public static float partialTicks = 0;
	
	@SubscribeEvent
	public void renderTickStart(RenderTickEvent event) {
		if(event.phase == Phase.START)
			partialTicks = event.renderTickTime;
	}

	@SubscribeEvent
	public void clientTickEnd(ClientTickEvent event) {
		if(event.phase == Phase.END) {
				//TODO Here render updates

			if(Minecraft.getMinecraft().theWorld == null) {
				//TODO here cash cleaner
			}

			GuiScreen gui = Minecraft.getMinecraft().currentScreen;
			if(gui == null || !gui.doesGuiPauseGame()) {
				ticksInGame++;
			}
		}
	}
}
