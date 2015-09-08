package animatronics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightingAbsorber extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
  
  public ModelLightingAbsorber()
  {
    textureWidth = 256;
    textureHeight = 128;
    
    Shape1 = new ModelRenderer(this, 0, 0);
    Shape1.addBox(-16F, -1F, -16F, 31, 2, 32);
    Shape1.setRotationPoint(0F, 23F, 0F);
    Shape1.setTextureSize(256, 128);
    Shape1.mirror = true;
    setRotation(Shape1, 0F, 0F, 0F);
    Shape2 = new ModelRenderer(this, 0, 34);
    Shape2.addBox(-12F, -14F, -1F, 24, 28, 2);
    Shape2.setRotationPoint(0F, 8F, -11F);
    Shape2.setTextureSize(256, 128);
    Shape2.mirror = true;
    setRotation(Shape2, 0F, 0F, 0F);
    Shape3 = new ModelRenderer(this, 0, 34);
    Shape3.addBox(-12F, -14F, -1F, 24, 28, 2);
    Shape3.setRotationPoint(0F, 8F, 11F);
    Shape3.setTextureSize(256, 128);
    Shape3.mirror = true;
    setRotation(Shape3, 0F, 0F, 0F);
    Shape4 = new ModelRenderer(this, 82, 34);
    Shape4.addBox(-1F, -14F, -10F, 2, 28, 20);
    Shape4.setRotationPoint(-11F, 8F, 0F);
    Shape4.setTextureSize(256, 128);
    Shape4.mirror = true;
    setRotation(Shape4, 0F, 0F, 0F);
    Shape5 = new ModelRenderer(this, 82, 34);
    Shape5.addBox(-1F, -14F, -10F, 2, 28, 20);
    Shape5.setRotationPoint(11F, 8F, 0F);
    Shape5.setTextureSize(256, 128);
    Shape5.mirror = true;
    setRotation(Shape5, 0F, 0F, 0F);
    Shape6 = new ModelRenderer(this, 142, 0);
    Shape6.addBox(-16F, -1F, -11F, 32, 2, 16);
    Shape6.setRotationPoint(0F, -7F, -5F);
    Shape6.setTextureSize(256, 128);
    Shape6.mirror = true;
    setRotation(Shape6, 0F, 0F, 0F);
    Shape7 = new ModelRenderer(this, 142, 0);
    Shape7.addBox(-16F, -1F, -11F, 32, 2, 16);
    Shape7.setRotationPoint(0F, -7F, 11F);
    Shape7.setTextureSize(256, 128);
    Shape7.mirror = true;
    setRotation(Shape7, 0F, 0F, 0F);
    Shape8 = new ModelRenderer(this, 126, 0);
    Shape8.addBox(-2F, 0F, -2F, 4, 62, 4);
    Shape8.setRotationPoint(0F, -64F, 0F);
    Shape8.setTextureSize(256, 128);
    Shape8.mirror = true;
    setRotation(Shape8, 0F, 0F, 0F);
    Shape9 = new ModelRenderer(this, 0, 124);
    Shape9.addBox(-1F, -1F, -1F, 16, 2, 2);
    Shape9.setRotationPoint(0F, -3F, 0F);
    Shape9.setTextureSize(256, 128);
    Shape9.mirror = true;
    setRotation(Shape9, 0F, 0.7853982F, 0F);
    Shape10 = new ModelRenderer(this, 0, 124);
    Shape10.addBox(-1F, -1F, -1F, 16, 2, 2);
    Shape10.setRotationPoint(0F, -3F, 0F);
    Shape10.setTextureSize(256, 128);
    Shape10.mirror = true;
    setRotation(Shape10, 0F, -0.7853982F, 0F);
    Shape11 = new ModelRenderer(this, 0, 124);
    Shape11.addBox(-1F, -1F, -1F, 16, 2, 2);
    Shape11.setRotationPoint(0F, -3F, 0F);
    Shape11.setTextureSize(256, 128);
    Shape11.mirror = true;
    setRotation(Shape11, 0F, 2.356194F, 0F);
    Shape12 = new ModelRenderer(this, 0, 124);
    Shape12.addBox(-1F, -1F, -1F, 16, 2, 2);
    Shape12.setRotationPoint(0F, -3F, 0F);
    Shape12.setTextureSize(256, 128);
    Shape12.mirror = true;
    setRotation(Shape12, 0F, -2.356194F, 0F);
    Shape13 = new ModelRenderer(this, 0, 64);
    Shape13.addBox(-10F, -2F, -10F, 20, 4, 20);
    Shape13.setRotationPoint(0F, -21F, 0F);
    Shape13.setTextureSize(256, 128);
    Shape13.mirror = true;
    setRotation(Shape13, 0F, 0F, 0F);
    Shape14 = new ModelRenderer(this, 0, 88);
    Shape14.addBox(-8F, -2F, -8F, 16, 4, 16);
    Shape14.setRotationPoint(0F, -32F, 0F);
    Shape14.setTextureSize(256, 128);
    Shape14.mirror = true;
    setRotation(Shape14, 0F, 0F, 0F);
    Shape15 = new ModelRenderer(this, 0, 108);
    Shape15.addBox(-6F, -2F, -6F, 12, 4, 12);
    Shape15.setRotationPoint(0F, -42F, 0F);
    Shape15.setTextureSize(256, 128);
    Shape15.mirror = true;
    setRotation(Shape15, 0F, 0F, 0F);
    Shape16 = new ModelRenderer(this, 68, 108);
    Shape16.addBox(-4F, -2F, -4F, 8, 4, 8);
    Shape16.setRotationPoint(0F, -52F, 0F);
    Shape16.setTextureSize(256, 128);
    Shape16.mirror = true;
    setRotation(Shape16, 0F, 0F, 0F);
    Shape17 = new ModelRenderer(this, 36, 108);
    Shape17.addBox(-4F, -42F, -4F, 8, 8, 8);
    Shape17.setRotationPoint(0F, -30F, 0F);
    Shape17.setTextureSize(256, 128);
    Shape17.mirror = true;
    setRotation(Shape17, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  public void renderBlockBox(float f5) {
	  	Shape1.render(f5);
	  	Shape2.render(f5);
	  	Shape3.render(f5);
	  	Shape4.render(f5);
	  	Shape5.render(f5);
  }
  
  public void renderBlockDoors(float f5) {
	    Shape6.render(f5);
	    Shape7.render(f5);	  
  }
  
  /*
   * 8 - rod
   * 9,10,11,12 - base
   * 13 - coil 1
   * 14 - coil 2
   * 15 - coil 3
   * 16 - coil 4
   * 17 - cap
   */
  public void renderBlockCoil(float f5) {
	  	Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape11.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape15.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);	  
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}