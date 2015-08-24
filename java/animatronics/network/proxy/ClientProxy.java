package animatronics.network.proxy;

import animatronics.client.fx.FXSparkle;
import animatronics.client.fx.FXWisp;
import animatronics.client.fx.ParticleEngine;
import animatronics.client.render.BlockOutlineRender;
import animatronics.client.render.LibRenderIDs;
import animatronics.client.render.block.RenderBlockGatewayMirror;
import animatronics.client.render.block.RenderBlockMoonPrism;
import animatronics.client.render.tile.RenderTileEntityGatewayMirror;
import animatronics.client.render.tile.RenderTileEntityMoonPrism;
import animatronics.common.item.AnimatronicsItems;
import animatronics.common.tile.TileEntityGatewayMirror;
import animatronics.common.tile.TileEntityMoonPrism;
import animatronics.debug.RenderBlockDebug;
import animatronics.debug.RenderItemDebug;
import animatronics.debug.RenderTileEntityDebug;
import animatronics.debug.TileEntityDebug;
import animatronics.utils.event.EventHookContainer;
import animatronics.utils.handler.ClientTickHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	
	public void registerAll(){
	    super.registerAll();
		render();
		
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		//MinecraftForge.EVENT_BUS.register(new DebugInfoHandler());
		MinecraftForge.EVENT_BUS.register(new EventHookContainer());
		//FMLCommonHandler.instance().bus().register(new EventHookContainer());
		MinecraftForge.EVENT_BUS.register(new BlockOutlineRender());
		MinecraftForge.EVENT_BUS.register((Object)ParticleEngine.instance);
        FMLCommonHandler.instance().bus().register((Object)ParticleEngine.instance);	
	}
	
	public void render(){
		LibRenderIDs.idBlockDebug = RenderingRegistry.getNextAvailableRenderId();
		LibRenderIDs.idFabricator = RenderingRegistry.getNextAvailableRenderId();
		LibRenderIDs.idMoonPrism = RenderingRegistry.getNextAvailableRenderId();
		LibRenderIDs.idGatewayMirror = RenderingRegistry.getNextAvailableRenderId();
		
		//DEBUG
		RenderingRegistry.registerBlockHandler(new RenderBlockDebug());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDebug.class, new RenderTileEntityDebug());
		
		MinecraftForgeClient.registerItemRenderer(AnimatronicsItems.itemDebug, new RenderItemDebug());
		
		//TILE ENTITY
		RenderingRegistry.registerBlockHandler(new RenderBlockMoonPrism());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMoonPrism.class, new RenderTileEntityMoonPrism());
		RenderingRegistry.registerBlockHandler(new RenderBlockGatewayMirror());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGatewayMirror.class, new RenderTileEntityGatewayMirror());
		
		//ITEMS
	}
	
	public World getClientWorld() {
	    return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public long getWorldElapsedTicks() {
		return ClientTickHandler.ticksInGame;
	}
	
	@Override
	public void sparkleFX(double x, double y, double z, float red, float green, float blue, float size, float gravity, int m, boolean noClip) {
		if (this.getClientWorld() != null && this.getClientWorld().rand.nextInt(6) < this.particleCount(2)) {
			FXSparkle fx = new FXSparkle(this.getClientWorld(), x, y, z, size, red, green, blue, 6);
			fx.noClip = noClip;
			fx.setGravity(gravity);
			ParticleEngine.instance.addEffect(this.getClientWorld(), fx);
		}
	}
	
	@Override
    public void sparkleFX(float x, float y, float z, float size, int color, float gravity) {
        if (this.getClientWorld() != null && this.getClientWorld().rand.nextInt(6) < this.particleCount(2)) {
            FXSparkle fx = new FXSparkle(this.getClientWorld(), x, y, z, size, color, 6);
            fx.noClip = true;
            fx.setGravity(gravity);
            ParticleEngine.instance.addEffect(this.getClientWorld(), fx);
        }
    }
    
    @Override
    public void sparkleFX(float x, float y, float z, int color) {
        if (this.getClientWorld() != null && this.getClientWorld().rand.nextInt(6) < this.particleCount(2)) {
            FXSparkle fx = new FXSparkle(this.getClientWorld(), x, y, z, 1.5f, color, 6);
            fx.noClip = true;
            ParticleEngine.instance.addEffect(this.getClientWorld(), fx);
        }
    }
    
    @Override
    public void wispFX(World worldObj, double posX, double posY, double posZ, float f, float g, float h, float i) {
        FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, f, g, h, i);
        ef.setGravity(0.02f);
        ParticleEngine.instance.addEffect(worldObj, ef);
    }
    
    @Override
    public void wispFX2(World worldObj, double posX, double posY, double posZ, float size, int type, boolean shrink, boolean clip, float gravity) {
        FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, size, type);
        ef.setGravity(gravity);
        ef.shrink = shrink;
        ef.noClip = clip;
        ParticleEngine.instance.addEffect(worldObj, ef);
    }
    
    @Override
    public void wispFX3(World worldObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity) {
        FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, posX2, posY2, posZ2, size, type);
        ef.setGravity(gravity);
        ef.shrink = shrink;
        ParticleEngine.instance.addEffect(worldObj, ef);
    }
    
    @Override
    public void wispFX4(World worldObj, double posX, double posY, double posZ, Entity target, int type, boolean shrink, float gravity) {
        FXWisp ef = new FXWisp(worldObj, posX, posY, posZ, target, type);
        ef.setGravity(gravity);
        ef.shrink = shrink;
        ParticleEngine.instance.addEffect(worldObj, ef);
    }
    
    @Override
    public int particleCount(final int base) {
        if (FMLClientHandler.instance().getClient().gameSettings.particleSetting == 2) {
            return 0;
        }
        return (FMLClientHandler.instance().getClient().gameSettings.particleSetting == 1) ? (base * 1) : (base * 2);
    }
}
