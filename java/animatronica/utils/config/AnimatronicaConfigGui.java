package animatronica.utils.config;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import animatronica.Animatronica;

import com.google.common.collect.Lists;

import cpw.mods.fml.client.config.ConfigGuiType;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class AnimatronicaConfigGui extends GuiConfig{
    
	public AnimatronicaConfigGui(GuiScreen parent){
        super(parent, getConfigElements(), Animatronica.MOD_ID, false, false, "Animatronica Configuration");
    }
	
	public static List<IConfigElement> getConfigElements(){
		List<IConfigElement> elements = Lists.newArrayList();
		elements.add(new DummyConfigElement<Boolean>("Matrix Mode", AnimatronicaConfiguration.matrixMode, ConfigGuiType.BOOLEAN, "It is just matrix mode, because I'm spagetti *O*").setRequiresMcRestart(true));
		
		elements.add(new DummyConfigElement<Boolean>("Fancy Particles", AnimatronicaConfiguration.fancyParticles, ConfigGuiType.BOOLEAN, "It's just for test").setRequiresMcRestart(false));
		return elements; 
	}
}
