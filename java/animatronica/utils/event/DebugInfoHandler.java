package animatronica.utils.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import animatronica.api.energy.TileEntityEnergyGeneric;
import animatronica.client.fx.FXHelper;
import animatronica.common.item.ItemCoordinationMatrix;
import animatronica.network.proxy.ClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DebugInfoHandler {
	
	private static final String PREFIX = EnumChatFormatting.DARK_PURPLE + "[Animatronica] " + EnumChatFormatting.RESET;

	@SubscribeEvent
	public void onDrawDebugText(RenderGameOverlayEvent.Text event) {
		World world = Minecraft.getMinecraft().theWorld;
		if(Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			event.left.add(null);
			event.left.add(PREFIX + "SFxCount: " + FXHelper.sparkleFxCount + ", SFakeFxCount: " + FXHelper.fakeSparkleFxCount);
			event.left.add(PREFIX + "WFxCount: " + FXHelper.wispFxCount + ", WFxDepthIgnoringWispFxCount: " + FXHelper.depthIgnoringWispFxCount);
		}
	}

}
