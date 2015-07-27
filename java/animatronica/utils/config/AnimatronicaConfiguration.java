package animatronica.utils.config;

import java.io.File;

import animatronica.Animatronica;
import net.minecraftforge.common.config.Configuration;

public class AnimatronicaConfiguration{

	public static Configuration configFile = (Configuration)Animatronica.configFile;

	public static boolean matrixMode = false;
    public static boolean fancyParticles = true;
	public static boolean vanillaParticleLimitter = false;
	public static boolean useShaders = true;
	
	public static int maxEntropy = 1000000;
    public static float generatorMaxEntropy = 1000000;
    public static float consumerMaxEntropy = 100000;
    public static float maxEnergyDistance = 16;

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
		fancyParticles = configFile.getBoolean("Fancy Particles", Configuration.CATEGORY_GENERAL, fancyParticles, "This is just for compatibility with shaders (I do not know whether it will work)");
		vanillaParticleLimitter = configFile.getBoolean("Vanilla Particle Limitter", Configuration.CATEGORY_GENERAL, vanillaParticleLimitter, "Don't change this without need");
		useShaders = configFile.getBoolean("Use Shaders", Configuration.CATEGORY_GENERAL, useShaders, "Use shaders");
		
		maxEntropy = configFile.getInt("MAX Entropy for Machines", Configuration.CATEGORY_GENERAL, maxEntropy, 1000, 100000000, "This variable used to set maximum entropy in machines");
		generatorMaxEntropy = configFile.getFloat("Generator MAX Entropy", Configuration.CATEGORY_GENERAL, generatorMaxEntropy, 1000, 100000000, "This variable used to set maximum entropy capacity in generators");
		consumerMaxEntropy = configFile.getFloat("Consumer MAX Entropy", Configuration.CATEGORY_GENERAL, consumerMaxEntropy, 1000, 100000000, "This variable used to set maximum entropy capacity in consumers");
		maxEnergyDistance = configFile.getFloat("MAX Entropy Transfering distance", Configuration.CATEGORY_GENERAL, maxEnergyDistance, 2, 512, "This variable used to set distance of entropy transfering");
		
		
		if(configFile.hasChanged()){
			configFile.save();
		}
	}
}
