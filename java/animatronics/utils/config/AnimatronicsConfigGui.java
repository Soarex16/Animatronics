package animatronics.utils.config;

import java.util.List;

import com.google.common.collect.Lists;

import animatronics.Animatronics;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

public class AnimatronicsConfigGui extends GuiConfig{
    
	public AnimatronicsConfigGui(GuiScreen parent) {
		super(parent, getConfigElements(), Animatronics.MOD_ID, false, false, "Animatronics");
	}
	
	private static List getConfigElements() {
		List<ConfigElement> list = Lists.newArrayList();
		list.add(new ConfigElement(AnimatronicsConfiguration.configFile.getCategory("energy")));
		return list;
	}
}
 