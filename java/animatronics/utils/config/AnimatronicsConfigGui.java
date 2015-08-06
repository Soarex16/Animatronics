package animatronics.utils.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class AnimatronicsConfigGui extends GuiConfig{
    
	public AnimatronicsConfigGui(GuiScreen parent) {
        super(parent, new ConfigElement(AnimatronicsConfiguration.configFile.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "Animatronics", false, false, "Animatronics");
    }
}
 