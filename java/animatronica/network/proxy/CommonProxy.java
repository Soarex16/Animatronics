package animatronica.network.proxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import animatronica.Animatronica;
import animatronica.debug.TileEntityDebug;
import animatronica.network.PacketOpenGui;
import animatronica.network.PacketPlayerInfo;
import animatronica.utils.handler.AGuiHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

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
	}
	
	public void registerMisc(){
		NetworkRegistry.INSTANCE.registerGuiHandler(Animatronica.instance, new AGuiHandler());
	}
	
	public void registerPackets(){
		Animatronica.packetSender.registerMessage(PacketOpenGui.class, PacketOpenGui.class, 1, Side.SERVER);
		Animatronica.packetSender.registerMessage(PacketPlayerInfo.class, PacketPlayerInfo.class, 2, Side.CLIENT);
	}
	
	public void setExtraReach(EntityLivingBase entity, float reach) {
		if(entity instanceof EntityPlayerMP)
			((EntityPlayerMP) entity).theItemInWorldManager.setBlockReachDistance(Math.max(5, ((EntityPlayerMP) entity).theItemInWorldManager.getBlockReachDistance() + reach));
	}

	public long getWorldElapsedTicks() {
		return MinecraftServer.getServer().worldServers[0].getTotalWorldTime();
	}
	
	
	public int particleCount(int base){
	    return 0;
	}
	
	public void sparkle(float x, float y, float z, float size, int color, float gravity) {}
	  
	public void sparkle(float x, float y, float z, int color) {}
	
	public void wispFX(World worldObj, double posX, double posY, double posZ, float f, float g, float h, float i) {}
	
	public void wispFX2(World worldObj, double posX, double posY, double posZ, float size, int type, boolean shrink, boolean clip, float gravity) {}
	
	public void burst(World worldObj, double sx, double sy, double sz, float size) {}
	  
	public void wispFX3(World worldObj, double posX, double posY, double posZ, double posX2, double posY2, double posZ2, float size, int type, boolean shrink, float gravity) {}
	  
	public void smokeSpiral(World m, double x, double y, double z, float rad, int start, int miny, int color) {}

	public void wispFX4(World worldObj, double posX, double posY, double posZ, Entity target, int type, boolean shrink, float gravity) {}
	
	
	/*
	public void setSparkleFXNoClip(boolean noclip) {
		// NO-OP
	}

	public void setSparkleFXCorrupt(boolean corrupt) {
		// NO-OP
	}

	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m) {
		sparkleFX(world, x, y, z, r, g, b, size, m, false);
	}

	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
		// NO-OP
	}

	public void setWispFXDistanceLimit(boolean limit) {
		// NO-OP
	}

	public void setWispFXDepthTest(boolean depth) {
		// NO-OP
	}

	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size) {
		wispFX(world, x, y, z, r, g, b, size, 0F);
	}

	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity) {
		wispFX(world, x, y, z, r, g, b, size, gravity, 1F);
	}

	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity, float maxAgeMul) {
		wispFX(world, x, y, z, r, g, b, size, 0, -gravity, 0, maxAgeMul);
	}

	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz) {
		wispFX(world, x, y, z, r, g, b, size, motionx, motiony, motionz, 1F);
	}

	public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {
		// NO-OP
	}*/
}

