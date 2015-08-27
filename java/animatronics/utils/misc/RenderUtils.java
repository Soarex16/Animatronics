package animatronics.utils.misc;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public class RenderUtils{

	RenderBlocks renderBlocks = new RenderBlocks();

	public boolean renderStandardBlockWithColorMultiplier(Block block, int x, int y, int z, float r, float g, float b, float a){
		renderBlocks.enableAO = false;
		
		Tessellator tessellator = Tessellator.instance;
		
		boolean result = false;
		
		float f3 = 0.5F;
		float f4 = 1.0F;
		float f5 = 0.8F;
		float f6 = 0.6F;
		float f7 = f4 * r;
		float f8 = f4 * g;
		float f9 = f4 * b;
		float f10 = f3;
		float f11 = f5;
		float f12 = f6;
		float f13 = f3;
		float f14 = f5;
		float f15 = f6;
		float f16 = f3;
		float f17 = f5;
		float f18 = f6;

		if(block != Blocks.grass){
			f10 = f3 * r;
			f11 = f5 * r;
			f12 = f6 * r;
			f13 = f3 * g;
			f14 = f5 * g;
			f15 = f6 * g;
			f16 = f3 * b;
			f17 = f5 * b;
			f18 = f6 * b;
		}

		int blockMixedBrightness = block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x, y, z);

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x, y - 1, z, 0)){
			tessellator.setBrightness(renderBlocks.renderMinY > 0.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x, y - 1, z));
			tessellator.setColorRGBA_F(f10, f13, f16, a);
			renderBlocks.renderFaceYNeg(block, (double)x, (double)y, (double)z, renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 0));
			result = true;
		}

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x, y + 1, z, 1)){
			tessellator.setBrightness(renderBlocks.renderMaxY < 1.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x, y + 1, z));
			tessellator.setColorRGBA_F(f7, f8, f9, a);
			renderBlocks.renderFaceYPos(block, (double)x, (double)y, (double)z, renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 1));
			result = true;
		}

		IIcon blockIcon;

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x, y, z - 1, 2)){
			tessellator.setBrightness(renderBlocks.renderMinZ > 0.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x, y, z - 1));
			tessellator.setColorRGBA_F(f11, f14, f17, a);
			blockIcon = renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 2);
			renderBlocks.renderFaceZNeg(block, (double)x, (double)y, (double)z, blockIcon);

			if(renderBlocks.fancyGrass && blockIcon.getIconName().equals("grass_side") && !renderBlocks.hasOverrideBlockTexture()){
				tessellator.setColorRGBA_F(f11 * r, f14 * g, f17 * b, a);
				renderBlocks.renderFaceZNeg(block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
			}

			result = true;
		}

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x, y, z + 1, 3)){
			tessellator.setBrightness(renderBlocks.renderMaxZ < 1.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x, y, z + 1));
			tessellator.setColorRGBA_F(f11, f14, f17, a);
			blockIcon = renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 3);
			renderBlocks.renderFaceZPos(block, (double)x, (double)y, (double)z, blockIcon);

			if(renderBlocks.fancyGrass && blockIcon.getIconName().equals("grass_side") && !renderBlocks.hasOverrideBlockTexture()){
				tessellator.setColorRGBA_F(f11 * r, f14 * g, f17 * b, a);
				renderBlocks.renderFaceZPos(block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
			}

			result = true;
		}

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x - 1, y, z, 4)){
			tessellator.setBrightness(renderBlocks.renderMinX > 0.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x - 1, y, z));
			tessellator.setColorRGBA_F(f12, f15, f18, a);
			blockIcon = renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 4);
			renderBlocks.renderFaceXNeg(block, (double)x, (double)y, (double)z, blockIcon);

			if(renderBlocks.fancyGrass && blockIcon.getIconName().equals("grass_side") && !renderBlocks.hasOverrideBlockTexture()){
				tessellator.setColorRGBA_F(f12 * r, f15 * g, f18 * b, a);
				renderBlocks.renderFaceXNeg(block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
			}

			result = true;
		}

		if(renderBlocks.renderAllFaces || block.shouldSideBeRendered(renderBlocks.blockAccess, x + 1, y, z, 5)){
			tessellator.setBrightness(renderBlocks.renderMaxX < 1.0D ? blockMixedBrightness : block.getMixedBrightnessForBlock(renderBlocks.blockAccess, x + 1, y, z));
			tessellator.setColorRGBA_F(f12, f15, f18, a);
			blockIcon = renderBlocks.getBlockIcon(block, renderBlocks.blockAccess, x, y, z, 5);
			renderBlocks.renderFaceXPos(block, (double)x, (double)y, (double)z, blockIcon);

			if(renderBlocks.fancyGrass && blockIcon.getIconName().equals("grass_side") && !renderBlocks.hasOverrideBlockTexture()){
				tessellator.setColorRGBA_F(f12 * r, f15 * g, f18 * b, a);
				renderBlocks.renderFaceXPos(block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
			}

			result = true;
		}

		return result;
	}
	
	public static ResourceLocation getParticleTexture() {
        try {
            return (ResourceLocation)ReflectionHelper.getPrivateValue((Class)EffectRenderer.class, (Object)null, (String[])new String[]{"particleTextures", "b", "field_110737_b"});
        }
        catch (Exception e) {
            return null;
        }
    }
}
