package animatronics.utils.helper;

public class ASMNames{

	public static boolean isInitialized = false;

	public static String F_dataWatcher = ASMHelper.getRemappedMF("dataWatcher",         "field_70180_af");
	public static String F_horseChest = ASMHelper.getRemappedMF("horseChest",          "field_110296_bG");
	public static String F_field110280bR = ASMHelper.getRemappedMF("field_110280_bR",     "field_110280_bR");
	public static String F_field110286bQ = ASMHelper.getRemappedMF("field_110286_bQ",     "field_110286_bQ");
	public static String F_ironShovel = ASMHelper.getRemappedMF("iron_shovel",         "field_151037_a");
	public static String F_iron_horse_armor = ASMHelper.getRemappedMF("iron_horse_armor",    "field_151138_bX");
	public static String F_diamondHorseArmor = ASMHelper.getRemappedMF("diamond_horse_armor", "field_151125_bZ");
	public static String F_armorValues = ASMHelper.getRemappedMF("armorValues",         "field_110272_by");
	public static String M_updateObject = ASMHelper.getRemappedMF("updateObject",                "func_75692_b");
	public static String M_getStackInSlot = ASMHelper.getRemappedMF("getStackInSlot",              "func_70301_a");
	public static String M_addObject = ASMHelper.getRemappedMF("addObject",                   "func_75682_a");
	public static String M_getItem = ASMHelper.getRemappedMF("getItem",                     "func_77973_b");
	public static String M_getWatchableObjectIS = ASMHelper.getRemappedMF("getWatchableObjectItemStack", "func_82710_f");
	public static String M_isItemEqual = ASMHelper.getRemappedMF("isItemEqual",                 "func_77969_a");
	public static String M_playSound = ASMHelper.getRemappedMF("playSound",                   "func_85030_a");
	public static String M_getUnlocalizedName = ASMHelper.getRemappedMF("getUnlocalizedName",          "func_77977_a");
	public static String M_interact = ASMHelper.getRemappedMF("interact",                    "func_70085_c");
	public static String M_func146085a = ASMHelper.getRemappedMF("func_146085_a",               "func_146085_a");
	public static String M_entityInit = ASMHelper.getRemappedMF("entityInit",                  "func_70088_a");
	public static String M_func110232cE = ASMHelper.getRemappedMF("func_110232_cE",              "func_110232_cE");
	public static String M_setHorseTexturePaths = ASMHelper.getRemappedMF("setHorseTexturePaths",        "func_110247_cG");
	public static String M_isHorseSaddled = ASMHelper.getRemappedMF("isHorseSaddled",              "func_110257_ck");
	public static String M_onInventoryChanged = ASMHelper.getRemappedMF("onInventoryChanged",          "func_76316_a");
	public static String M_func110241cb = ASMHelper.getRemappedMF("func_110241_cb",              "func_110241_cb");
	public static String M_getTotalArmorValue = ASMHelper.getRemappedMF("getTotalArmorValue",          "func_70658_aO");

	public static void initialize(){
		if(isInitialized){
			return;
		}
		
		F_dataWatcher = ASMHelper.getRemappedMF("dataWatcher", "field_70180_af");
		F_horseChest = ASMHelper.getRemappedMF("horseChest", "field_110296_bG");
		F_field110280bR = ASMHelper.getRemappedMF("field_110280_bR", "field_110280_bR");
		F_field110286bQ = ASMHelper.getRemappedMF("field_110286_bQ", "field_110286_bQ");
		F_ironShovel = ASMHelper.getRemappedMF("iron_shovel", "field_151037_a");
		F_iron_horse_armor = ASMHelper.getRemappedMF("iron_horse_armor", "field_151138_bX");
		F_diamondHorseArmor = ASMHelper.getRemappedMF("diamond_horse_armor", "field_151125_bZ");
		F_armorValues = ASMHelper.getRemappedMF("armorValues", "field_110272_by");
		
		M_updateObject = ASMHelper.getRemappedMF("updateObject", "func_75692_b");
		M_getStackInSlot = ASMHelper.getRemappedMF("getStackInSlot", "func_70301_a");
		M_addObject = ASMHelper.getRemappedMF("addObject", "func_75682_a");
		M_getItem = ASMHelper.getRemappedMF("getItem", "func_77973_b");
		M_getWatchableObjectIS = ASMHelper.getRemappedMF("getWatchableObjectItemStack", "func_82710_f");
		M_isItemEqual = ASMHelper.getRemappedMF("isItemEqual", "func_77969_a");
		M_playSound = ASMHelper.getRemappedMF("playSound", "func_85030_a");
		M_getUnlocalizedName = ASMHelper.getRemappedMF("getUnlocalizedName", "func_77977_a");
		M_interact = ASMHelper.getRemappedMF("interact", "func_70085_c");
		M_func146085a = ASMHelper.getRemappedMF("func_146085_a", "func_146085_a");
		M_entityInit = ASMHelper.getRemappedMF("entityInit", "func_70088_a");
		M_func110232cE = ASMHelper.getRemappedMF("func_110232_cE", "func_110232_cE");
		M_setHorseTexturePaths = ASMHelper.getRemappedMF("setHorseTexturePaths", "func_110247_cG");
		M_isHorseSaddled = ASMHelper.getRemappedMF("isHorseSaddled", "func_110257_ck");
		M_onInventoryChanged = ASMHelper.getRemappedMF("onInventoryChanged", "func_76316_a");
		M_func110241cb = ASMHelper.getRemappedMF("func_110241_cb", "func_110241_cb");
		M_getTotalArmorValue = ASMHelper.getRemappedMF("getTotalArmorValue", "func_70658_aO");
		
		isInitialized = true;
	}
}
