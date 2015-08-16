package animatronics.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMoonPrismLens extends ModelBase
{
  //fields
    ModelRenderer Shape8;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape5;
    ModelRenderer Shape4;
    ModelRenderer Shape3;
    ModelRenderer Shape2;
    ModelRenderer Shape1;
    ModelRenderer Lens;
  
  public ModelMoonPrismLens()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape8 = new ModelRenderer(this, 36, 31);
      Shape8.addBox(-1F, -1F, -0.4F, 2, 2, 13);
      Shape8.setRotationPoint(-7.4F, 23F, 16F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, -2.373648F, 0F);
      Shape7 = new ModelRenderer(this, 36, 31);
      Shape7.addBox(-1F, -1F, -0.4F, 2, 2, 13);
      Shape7.setRotationPoint(-7.4F, 23F, -16F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, -0.7853982F, 0F);
      Shape6 = new ModelRenderer(this, 36, 31);
      Shape6.addBox(-1F, -1F, -0.4F, 2, 2, 13);
      Shape6.setRotationPoint(7.4F, 23F, 16F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 2.373648F, 0F);
      Shape5 = new ModelRenderer(this, 36, 31);
      Shape5.addBox(-1F, -1F, -0.4F, 2, 2, 13);
      Shape5.setRotationPoint(7.4F, 23F, -16F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0.7853982F, 0F);
      Shape4 = new ModelRenderer(this, 0, 49);
      Shape4.addBox(0F, -1F, -1F, 16, 2, 2);
      Shape4.setRotationPoint(-8F, 23F, -16F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 49);
      Shape3.addBox(0F, -1F, -1F, 16, 2, 2);
      Shape3.setRotationPoint(-8F, 23F, 16F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 31);
      Shape2.addBox(-1F, -1F, 0F, 2, 2, 16);
      Shape2.setRotationPoint(16F, 23F, -8F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 31);
      Shape1.addBox(-1F, -1F, 0F, 2, 2, 16);
      Shape1.setRotationPoint(-16F, 23F, -8F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Lens = new ModelRenderer(this, 0, 0);
      Lens.addBox(0F, 0F, 0F, 30, 1, 30);
      Lens.setRotationPoint(-15F, 22.5F, -15F);
      Lens.setTextureSize(128, 64);
      Lens.mirror = true;
      setRotation(Lens, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    renderModel(f5);
  }
  
  public void renderModel(float f5) {
	Shape8.render(f5);
	Shape7.render(f5);
	Shape6.render(f5);
	Shape5.render(f5);
    Shape4.render(f5);
    Shape3.render(f5);
    Shape2.render(f5);
    Shape1.render(f5);
    Lens.render(f5);
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
