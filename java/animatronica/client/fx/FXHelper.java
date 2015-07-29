package animatronica.client.fx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.ReflectionHelper;

public class FXHelper {
		
	public static int wispFxCount = 0;
	public static int depthIgnoringWispFxCount = 0;
	public static int sparkleFxCount = 0;
	
	
	public static void dispatch() {
		Tessellator tessellator = Tessellator.instance;

		boolean isLightingEnabled = GL11.glGetBoolean(GL11.GL_LIGHTING);
		Profiler profiler = Minecraft.getMinecraft().mcProfiler;

		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		if(isLightingEnabled)
			GL11.glDisable(GL11.GL_LIGHTING);

		profiler.startSection("sparkle");
		FXSparkle.dispatchQueuedRenders(tessellator);
		profiler.endStartSection("wisp");
		FXWisp.dispatchQueuedRenders(tessellator);
		profiler.endSection();

		if(isLightingEnabled)
			GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
	}
	
	public static final String PREFIX_MOD = "animatronica:";
	public static final String PREFIX_MISC = PREFIX_MOD + "textures/misc/";
	public static final String MISC_PARTICLES = PREFIX_MISC + "particles.png";
	public static final String MISC_WISP_LARGE = PREFIX_MISC + "wispLarge.png";
	public static final String MISC_WISP_SMALL = PREFIX_MISC + "wispSmall.png";
	
	// EffectRenderer
	public static final String[] PARTICLE_TEXTURES = new String[] { "particleTextures", "field_110737_b", "b" };
	
	public static ResourceLocation getParticleTexture() {
			return ReflectionHelper.getPrivateValue(EffectRenderer.class, null, FXHelper.PARTICLE_TEXTURES);
		}	
		
}
