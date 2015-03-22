package animatronica.debug;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import animatronica.Animatronica;

public class RenderItemDebug implements IItemRenderer {

	private ModelItemDebug model;

	public RenderItemDebug(){
		model = new ModelItemDebug(); 
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
        if(type == type.EQUIPPED_FIRST_PERSON)
        {
        	GL11.glScaled(1.0D, 1.0D, 0.90D);
        	GL11.glTranslatef(0.0F, 2.0F, 0.5F);
        	GL11.glRotatef(180F, 0, 0, 1);
        	GL11.glRotatef(215F, 0, 1, 0);
        	GL11.glRotatef(-10F, 1, 0, 0);
        	GL11.glScaled(1.2D, 1.2D, 1.2D);
        } else if (type == type.INVENTORY)
        {
        	GL11.glScaled(0.85D, 0.85D, 0.85D);
        	GL11.glTranslatef(0.5F, 0.9F, 0.5F);
        	GL11.glRotatef(180F, 0, 0, 1);
        } else if (type == type.EQUIPPED) 
        {
        	GL11.glTranslatef(0.0F, 1.0F, 0.0F);
        	GL11.glRotatef(180F, 0, 0, 1);
        	GL11.glRotatef(135F, 0, 1, 0);
        	GL11.glRotatef(-70F, 1, 0, 0);
        	GL11.glScaled(2.0D, 2.0D, 2.0D);  
        } else
        {
        	GL11.glTranslatef(0.0F, 3.0F, 0.0F);
        	GL11.glRotatef(180F, 0, 0, 1);
        	GL11.glRotatef(0F, 0, 1, 0);
        	GL11.glRotatef(0F, 1, 0, 0);
        	GL11.glScaled(2.0D, 2.0D, 2.0D);  
        }
    Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Animatronica.MOD_ID + ":" + "textures/models/modelItemDebug.png"));
    model.renderModel(0.0625F);
    GL11.glPopMatrix();
    }
}
