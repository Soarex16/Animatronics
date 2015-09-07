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
  
  public ModelLightingAbsorber()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-8F, 0F, -8F, 16, 1, 16);
      Shape1.setRotationPoint(0F, 23F, 0F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 17);
      Shape2.addBox(0F, 0F, 0F, 12, 14, 1);
      Shape2.setRotationPoint(-6F, 9F, 5F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 17);
      Shape3.addBox(0F, 0F, 0F, 12, 14, 1);
      Shape3.setRotationPoint(-6F, 9F, -6F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 26, 17);
      Shape4.addBox(0F, 0F, 0F, 1, 14, 10);
      Shape4.setRotationPoint(5F, 9F, -5F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 26, 17);
      Shape5.addBox(0F, 0F, 0F, 1, 14, 10);
      Shape5.setRotationPoint(-6F, 9F, -5F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 41);
      Shape6.addBox(0F, 0F, 0F, 16, 1, 8);
      Shape6.setRotationPoint(-8F, 8F, -8F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 50);
      Shape7.addBox(0F, 0F, 0F, 16, 1, 8);
      Shape7.setRotationPoint(-8F, 8F, 0F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 64, 0);
      Shape8.addBox(0F, 0F, 0F, 2, 20, 2);
      Shape8.setRotationPoint(-1F, -10F, -1F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 48, 22);
      Shape9.addBox(0F, 0F, 0F, 10, 2, 10);
      Shape9.setRotationPoint(-5F, 3F, -5F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 48, 34);
      Shape10.addBox(0F, 0F, 0F, 8, 2, 8);
      Shape10.setRotationPoint(-4F, -2F, -4F);
      Shape10.setTextureSize(128, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 48, 44);
      Shape11.addBox(0F, 0F, 0F, 6, 2, 6);
      Shape11.setRotationPoint(-3F, -6.5F, -3F);
      Shape11.setTextureSize(128, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 48, 52);
      Shape12.addBox(0F, 0F, 0F, 4, 2, 4);
      Shape12.setRotationPoint(-2F, -10.5F, -2F);
      Shape12.setTextureSize(128, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 32);
      Shape13.addBox(-0.5F, 0F, 0F, 1, 1, 8);
      Shape13.setRotationPoint(-0.5F, 9F, -0.5F);
      Shape13.setTextureSize(128, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0.7853982F, 0F);
      Shape14 = new ModelRenderer(this, 0, 32);
      Shape14.addBox(-0.5F, 0F, 0F, 1, 1, 8);
      Shape14.setRotationPoint(0.5F, 9F, -0.5F);
      Shape14.setTextureSize(128, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, -0.7853982F, 0F);
      Shape15 = new ModelRenderer(this, 0, 32);
      Shape15.addBox(-0.5F, 0F, 0F, 1, 1, 8);
      Shape15.setRotationPoint(-0.5F, 9F, 0.5F);
      Shape15.setTextureSize(128, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 2.356194F, 0F);
      Shape16 = new ModelRenderer(this, 0, 32);
      Shape16.addBox(-0.5F, 0F, 0F, 1, 1, 8);
      Shape16.setRotationPoint(0.5F, 9F, 0.5F);
      Shape16.setTextureSize(128, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, -2.356194F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  /*
   * 1,2,3,4,5 - box
   * 6,7 - cover
   * 8,9,10,11,12,13,14,15,16 - coil 
   */
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
