package animatronica.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import animatronica.utils.handler.PlayerInfo;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPlayerInfo implements IMessage, IMessageHandler<PacketPlayerInfo, IMessage>{

	private NBTTagCompound data;

	public PacketPlayerInfo(){}

	public PacketPlayerInfo(EntityPlayer player){
		data = new NBTTagCompound();
		PlayerInfo.forPlayer(player).saveNBTData(data);
	}

	public void toBytes(ByteBuf buffer){
		ByteBufUtils.writeTag(buffer, data);
	}

	public void fromBytes(ByteBuf buffer){
		data = ByteBufUtils.readTag(buffer);
	}

	public IMessage onMessage(PacketPlayerInfo message, MessageContext ctx){
		PlayerInfo.forPlayer(Minecraft.getMinecraft().thePlayer).loadNBTData(message.data);
		return null;
	}
}
