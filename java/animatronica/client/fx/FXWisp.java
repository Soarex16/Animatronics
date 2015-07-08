package animatronica.client.fx;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class FXWisp
  extends EntityFX
{
  public FXWisp(World world, double d, double d1, double d2, float f, float f1, float f2)
  {
    this(world, d, d1, d2, 1.0F, f, f1, f2);
  }
  
  Entity target = null;
  
  public FXWisp(World world, double d, double d1, double d2, float f, float red, float green, float blue)
  {
    super(world, d, d1, d2, 0.0D, 0.0D, 0.0D);
    if (red == 0.0F) {
      red = 1.0F;
    }
    this.particleRed = red;
    this.particleGreen = green;
    this.particleBlue = blue;
    this.particleGravity = 0.0F;
    this.motionX = (this.motionY = this.motionZ = 0.0D);
    this.particleScale *= f;
    this.moteParticleScale = this.particleScale;
    this.particleMaxAge = ((int)(36.0D / (Math.random() * 0.3D + 0.7D)));
    this.moteHalfLife = (this.particleMaxAge / 2);
    this.noClip = false;
    setSize(0.1F, 0.1F);
    EntityLivingBase renderentity = FMLClientHandler.instance().getClient().renderViewEntity;
    int visibleDistance = 50;
    if (!FMLClientHandler.instance().getClient().gameSettings.fancyGraphics) {
      visibleDistance = 25;
    }
    if (renderentity.getDistance(this.posX, this.posY, this.posZ) > visibleDistance) {
      this.particleMaxAge = 0;
    }
    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;
  }
  
  public FXWisp(World world, double d, double d1, double d2, float f, int type)
  {
    this(world, d, d1, d2, f, 0.0F, 0.0F, 0.0F);
    switch (type)
    {
    case 0: 
      this.particleRed = (0.75F + world.rand.nextFloat() * 0.25F);
      this.particleGreen = (0.25F + world.rand.nextFloat() * 0.25F);
      this.particleBlue = (0.75F + world.rand.nextFloat() * 0.25F);
      break;
    case 1: 
      this.particleRed = (0.5F + world.rand.nextFloat() * 0.3F);
      this.particleGreen = (0.5F + world.rand.nextFloat() * 0.3F);
      this.particleBlue = 0.2F;
      break;
    case 2: 
      this.particleRed = 0.2F;
      this.particleGreen = 0.2F;
      this.particleBlue = (0.7F + world.rand.nextFloat() * 0.3F);
      break;
    case 3: 
      this.particleRed = 0.2F;
      this.particleGreen = (0.7F + world.rand.nextFloat() * 0.3F);
      this.particleBlue = 0.2F;
      break;
    case 4: 
      this.particleRed = (0.7F + world.rand.nextFloat() * 0.3F);
      this.particleGreen = 0.2F;
      this.particleBlue = 0.2F;
      break;
    case 5: 
      this.blendmode = 771;
      this.particleRed = (world.rand.nextFloat() * 0.1F);
      this.particleGreen = (world.rand.nextFloat() * 0.1F);
      this.particleBlue = (world.rand.nextFloat() * 0.1F);
      break;
    case 6: 
      this.particleRed = (0.8F + world.rand.nextFloat() * 0.2F);
      this.particleGreen = (0.8F + world.rand.nextFloat() * 0.2F);
      this.particleBlue = (0.8F + world.rand.nextFloat() * 0.2F);
      break;
    case 7: 
      this.particleRed = (0.7F + world.rand.nextFloat() * 0.3F);
      this.particleGreen = (0.5F + world.rand.nextFloat() * 0.2F);
      this.particleBlue = (0.3F + world.rand.nextFloat() * 0.1F);
    }
  }
  
  public FXWisp(World world, double d, double d1, double d2, double x, double y, double z, float f, int type)
  {
    this(world, d, d1, d2, f, type);
    if (this.particleMaxAge > 0)
    {
      double dx = x - this.posX;
      double dy = y - this.posY;
      double dz = z - this.posZ;
      
      this.motionX = (dx / this.particleMaxAge);
      this.motionY = (dy / this.particleMaxAge);
      this.motionZ = (dz / this.particleMaxAge);
    }
  }
  
  public FXWisp(World world, double d, double d1, double d2, Entity tar, int type)
  {
    this(world, d, d1, d2, 0.4F, type);
  }
  
  public FXWisp(World world, double d, double d1, double d2, double x, double y, double z, float f, float red, float green, float blue)
  {
    this(world, d, d1, d2, f, red, green, blue);
    if (this.particleMaxAge > 0)
    {
      double dx = x - this.posX;
      double dy = y - this.posY;
      double dz = z - this.posZ;
      
      this.motionX = (dx / this.particleMaxAge);
      this.motionY = (dy / this.particleMaxAge);
      this.motionZ = (dz / this.particleMaxAge);
    }
  }
  
  public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
  {
    float agescale = 0.0F;
    if (this.shrink)
    {
      agescale = (this.particleMaxAge - this.particleAge) / this.particleMaxAge;
    }
    else
    {
      agescale = this.particleAge / this.moteHalfLife;
      if (agescale > 1.0F) {
        agescale = 2.0F - agescale;
      }
    }
    this.particleScale = (this.moteParticleScale * agescale);
    
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
    
    float f10 = 0.5F * this.particleScale;
    float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * f - interpPosX);
    float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * f - interpPosY);
    float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * f - interpPosZ);
    
    float var8 = 0.0F;
    float var9 = 0.125F;
    float var10 = 0.875F;
    float var11 = 1.0F;
    
    tessellator.setBrightness(240);
    
    tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, 0.5F);
    
    tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, var9, var11);
    
    tessellator.addVertexWithUV(f11 - f1 * f10 + f4 * f10, f12 + f2 * f10, f13 - f3 * f10 + f5 * f10, var9, var10);
    
    tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, var8, var10);
    
    tessellator.addVertexWithUV(f11 + f1 * f10 - f4 * f10, f12 - f2 * f10, f13 + f3 * f10 - f5 * f10, var8, var11);
  }
  
  public int getFXLayer()
  {
    return this.blendmode == 1 ? 0 : 1;
  }
  
  public void onUpdate()
  {
    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;
    if ((this.particleAge == 0) && (this.tinkle) && (this.worldObj.rand.nextInt(3) == 0)) {
      this.worldObj.playSoundAtEntity(this, "random.orb", 0.02F, 0.5F * ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.6F + 2.0F));
    }
    if (this.particleAge++ >= this.particleMaxAge) {
      setDead();
    }
    this.motionY -= 0.04D * this.particleGravity;
    if (!this.noClip) {
      pushOutOfBlocks(this.posX, this.posY, this.posZ);
    }
    moveEntity(this.motionX, this.motionY, this.motionZ);
    if (this.target != null)
    {
      this.motionX *= 0.985D;
      this.motionY *= 0.985D;
      this.motionZ *= 0.985D;
      
      double dx = this.target.posX - this.posX;
      double dy = this.target.posY + this.target.height / 2.0F - this.posY;
      double dz = this.target.posZ - this.posZ;
      double d13 = 0.2D;
      double d11 = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);
      
      dx /= d11;
      dy /= d11;
      dz /= d11;
      
      this.motionX += dx * d13;
      this.motionY += dy * d13;
      this.motionZ += dz * d13;
      
      this.motionX = MathHelper.clamp_float((float)this.motionX, -0.2F, 0.2F);
      this.motionY = MathHelper.clamp_float((float)this.motionY, -0.2F, 0.2F);
      this.motionZ = MathHelper.clamp_float((float)this.motionZ, -0.2F, 0.2F);
    }
    else
    {
      this.motionX *= 0.9800000190734863D;
      this.motionY *= 0.9800000190734863D;
      this.motionZ *= 0.9800000190734863D;
      if (this.onGround)
      {
        this.motionX *= 0.699999988079071D;
        this.motionZ *= 0.699999988079071D;
      }
    }
  }
  
  protected boolean pushOutOfBlocks(double par1, double par3, double par5)
  {
    int var7 = MathHelper.floor_double(par1);
    int var8 = MathHelper.floor_double(par3);
    int var9 = MathHelper.floor_double(par5);
    double var10 = par1 - var7;
    double var12 = par3 - var8;
    double var14 = par5 - var9;
    if ((!this.worldObj.isAirBlock(var7, var8, var9)) && (this.worldObj.isBlockNormalCubeDefault(var7, var8, var9, true)) && (!this.worldObj.isAnyLiquid(this.boundingBox)))
    {
      boolean var16 = !this.worldObj.isBlockNormalCubeDefault(var7 - 1, var8, var9, true);
      
      boolean var17 = !this.worldObj.isBlockNormalCubeDefault(var7 + 1, var8, var9, true);
      
      boolean var18 = !this.worldObj.isBlockNormalCubeDefault(var7, var8 - 1, var9, true);
      
      boolean var19 = !this.worldObj.isBlockNormalCubeDefault(var7, var8 + 1, var9, true);
      
      boolean var20 = !this.worldObj.isBlockNormalCubeDefault(var7, var8, var9 - 1, true);
      
      boolean var21 = !this.worldObj.isBlockNormalCubeDefault(var7, var8, var9 + 1, true);
      
      byte var22 = -1;
      double var23 = 9999.0D;
      if ((var16) && (var10 < var23))
      {
        var23 = var10;
        var22 = 0;
      }
      if ((var17) && (1.0D - var10 < var23))
      {
        var23 = 1.0D - var10;
        var22 = 1;
      }
      if ((var18) && (var12 < var23))
      {
        var23 = var12;
        var22 = 2;
      }
      if ((var19) && (1.0D - var12 < var23))
      {
        var23 = 1.0D - var12;
        var22 = 3;
      }
      if ((var20) && (var14 < var23))
      {
        var23 = var14;
        var22 = 4;
      }
      if ((var21) && (1.0D - var14 < var23))
      {
        var23 = 1.0D - var14;
        var22 = 5;
      }
      float var25 = this.rand.nextFloat() * 0.05F + 0.025F;
      float var26 = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F;
      if (var22 == 0)
      {
        this.motionX = (-var25);
        this.motionY = (this.motionZ = var26);
      }
      if (var22 == 1)
      {
        this.motionX = var25;
        this.motionY = (this.motionZ = var26);
      }
      if (var22 == 2)
      {
        this.motionY = (-var25);
        this.motionX = (this.motionZ = var26);
      }
      if (var22 == 3)
      {
        this.motionY = var25;
        this.motionX = (this.motionZ = var26);
      }
      if (var22 == 4)
      {
        this.motionZ = (-var25);
        this.motionY = (this.motionX = var26);
      }
      if (var22 == 5)
      {
        this.motionZ = var25;
        this.motionY = (this.motionX = var26);
      }
      return true;
    }
    return false;
  }
  
  public void setGravity(float value)
  {
    this.particleGravity = value;
  }
  
  public boolean shrink = false;
  float moteParticleScale;
  int moteHalfLife;
  public boolean tinkle = false;
  public int blendmode = 1;
}