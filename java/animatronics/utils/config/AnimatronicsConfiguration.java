package animatronics.utils.config;

import java.io.File;

import animatronics.Animatronics;
import net.minecraftforge.common.config.Configuration;

public class AnimatronicsConfiguration{

	public static Configuration configFile = (Configuration)Animatronics.configFile;
	
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
		
		maxEntropy = configFile.getInt("MAX Entropy for Machines", Configuration.CATEGORY_GENERAL, maxEntropy, 1000, 100000000, "This variable used to set maximum entropy in machines");
		generatorMaxEntropy = configFile.getFloat("Generator MAX Entropy", Configuration.CATEGORY_GENERAL, generatorMaxEntropy, 1000, 100000000, "This variable used to set maximum entropy capacity in generators");
		consumerMaxEntropy = configFile.getFloat("Consumer MAX Entropy", Configuration.CATEGORY_GENERAL, consumerMaxEntropy, 1000, 100000000, "This variable used to set maximum entropy capacity in consumers");
		maxEnergyDistance = configFile.getFloat("MAX Entropy Transfering distance", Configuration.CATEGORY_GENERAL, maxEnergyDistance, 2, 512, "This variable used to set distance of entropy transfering");
		
		
		if(configFile.hasChanged()){
			configFile.save();
		}
	}
}
