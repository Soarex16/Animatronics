package animatronica.utils.config;

import java.io.File;

import animatronica.Animatronica;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class AnimatronicaConfiguration{

	public static Configuration config;

	public static boolean matrixMode = false;
    
    public static boolean fancyParticles = true;

	public static void init(String cfgPath){
		config = new Configuration(new File(cfgPath));
		syncConfig();
	}
	
	public static void syncConfig(){
		
		matrixMode = config.getBoolean("Matrix Mode", Configuration.CATEGORY_GENERAL, matrixMode, "It is just matrix mode, because I'm spagetti *O*");
		
		fancyParticles = config.getBoolean("Fancy Particles", Configuration.CATEGORY_GENERAL, fancyParticles, "It's just for test");
		
		if(config.hasChanged()){
			config.save();
		}
	}
}
