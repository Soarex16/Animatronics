package animatronics.common.item;

import java.util.ArrayList;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import animatronics.Animatronics;

public class ItemAnimatronicsRecord extends ItemRecord {
	public static ArrayList<ItemAnimatronicsRecord> list=new ArrayList<ItemAnimatronicsRecord>();
	private String recordname;
	
	protected ItemAnimatronicsRecord(String name) {
		super(name);
		list.add(this);
		setUnlocalizedName("record");
		setTextureName("record_" + name);
		setCreativeTab(Animatronics.creativeTabAnimatronics);
		recordname = name;
	}
	
	@Override
	public ResourceLocation getRecordResource(String name) {
		ResourceLocation loc = super.getRecordResource(Animatronics.MOD_ID + ":" + name);
		return loc;
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
		itemIcon=reg.registerIcon(Animatronics.MOD_ID + ":record_" + recordname);
	}
	
	@Override
	public String getUnlocalizedName() {
		return "record."+recordname;
	}

	@Override
	public String getUnlocalizedName(ItemStack arg0) {
		return getUnlocalizedName();
	}
}