package animatronica.network.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import animatronica.Animatronica;
import animatronica.client.fx.FXSparkle;
import animatronica.client.fx.FXWisp;
import animatronica.client.render.LibRenderIDs;
import animatronica.debug.RenderBlockDebug;
import animatronica.debug.RenderItemDebug;
import animatronica.debug.RenderTileEntityDebug;
import animatronica.debug.TileEntityDebug;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.event.ClientTickHandler;
import animatronica.utils.event.DebugInfoHandler;
import animatronica.utils.event.EventHookContainer;
import animatronica.utils.handler.ParticleHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	public void registerAll(){
	    super.registerAll();
		render();
		
		MinecraftForge.EVENT_BUS.register(new EventHookContainer());
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new DebugInfoHandler());
		MinecraftForge.EVENT_BUS.register(new ParticleHandler());
	}
	
	public void render(){
		LibRenderIDs.idBlockDebug = RenderingRegistry.getNextAvailableRenderId();
		LibRenderIDs.idSolar = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new RenderBlockDebug());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDebug.class, new RenderTileEntityDebug());
		
		MinecraftForgeClient.registerItemRenderer(Animatronica.itemDebug, new RenderItemDebug());
	}
	

	@Override
	public long getWorldElapsedTicks() {
		return ClientTickHandler.ticksInGame;
	}

	private static boolean noclipEnabled = false;
	private static boolean corruptSparkle = false;

	@Override
	public void setSparkleFXNoClip(boolean noclip) {
		noclipEnabled = noclip;
	}

	@Override
	public void setSparkleFXCorrupt(boolean corrupt) {
		corruptSparkle = corrupt;
	}

	@Override
	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
		if(!doParticle(world) && !fake)
			return;

		FXSparkle sparkle = new FXSparkle(world, x, y, z, size, r, g, b, m);
		sparkle.fake = sparkle.noClip = fake;
		if(noclipEnabled)
			sparkle.noClip = true;
		if(corruptSparkle)
			sparkle.corrupt = true;
		Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
	}

	private static boolean distanceLimit = true;
	private static boolean depthTest = true;

	@Override
	public void setWispFXDistanceLimit(boolean limit) {
		distanceLimit = limit;
	}

	@Override
	public void setWispFXDepthTest(boolean test) {
		depthTest = test;
	}

	@Override
	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {
		if(!doParticle(world))
			return;

		FXWisp wisp = new FXWisp(world, x, y, z, size, r, g, b, distanceLimit, depthTest, maxAgeMul);
		wisp.motionX = motionx;
		wisp.motionY = motiony;
		wisp.motionZ = motionz;

		Minecraft.getMinecraft().effectRenderer.addEffect(wisp);
	}

	private boolean doParticle(World world) {
		if(!world.isRemote)
			return false;

		if(!AnimatronicaConfiguration.vanillaParticleLimitter)
			return true;

		float chance = 1F;
		if(Minecraft.getMinecraft().gameSettings.particleSetting == 1)
			chance = 0.6F;
		else if(Minecraft.getMinecraft().gameSettings.particleSetting == 2)
			chance = 0.2F;

		return chance == 1F || Math.random() < chance;
	}
}
