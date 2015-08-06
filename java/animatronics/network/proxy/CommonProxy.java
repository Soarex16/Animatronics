package animatronics.network.proxy;

import animatronics.Animatronics;
import animatronics.common.tile.TileEntityArcaneFlame;
import animatronics.common.tile.TileEntityCreativeEntropyStorage;
import animatronics.debug.TileEntityDebug;
import animatronics.network.PacketOpenGui;
import animatronics.network.PacketPlayerInfo;
import animatronics.utils.handler.AGuiHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {

	}
	
	public void registerAll(){
		registerTileEntity();
		registerMisc();
		registerPackets();
	}
	
	public void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityDebug.class, "Debug");
		GameRegistry.registerTileEntity(TileEntityCreativeEntropyStorage.class, "CreativeEntropyStorage");
		GameRegistry.registerTileEntity(TileEntityArcaneFlame.class, "ArcaneFlame");
	}
	
	public void registerMisc(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronics.instance, new AGuiHandler());
	}
	
	public void registerPackets(){
		Animatronics.packetSender.registerMessage(PacketOpenGui.class, PacketOpenGui.class, 1, Side.SERVER);
		Animatronics.packetSender.registerMessage(PacketPlayerInfo.class, PacketPlayerInfo.class, 2, Side.CLIENT);
	}
	
	public long getWorldElapsedTicks() {
		return MinecraftServer.getServer().worldServers[0].getTotalWorldTime();
	}
	
	public void sparkleFX(double x, double y, double z, float red, float green, float blue, float size, float gravity, int m, boolean noClip) {	
	}
	
	public void sparkleFX(float x, float y, float z, float size, int color, float gravity) {
    }
    
    public void sparkleFX(float x, float y, float z, int color) {
    }
    
    public void wispFX(World worldObj, double posX, double posY, double posZ, float f, float g, float h, float i) {
    }
    
    public void wispFX2(World worldObj, double posX, double posY, double posZ, float size, int type, boolean shrink, boolean clip, float gravity) {
    }
    
    public void wispFX3(World worldObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity) {
    }
    
    public void wispFX4(World worldObj, double posX, double posY, double posZ, Entity target, int type, boolean shrink, float gravity) {
    }
    
    public int particleCount(final int base) {
        return 0;
    }
    
}

