package animatronics.utils.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialBase extends Material{

	public MaterialBase(MapColor mapColor){
		super(mapColor);
	}

	public Material setNoPushMobility(){
		return super.setNoPushMobility();
	}

	public Material setRequiresTool(){
		return super.setRequiresTool();
	}

	public Material setBurning(){
		return super.setBurning();
	}

	public Material setImmovableMobility(){
		return super.setImmovableMobility();
	}

	public Material setAdventureModeExempt(){
		return super.setAdventureModeExempt();
	}
}
