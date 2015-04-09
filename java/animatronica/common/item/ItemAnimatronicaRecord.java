package animatronica.common.item;

import java.util.ArrayList;

import animatronica.Animatronica;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemAnimatronicaRecord extends ItemRecord {
	public static ArrayList<ItemAnimatronicaRecord> list=new ArrayList<ItemAnimatronicaRecord>();
	private String recordname;
	
	protected ItemAnimatronicaRecord(String name) {
		super(name);
		list.add(this);
		setUnlocalizedName("record");
		setTextureName("record_"+name);
		setCreativeTab(Animatronica.creativeTabAnimatronica);
		recordname=name;
	}
	
	@Override
	public ResourceLocation getRecordResource(String name) {
		ResourceLocation loc = super.getRecordResource(Animatronica.MOD_ID + ":" + name);
		return loc;
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
		itemIcon=reg.registerIcon(Animatronica.MOD_ID + ":record_" + recordname);
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