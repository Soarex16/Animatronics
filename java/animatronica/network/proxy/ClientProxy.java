package animatronica.network.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import animatronica.Animatronica;
import animatronica.client.fx.FXSparkle;
import animatronica.client.fx.FXWisp;
import animatronica.client.render.RenderBlocksAnimatronica;
import animatronica.debug.RenderBlockDebug;
import animatronica.debug.RenderItemDebug;
import animatronica.debug.TileEntityDebug;
import animatronica.utils.event.EventHookContainer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int renderID = RenderingRegistry.getNextAvailableRenderId();
	
	public void registerAll(){
	    super.registerAll();
		render();
		
		MinecraftForge.EVENT_BUS.register(new EventHookContainer());
	}
	
	public void render(){
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDebug.class, new RenderBlockDebug());
		RenderingRegistry.registerBlockHandler(new RenderBlocksAnimatronica());
		
		MinecraftForgeClient.registerItemRenderer(Animatronica.itemDebug, new RenderItemDebug());
	}
	
	@Override
	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
		if(!doParticle() && !fake)
			return;

		FXSparkle sparkle = new FXSparkle(world, x, y, z, size, r, g, b, m);
		sparkle.fake = sparkle.noClip = fake;
		Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
	}

	private static boolean distanceLimit = true;
	private static boolean depthTest = true;

/*	
	@Override
	public void setWispFXDistanceLimit(boolean limit) {
		distanceLimit = limit;
	}

	@Override
	public void setWispFXDepthTest(boolean test) {
		depthTest = test;
	}
*/
	@Override
	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {
		if(!doParticle())
			return;

		FXWisp wisp = new FXWisp(world, x, y, z, size, r, g, b, distanceLimit, depthTest, maxAgeMul);
		wisp.motionX = motionx;
		wisp.motionY = motiony;
		wisp.motionZ = motionz;

		Minecraft.getMinecraft().effectRenderer.addEffect(wisp);
	}

	private boolean doParticle() {

		float chance = 1F;
		if(Minecraft.getMinecraft().gameSettings.particleSetting == 1)
			chance = 0.6F;
		else if(Minecraft.getMinecraft().gameSettings.particleSetting == 2)
			chance = 0.2F;

		return Math.random() < chance;
	}

}
