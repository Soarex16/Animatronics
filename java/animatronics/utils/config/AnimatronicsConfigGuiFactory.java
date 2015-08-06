package animatronics.utils.config;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

public class AnimatronicsConfigGuiFactory implements IModGuiFactory{

	public void initialize(Minecraft minecraftInstance){}

	public Class<? extends GuiScreen> mainConfigGuiClass(){
		return AnimatronicsConfigGui.class;
	}

	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories(){
		return null;
	}

	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element){
		return null;
	}
}