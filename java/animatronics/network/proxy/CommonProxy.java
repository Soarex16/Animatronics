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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
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
	
	public void setExtraReach(EntityLivingBase entity, float reach) {
		if(entity instanceof EntityPlayerMP)
			((EntityPlayerMP) entity).theItemInWorldManager.setBlockReachDistance(Math.max(5, ((EntityPlayerMP) entity).theItemInWorldManager.getBlockReachDistance() + reach));
	}

	public long getWorldElapsedTicks() {
		return MinecraftServer.getServer().worldServers[0].getTotalWorldTime();
	}
	
	public void setSparkleFXNoClip(boolean noclip) {
		// NO-OP
	}

	public void setSparkleFXCorrupt(boolean corrupt) {
		// NO-OP
	}

	public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m) {
		sparkleFX(world, x, y, z, r, g, b, size, m);
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
	}
}

