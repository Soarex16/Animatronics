package animatronica.utils.transformer;

import java.io.IOException;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class AnimatronicaLibAccessTransformer extends AccessTransformer{
   
	public AnimatronicaLibAccessTransformer() throws IOException{
        super("animatronica_at.cfg");
    }
}
