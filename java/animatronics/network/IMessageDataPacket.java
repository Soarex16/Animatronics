package animatronics.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public class IMessageDataPacket  implements IMessage {
	
	public NBTTagCompound dataTag;
	
	public IMessageDataPacket()
	{
		
	}
	
	public IMessageDataPacket(NBTTagCompound data, int id)
	{
		dataTag = data;
		dataTag.setInteger("packetID", id);
	}
	
	public IMessageDataPacket(NBTTagCompound data)
	{
		dataTag = data;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		dataTag = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, dataTag);
		
	}

}