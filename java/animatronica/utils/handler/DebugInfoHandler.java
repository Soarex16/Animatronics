package animatronica.utils.handler;

import animatronica.client.fx.FXHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class DebugInfoHandler {
	
	private static final String PREFIX = EnumChatFormatting.DARK_PURPLE + "[Animatronica] " + EnumChatFormatting.RESET;

	@SubscribeEvent
	public void onDrawDebugText(RenderGameOverlayEvent.Text event) {
		World world = Minecraft.getMinecraft().theWorld;
		if(Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			event.left.add(null);
			event.left.add(PREFIX + "SFxCount: " + FXHelper.sparkleFxCount);
			event.left.add(PREFIX + "WFxCount: " + FXHelper.wispFxCount + ", WFxDepthIgnoringWispFxCount: " + FXHelper.depthIgnoringWispFxCount);
		}
	}

}
