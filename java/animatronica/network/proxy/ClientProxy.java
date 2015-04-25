package animatronica.network.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import animatronica.client.fx.FXSparkle;
import animatronica.client.fx.FXWisp;
import animatronica.client.fx.ParticleEngine;
import animatronica.client.render.LibRenderIDs;
import animatronica.common.item.AnimatronicaItems;
import animatronica.debug.RenderBlockDebug;
import animatronica.debug.RenderItemDebug;
import animatronica.debug.RenderTileEntityDebug;
import animatronica.debug.TileEntityDebug;
import animatronica.utils.config.AnimatronicaConfiguration;
import animatronica.utils.event.ClientTickHandler;
import animatronica.utils.event.DebugInfoHandler;
import animatronica.utils.event.EventHookContainer;
import animatronica.utils.handler.ParticleHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {
	
	public void registerAll(){
	    super.registerAll();
		render();
		
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new EventHookContainer());
		MinecraftForge.EVENT_BUS.register(new DebugInfoHandler());
		//MinecraftForge.EVENT_BUS.register(new ParticleHandler());
		MinecraftForge.EVENT_BUS.register(ParticleEngine.instance);
	    FMLCommonHandler.instance().bus().register(ParticleEngine.instance);
	}
	
	public void render(){
		LibRenderIDs.idBlockDebug = RenderingRegistry.getNextAvailableRenderId();
		LibRenderIDs.idSolar = RenderingRegistry.getNextAvailableRenderId();
		
		RenderingRegistry.registerBlockHandler(new RenderBlockDebug());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDebug.class, new RenderTileEntityDebug());
		
		MinecraftForgeClient.registerItemRenderer(AnimatronicaItems.itemDebug, new RenderItemDebug());
	}
	
	public World getClientWorld() {
	    return FMLClientHandler.instance().getClient().theWorld;
	}
	/*
	public void sparkle(float x, float y, float z, float size, int color, float gravity)
	  {
	    if ((getClientWorld() != null) && (getClientWorld().rand.nextInt(6) < particleCount(2)))
	    {
	      FXSparkle fx = new FXSparkle(getClientWorld(), x, y, z, size, color, 6);
	      
	      fx.noClip = true;
	      fx.setGravity(gravity);
	      ParticleEngine.instance.addEffect(getClientWorld(), fx);
	    }
	  }
	  
	  public void sparkle(float x, float y, float z, int color)
	  {
	    if ((getClientWorld() != null) && (getClientWorld().field_73012_v.nextInt(6) < particleCount(2)))
	    {
	      FXSparkle fx = new FXSparkle(getClientWorld(), x, y, z, 1.5F, color, 6);
	      
	      fx.noClip = true;
	      ParticleEngine.instance.addEffect(getClientWorld(), fx);
	    }
	  }
	  
	  public void spark(float x, float y, float z, float size, float r, float g, float b, float a)
	  {
	    if (getClientWorld() != null)
	    {
	      FXSpark fx = new FXSpark(getClientWorld(), x, y, z, size);
	      fx.func_70538_b(r, g, b);
	      fx.func_82338_g(a);
	      ParticleEngine.instance.addEffect(getClientWorld(), fx);
	    }
	  }*/
	
	  public void wispFX(World worldObj, double posX, double posY, double posZ, float f, float g, float h, float i)
	  {
	    FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, f, g, h, i);
	    ef.setGravity(0.02F);
	    
	    ParticleEngine.instance.addEffect(worldObj, ef);
	  }
	  
	  public void wispFX2(World worldObj, double posX, double posY, double posZ, float size, int type, boolean shrink, boolean clip, float gravity)
	  {
	    FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, size, type);
	    ef.setGravity(gravity);
	    ef.shrink = shrink;
	    ef.noClip = clip;
	    
	    ParticleEngine.instance.addEffect(worldObj, ef);
	  }
	  
	  public void wispFX3(World worldObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity)
	  {
	    FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, posX2, posY2, posZ2, size, type);
	    
	    ef.setGravity(gravity);
	    ef.shrink = shrink;
	    

	    ParticleEngine.instance.addEffect(worldObj, ef);
	  }
	  
	  public void wispFX4(World worldObj, double posX, double posY, double posZ, Entity target, int type, boolean shrink, float gravity)
	  {
	    FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, target, type);
	    ef.setGravity(gravity);
	    ef.shrink = shrink;
	    
	    ParticleEngine.instance.addEffect(worldObj, ef);
	  }
	  
	/*public void burst(World worldObj, double sx, double sy, double sz, float size)
	  {
	    FXBurst ef = new FXBurst(worldObj, sx, sy, sz, size);
	    FMLClientHandler.instance().getClient().field_71452_i.func_78873_a(ef);
	  }*/
	  
	  public int particleCount(int base)
	  {
	    if (FMLClientHandler.instance().getClient().gameSettings.particleSetting == 2) {
	      return 0;
	    }
	    return FMLClientHandler.instance().getClient().gameSettings.particleSetting == 1 ? base * 1 : base * 2;
	  }
/*
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
	}*/
}
