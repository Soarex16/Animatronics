package animatronica.test;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTest extends ModelBase
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

	public ModelTest()
	{
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 8, 1, 1);
		Shape1.setRotationPoint(-4F, 19F, -4F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(0F, 0F, 0F, 8, 1, 1);
		Shape2.setRotationPoint(-4F, 19F, 3F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 2);
		Shape3.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape3.setRotationPoint(-4F, 19F, -3F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 2);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape4.setRotationPoint(3F, 19F, -3F);
		Shape4.setTextureSize(32, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 2);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape5.setRotationPoint(-4F, 12F, -3F);
		Shape5.setTextureSize(32, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 2);
		Shape6.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape6.setRotationPoint(3F, 12F, -3F);
		Shape6.setTextureSize(32, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 8, 1, 1);
		Shape7.setRotationPoint(-4F, 12F, -4F);
		Shape7.setTextureSize(32, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, 0F, 8, 1, 1);
		Shape8.setRotationPoint(-4F, 12F, 3F);
		Shape8.setTextureSize(32, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 9);
		Shape9.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape9.setRotationPoint(3F, 13F, 3F);
		Shape9.setTextureSize(32, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 9);
		Shape10.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape10.setRotationPoint(-4F, 13F, 3F);
		Shape10.setTextureSize(32, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 9);
		Shape11.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape11.setRotationPoint(3F, 13F, -4F);
		Shape11.setTextureSize(32, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 9);
		Shape12.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape12.setRotationPoint(-4F, 13F, -4F);
		Shape12.setTextureSize(32, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		renderModel(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
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

