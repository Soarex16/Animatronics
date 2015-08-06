package animatronics.common.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import animatronics.Animatronics;
import animatronics.debug.ItemDebug;
import cpw.mods.fml.common.registry.GameRegistry;

public class AnimatronicsItems {
	
	public static ItemDebug itemDebug;
	public static ItemBindingStaff itemBindingStaff;
	
	public static ItemAnimatronicaRecord recAnimatronica;
	
	public static ArmorMaterial soulArmorMaterial = EnumHelper.addArmorMaterial("SoulInfused", 52, new int[]{3, 8, 6, 3}, 40);

	public static void init() {
		
		itemDebug = new ItemDebug("itemDebug", Animatronics.MOD_ID, 0);
		
		itemBindingStaff = new ItemBindingStaff("itemBindingStaff", Animatronics.MOD_ID, 0);
		
		//TODO: Ore distionary "record"
		recAnimatronica = new ItemAnimatronicaRecord("celticdream");
		GameRegistry.registerItem(recAnimatronica, "celticdream");
		recAnimatronica = new ItemAnimatronicaRecord("deadlytheme");
		GameRegistry.registerItem(recAnimatronica, "deadlytheme");
		recAnimatronica = new ItemAnimatronicaRecord("aeyolio");
		GameRegistry.registerItem(recAnimatronica, "aeyolio");
		recAnimatronica = new ItemAnimatronicaRecord("keepsake");
		GameRegistry.registerItem(recAnimatronica, "keepsake");
	}
}
