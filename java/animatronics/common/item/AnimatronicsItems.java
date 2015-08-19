package animatronics.common.item;

import java.lang.reflect.Field;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import animatronics.Animatronics;
import animatronics.debug.ItemDebug;
import animatronics.utils.item.ItemMetadataBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class AnimatronicsItems {
	
	public static ItemDebug itemDebug;
	public static ItemBindingStaff itemBindingStaff;
	
	public static ItemAnimatronicsRecord recAnimatronica;
	public static ItemMetadataBase dusts, ingots;
//	public static ItemFireStormInABottle itemFireStormInABottle;
	public static ItemMagicalTinkler tinkler;
	
	public static void init() {
		
		itemDebug = new ItemDebug("itemDebug", Animatronics.MOD_ID, 0);
		
		itemBindingStaff = new ItemBindingStaff("itemBindingStaff", Animatronics.MOD_ID, 0);
	//	itemFireStormInABottle = new ItemFireStormInABottle("itemFireStormInABottle", Animatronics.MOD_ID, 0);
		tinkler = new ItemMagicalTinkler();
		
		//TODO: Ore dictionary "record"
		recAnimatronica = new ItemAnimatronicsRecord("celticdream");
		GameRegistry.registerItem(recAnimatronica, "celticdream");
		recAnimatronica = new ItemAnimatronicsRecord("deadlytheme");
		GameRegistry.registerItem(recAnimatronica, "deadlytheme");
		recAnimatronica = new ItemAnimatronicsRecord("aeyolio");
		GameRegistry.registerItem(recAnimatronica, "aeyolio");
		recAnimatronica = new ItemAnimatronicsRecord("keepsake");
		GameRegistry.registerItem(recAnimatronica, "keepsake");
		dusts = (ItemMetadataBase) new ItemMetadataBase("dust", true, Animatronics.MOD_ID, new String[]{"dusts/acid_dust", "dusts/copper_dust_v1", "dusts/lead_dust_v1", "dusts/nickel_dust_v1", "dusts/platinum_dust_v1", "dusts/silver_dust_v1", "dusts/tin_dust_1", "dusts/warden_dust_v1", "dusts/zinc_dust_v1"}).setCreativeTab(Animatronics.creativeTabAnimatronics);
		ingots = (ItemMetadataBase) new ItemMetadataBase("ingot", true, Animatronics.MOD_ID, new String[]{"ingots/acid_ingot_v1", "ingots/copper_ingot", "ingots/lead_ingot_v1", "ingots/nickel_ingot_v1", "ingots/platinum_ingot_v1", "ingots/silver_ingot_v1", "ingots/tin_ingot_v1", "ingots/warden_ingot_v1", "ingots/wepon_INGOT", "ingots/zinc_ingot_v1"}).setCreativeTab(Animatronics.creativeTabAnimatronics);
	
	}
}
