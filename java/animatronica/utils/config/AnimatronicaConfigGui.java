package animatronica.utils.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class AnimatronicaConfigGui extends GuiConfig{
    
	public AnimatronicaConfigGui(GuiScreen parent) {
        super(parent, new ConfigElement(AnimatronicaConfiguration.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "Animatronica", false, false, "Animatronica");
    }
}
 