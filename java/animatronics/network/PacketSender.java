package animatronics.network;

import java.util.List;

import animatronics.Animatronics;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class PacketSender {
	
	public static void sendPacketToAllAround(World world,Packet packet, int x, int y, int z, int dimId, double distance)
	{
		List <EntityPlayer> playerLst = world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x-0.5D, y-0.5D, z-0.5D, x+0.5D, y+0.5D, z+0.5D).expand(distance, distance, distance));
		if(!playerLst.isEmpty())
		{
			for(int i = 0; i < playerLst.size(); ++i)
			{
				EntityPlayer player = playerLst.get(i);
				if(player instanceof EntityPlayerMP)
				{
					if(packet instanceof S35PacketUpdateTileEntity)
					{
						NBTTagCompound tileTag = new NBTTagCompound();
						world.getTileEntity(x, y, z).writeToNBT(tileTag);
						Animatronics.packetSender.sendTo(new IMessageDataPacket(tileTag,-10), (EntityPlayerMP) player);
					}else
					{
						if(player.dimension == dimId)
							((EntityPlayerMP)player).getServerForPlayer().func_73046_m().getConfigurationManager().sendPacketToAllPlayers(packet);
					}
				}else
				{
					Animatronics.logger.debug("Trying to send packet "+packet+" to all around on Client side, probably a bug, ending the packet send try");
				}
			}
		}
	}
	
	public static void sendPacketToAll(World w,Packet pkt)
	{
		List<EntityPlayer> playerLst = w.playerEntities;
		if(!playerLst.isEmpty())
		{
			for(int i = 0; i < playerLst.size(); ++i)
			{
				EntityPlayer player = playerLst.get(i);
				if(player instanceof EntityPlayerMP)
				{
						((EntityPlayerMP)player).playerNetServerHandler.sendPacket(pkt);
				}else
				{
					Animatronics.logger.debug("Trying to send packet "+pkt+" to all on Client side, probably a bug, ending the packet send try");
				}
			}
		}
	}

	
	@SuppressWarnings("unchecked")
	public static void sendPacketToAllInDim(World w,Packet pkt, int dimId)
	{
		List<EntityPlayer> playerLst = w.playerEntities;
		if(!playerLst.isEmpty())
		{
			for(int i = 0; i < playerLst.size(); ++i)
			{
				EntityPlayer player = playerLst.get(i);
				if(player instanceof EntityPlayerMP)
				{
					if(player.dimension == dimId)
						((EntityPlayerMP)player).playerNetServerHandler.sendPacket(pkt);
				}else
				{
					Animatronics.logger.debug("Trying to send packet "+pkt+" to all in dimension "+dimId+" on Client side, probably a bug, ending the packet send try");
				}
			}
		}
	}
	
	public static void sendPacketToPlayer(World w,Packet pkt,EntityPlayer player)
	{
		if(player instanceof EntityPlayerMP)
		{
			((EntityPlayerMP)player).playerNetServerHandler.sendPacket(pkt);
		}else
		{
			Animatronics.logger.debug("Trying to send packet "+pkt+" to player "+player+"||"+player.getDisplayName()+" on Client side, probably a bug, ending the packet send try");
		}
	}
}
