package animatronica.utils.handler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import animatronica.Animatronica;
import animatronica.network.PacketPlayerInfo;

public class PlayerInfo implements IExtendedEntityProperties{

	private static final Map<String, NBTTagCompound> playersInfo = new HashMap<String, NBTTagCompound>();

	public static final String DATA_TAG = Animatronica.MOD_ID + "PlayerInfo";

	private EntityPlayer player;

	private int strength;
	private int dexterity;
	
	public PlayerInfo(EntityPlayer entityPlayer){
		player = entityPlayer;
		strength = 10;
		dexterity = 10;
	}

	public static final void registerInfo(EntityPlayer player){
		player.registerExtendedProperties(DATA_TAG, new PlayerInfo(player));
	}

	public static final PlayerInfo forPlayer(EntityPlayer player){
		return (PlayerInfo)player.getExtendedProperties(DATA_TAG); 
	}

	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("strength", strength);
		nbt.setInteger("dexterity", dexterity);
		compound.setTag(DATA_TAG, nbt);
	}

	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound nbt = compound.getCompoundTag(DATA_TAG);
		strength = nbt.getInteger("strength");
		dexterity = nbt.getInteger("dexterity");
	}

	public int getStrength(){
		return strength;
	}
	
	public void setStrength(int value){
		strength = value > 100 ? 100 : value < 0 ? 0 : value;
	}
	
	public void increaseStrength(int value){
		setStrength(getStrength() + value > 100 ? 100 : getStrength() + value);
	} 
	
	public void decreaseStrength(int value){
		setStrength(getStrength() - value < 0 ? 0 : getStrength() - value);
	}
	
	public int getDexterity(){
		return dexterity;
	}
	
	public void setDexterity(int value){
		dexterity = value > 100 ? 100 : value < 0 ? 0 : value;
	}
	
	public void increaseDexterity(int value){
		setDexterity(getDexterity() + value > 100 ? 100 : getDexterity() + value);
	} 
	
	public void decreaseDexterity(int value){
		setDexterity(getDexterity() - value < 0 ? 0 : getDexterity() - value);
	}
	
	public void init(Entity entity, World world){}

	public static final void savePlayerData(EntityPlayer player){
		NBTTagCompound savedData = new NBTTagCompound();
		PlayerInfo.forPlayer(player).saveNBTData(savedData);
		PlayerInfo.storePlayerData(player.getUniqueID().toString(), savedData);
	}

	public static final void loadPlayerData(EntityPlayer player){
		PlayerInfo playerData = PlayerInfo.forPlayer(player);
		NBTTagCompound savedData = PlayerInfo.getPlayerData(player.getUniqueID().toString());
		if(savedData != null){
			playerData.loadNBTData(savedData); 
		}
		Animatronica.packetSender.sendTo(new PacketPlayerInfo(player), (EntityPlayerMP)player);
	}

	public static void storePlayerData(String id, NBTTagCompound compound){
		playersInfo.put(id, compound);
	}

	public static NBTTagCompound getPlayerData(String id){
		return playersInfo.remove(id);
	}
}
