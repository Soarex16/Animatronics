package animatronica.utils.config;

import java.io.File;

import animatronica.Animatronica;
import net.minecraftforge.common.config.Configuration;

public class AnimatronicaConfiguration{

	public static Configuration configFile = (Configuration)Animatronica.configFile;

	public static boolean matrixMode = false;
    public static boolean fancyParticles = true;
    
    public static float generatorMaxEntropy = 1000000;
    public static float consumerMaxEntropy = 100000;

	public static void init(String cfgPath){
		

		if(configFile==null) {
			configFile = new Configuration(new File(cfgPath));
		}
		
		try
		{
			configFile.load();
		}catch(Exception e){
			
		}
			finally {
				if(configFile.hasChanged()){
					configFile.save();
				}
			}
		
		syncConfig();
	}
	
	public static void syncConfig(){
		
		matrixMode = configFile.getBoolean("Matrix Mode", Configuration.CATEGORY_GENERAL, matrixMode, "It is just matrix mode, because I'm spagetti *O*");
		fancyParticles = configFile.getBoolean("Fancy Particles", Configuration.CATEGORY_GENERAL, fancyParticles, "It's just for test");
		
		generatorMaxEntropy = configFile.getFloat("Generator MAX Entropy", Configuration.CATEGORY_GENERAL, generatorMaxEntropy, 1000, 100000000, "This variable uses to set maximum entropy capacity in generators");
		consumerMaxEntropy = configFile.getFloat("Consumer MIN Entropy", Configuration.CATEGORY_GENERAL, consumerMaxEntropy, 1000, 100000000, "This variable uses to set maximum entropy capacity in consumers");
		
		
		
		if(configFile.hasChanged()){
			configFile.save();
		}
	}
}
