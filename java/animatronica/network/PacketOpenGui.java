package animatronica.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/*public class PacketOpenGui implements IPacket{

	Object mod;
	int id;

	public PacketOpenGui(){}

	public PacketOpenGui(Object modGui, int guiId){
		mod = modGui;
		id = guiId;
	}

	public void readBytes(ByteBuf bytes){}

	public void writeBytes(ByteBuf bytes){}

	public void handleClientSide(NetHandlerPlayClient client){}

	public void handleServerSide(NetHandlerPlayServer server){
		EntityPlayerMP player = server.playerEntity;
		player.openGui(mod, id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
}*/

public class PacketOpenGui implements IMessage, IMessageHandler<PacketOpenGui, IMessage>{

	Object mod;
	int id;

	public PacketOpenGui(){}

	public PacketOpenGui(Object modGui, int guiId){
		mod = modGui;
		id = guiId;
	}

	public void fromBytes(ByteBuf buf){
		id = buf.readInt();
	}

	public void toBytes(ByteBuf buf){
		buf.writeInt(id);
	}

	public IMessage onMessage(PacketOpenGui message, MessageContext ctx){
		EntityPlayerMP player = ctx.getServerHandler().playerEntity;
		player.openGui(message.mod, message.id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		return null;
	}
}

