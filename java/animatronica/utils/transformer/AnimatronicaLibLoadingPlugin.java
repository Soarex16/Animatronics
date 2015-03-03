package animatronica.utils.transformer;

import java.util.Map;

import animatronica.utils.helper.ASMHelper;
import animatronica.utils.helper.ASMNames;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@SortingIndex(1001)
@MCVersion("1.7.10")
@TransformerExclusions({"animatronica.utils.transformer"})
public class AnimatronicaLibLoadingPlugin implements IFMLLoadingPlugin{
    
    public String getAccessTransformerClass(){
        return null;
    }

    public String[] getASMTransformerClass(){
        return new String[]{ TransformHorseArmor.class.getName() };
    }

    public String getModContainerClass(){
        return null;
    }

    public String getSetupClass(){
        return null;
    }

    public void injectData(Map<String, Object> data){
        ASMHelper.isMCP = !((Boolean)data.get("runtimeDeobfuscationEnabled")).booleanValue();
        ASMNames.initialize();
    }
}