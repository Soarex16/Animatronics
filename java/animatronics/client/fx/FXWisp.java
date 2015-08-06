/**
 * This class was created by <Azanor>. It's distributed as
 * part of the Animatronics : biomechanic wizardy Mod by BIOS.
 *
 * Animatronics : biomechanic wizardy  distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [? (GMT)]
 */

package animatronics.client.fx;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class FXWisp extends EntityFX {
	
    Entity target = null;
    public boolean shrink = false;
    float moteParticleScale;
    int moteHalfLife;
    public boolean tinkle = false;
    public int blendmode = 1;

    public FXWisp(World world, double d, double d1, double d2, float f, float f1, float f2) {
        this(world, d, d1, d2, 1.0f, f, f1, f2);
    }

    public FXWisp(World world, double d, double d1, double d2, float f, float red, float green, float blue) {
        super(world, d, d1, d2, 0.0, 0.0, 0.0);
        if (red == 0.0f) {
            red = 1.0f;
        }
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
        this.particleGravity = 0.0f;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.particleScale*=f;
        this.moteParticleScale = this.particleScale;
        this.particleMaxAge = (int)(36.0 / (Math.random() * 0.3 + 0.7));
        this.moteHalfLife = this.particleMaxAge / 2;
        this.noClip = false;
        this.setSize(0.1f, 0.1f);
        EntityLivingBase renderentity = FMLClientHandler.instance().getClient().renderViewEntity;
        int visibleDistance = 50;
        if (!FMLClientHandler.instance().getClient().gameSettings.fancyGraphics) {
            visibleDistance = 25;
        }
        if (renderentity.getDistance(this.posX, this.posY, this.posZ) > (double)visibleDistance) {
            this.particleMaxAge = 0;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public FXWisp(World world, double d, double d1, double d2, float f, int type) {
        this(world, d, d1, d2, f, 0.0f, 0.0f, 0.0f);
        switch (type) {
            case 0: {
                this.particleRed = 0.75f + world.rand.nextFloat() * 0.25f;
                this.particleGreen = 0.25f + world.rand.nextFloat() * 0.25f;
                this.particleBlue = 0.75f + world.rand.nextFloat() * 0.25f;
                break;
            }
            case 1: {
                this.particleRed = 0.5f + world.rand.nextFloat() * 0.3f;
                this.particleGreen = 0.5f + world.rand.nextFloat() * 0.3f;
                this.particleBlue = 0.2f;
                break;
            }
            case 2: {
                this.particleRed = 0.2f;
                this.particleGreen = 0.2f;
                this.particleBlue = 0.7f + world.rand.nextFloat() * 0.3f;
                break;
            }
            case 3: {
                this.particleRed = 0.2f;
                this.particleGreen = 0.7f + world.rand.nextFloat() * 0.3f;
                this.particleBlue = 0.2f;
                break;
            }
            case 4: {
                this.particleRed = 0.7f + world.rand.nextFloat() * 0.3f;
                this.particleGreen = 0.2f;
                this.particleBlue = 0.2f;
                break;
            }
            case 5: {
                this.blendmode = 771;
                this.particleRed = world.rand.nextFloat() * 0.1f;
                this.particleGreen = world.rand.nextFloat() * 0.1f;
                this.particleBlue = world.rand.nextFloat() * 0.1f;
                break;
            }
            case 6: {
                this.particleRed = 0.8f + world.rand.nextFloat() * 0.2f;
                this.particleGreen = 0.8f + world.rand.nextFloat() * 0.2f;
                this.particleBlue = 0.8f + world.rand.nextFloat() * 0.2f;
                break;
            }
            case 7: {
                this.particleRed = 0.7f + world.rand.nextFloat() * 0.3f;
                this.particleGreen = 0.5f + world.rand.nextFloat() * 0.2f;
                this.particleBlue = 0.3f + world.rand.nextFloat() * 0.1f;
            }
        }
    }

    public FXWisp(World world, double d, double d1, double d2, double x, double y, double z, float f, int type) {
        this(world, d, d1, d2, f, type);
        if (this.particleMaxAge > 0) {
            double dx = x - this.posX;
            double dy = y - this.posY;
            double dz = z - this.posZ;
            this.motionX = dx / (double)this.particleMaxAge;
            this.motionY = dy / (double)this.particleMaxAge;
            this.motionZ = dz / (double)this.particleMaxAge;
        }
    }

    public FXWisp(World world, double d, double d1, double d2, Entity tar, int type) {
        this(world, d, d1, d2, 0.4f, type);
        this.target = tar;
    }

    public FXWisp(World world, double d, double d1, double d2, double x, double y, double z, float f, float red, float green, float blue) {
        this(world, d, d1, d2, f, red, green, blue);
        if (this.particleMaxAge > 0) {
            double dx = x - this.posX;
            double dy = y - this.posY;
            double dz = z - this.posZ;
            this.motionX = dx / (double)this.particleMaxAge;
            this.motionY = dy / (double)this.particleMaxAge;
            this.motionZ = dz / (double)this.particleMaxAge;
        }
    }

    public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5) {
        float agescale = 0.0f;
        if (this.shrink) {
            agescale = ((float)this.particleMaxAge - (float)this.particleAge) / (float)this.particleMaxAge;
        } else {
            agescale = (float)this.particleAge / (float)this.moteHalfLife;
            if (agescale > 1.0f) {
                agescale = 2.0f - agescale;
            }
        }
        this.particleScale = this.moteParticleScale * agescale;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        float f10 = 0.5f * this.particleScale;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f - interpPosZ);
        float var8 = 0.0f;
        float var9 = 0.125f;
        float var10 = 0.875f;
        float var11 = 1.0f;
        tessellator.setBrightness(240);
        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, 0.5f);
        tessellator.addVertexWithUV((double)(f11 - f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 - f3 * f10 - f5 * f10), (double)var9, (double)var11);
        tessellator.addVertexWithUV((double)(f11 - f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 - f3 * f10 + f5 * f10), (double)var9, (double)var10);
        tessellator.addVertexWithUV((double)(f11 + f1 * f10 + f4 * f10), (double)(f12 + f2 * f10), (double)(f13 + f3 * f10 + f5 * f10), (double)var8, (double)var10);
        tessellator.addVertexWithUV((double)(f11 + f1 * f10 - f4 * f10), (double)(f12 - f2 * f10), (double)(f13 + f3 * f10 - f5 * f10), (double)var8, (double)var11);
    }

    public int getFXLayer() {
        return this.blendmode == 1 ? 0 : 1;
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge == 0 && this.tinkle && this.worldObj.rand.nextInt(3) == 0) {
            this.worldObj.playSoundAtEntity((Entity)this, "random.orb", 0.02f, 0.5f * ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.6f + 2.0f));
        }
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setDead();
        }
        this.motionY-=0.04 * (double)this.particleGravity;
        if (!this.noClip) {
            this.pushOutOfBlocks(this.posX, this.posY, this.posZ);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.target != null) {
            this.motionX*=0.985;
            this.motionY*=0.985;
            this.motionZ*=0.985;
            double dx = this.target.posX - this.posX;
            double dy = this.target.posY + (double)(this.target.height / 2.0f) - this.posY;
            double dz = this.target.posZ - this.posZ;
            double d13 = 0.2;
            double d11 = MathHelper.sqrt_double((double)(dx * dx + dy * dy + dz * dz));
            this.motionX+=(dx/=d11) * d13;
            this.motionY+=(dy/=d11) * d13;
            this.motionZ+=(dz/=d11) * d13;
            this.motionX = MathHelper.clamp_float((float)((float)this.motionX), (float)-0.2f, (float)0.2f);
            this.motionY = MathHelper.clamp_float((float)((float)this.motionY), (float)-0.2f, (float)0.2f);
            this.motionZ = MathHelper.clamp_float((float)((float)this.motionZ), (float)-0.2f, (float)0.2f);
        } else {
            this.motionX*=0.9800000190734863;
            this.motionY*=0.9800000190734863;
            this.motionZ*=0.9800000190734863;
            if (this.onGround) {
                this.motionX*=0.699999988079071;
                this.motionZ*=0.699999988079071;
            }
        }
    }

    protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
        int var7 = MathHelper.floor_double((double)par1);
        int var8 = MathHelper.floor_double((double)par3);
        int var9 = MathHelper.floor_double((double)par5);
        double var10 = par1 - (double)var7;
        double var12 = par3 - (double)var8;
        double var14 = par5 - (double)var9;
        if (!(this.worldObj.isAirBlock(var7, var8, var9) || !this.worldObj.isBlockNormalCubeDefault(var7, var8, var9, true) || this.worldObj.isAnyLiquid(this.boundingBox))) {
            boolean var16 = !this.worldObj.isBlockNormalCubeDefault(var7 - 1, var8, var9, true);
            boolean var17 = !this.worldObj.isBlockNormalCubeDefault(var7 + 1, var8, var9, true);
            boolean var18 = !this.worldObj.isBlockNormalCubeDefault(var7, var8 - 1, var9, true);
            boolean var19 = !this.worldObj.isBlockNormalCubeDefault(var7, var8 + 1, var9, true);
            boolean var20 = !this.worldObj.isBlockNormalCubeDefault(var7, var8, var9 - 1, true);
            boolean var21 = !this.worldObj.isBlockNormalCubeDefault(var7, var8, var9 + 1, true);
            int var22 = -1;
            double var23 = 9999.0;
            if (var16 && var10 < var23) {
                var23 = var10;
                var22 = 0;
            }
            if (var17 && 1.0 - var10 < var23) {
                var23 = 1.0 - var10;
                var22 = 1;
            }
            if (var18 && var12 < var23) {
                var23 = var12;
                var22 = 2;
            }
            if (var19 && 1.0 - var12 < var23) {
                var23 = 1.0 - var12;
                var22 = 3;
            }
            if (var20 && var14 < var23) {
                var23 = var14;
                var22 = 4;
            }
            if (var21 && 1.0 - var14 < var23) {
                var23 = 1.0 - var14;
                var22 = 5;
            }
            float var25 = this.rand.nextFloat() * 0.05f + 0.025f;
            float var26 = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
            if (var22 == 0) {
                this.motionX = - var25;
                this.motionY = this.motionZ = (double)var26;
            }
            if (var22 == 1) {
                this.motionX = var25;
                this.motionY = this.motionZ = (double)var26;
            }
            if (var22 == 2) {
                this.motionY = - var25;
                this.motionX = this.motionZ = (double)var26;
            }
            if (var22 == 3) {
                this.motionY = var25;
                this.motionX = this.motionZ = (double)var26;
            }
            if (var22 == 4) {
                this.motionZ = - var25;
                this.motionY = this.motionX = (double)var26;
            }
            if (var22 == 5) {
                this.motionZ = var25;
                this.motionY = this.motionX = (double)var26;
            }
            return true;
        }
        return false;
    }

    public void setGravity(float value) {
        this.particleGravity = value;
    }
}
