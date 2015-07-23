package animatronica.common.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import animatronica.Animatronica;
import animatronica.debug.ItemDebug;
import cpw.mods.fml.common.registry.GameRegistry;

public class AnimatronicaItems {
	
	public static ItemDebug itemDebug;
	
	public static ItemBindingStaff itemCoordinationMatrix;
	
	public static ItemAnimatronicaRecord recAnimatronica;
	
	public static ArmorMaterial soulArmorMaterial = EnumHelper.addArmorMaterial("SoulInfused", 52, new int[]{3, 8, 6, 3}, 40);

	public static void init() {
		
		itemDebug = new ItemDebug("itemDebug", Animatronica.MOD_ID, 0);
		
		itemCoordinationMatrix = new ItemBindingStaff("itemCoordinationMatrix", Animatronica.MOD_ID, 0);
		
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
