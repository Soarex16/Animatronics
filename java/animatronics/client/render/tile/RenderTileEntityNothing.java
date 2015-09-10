package animatronics.client.render.tile;

import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import animatronics.utils.handler.ClientTickHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityNothing extends TileEntitySpecialRenderer {

	FloatBuffer fBuffer;
    private boolean inrange;
    private ResourceLocation t1;
    private ResourceLocation t2;
    private ResourceLocation t3;
    
    public RenderTileEntityNothing() {
        t1 = new ResourceLocation("animatronics:textures/misc/end_sky.png");
        t2 = new ResourceLocation("animatronics:textures/misc/particlefield.png");
        t3 = new ResourceLocation("animatronics:textures/misc/particlefield32.png");
        fBuffer = GLAllocation.createDirectFloatBuffer(16);
    }
    
    public void renderTileEntityAt(final TileEntity te, final double x, final double y, final double z, final float f) {
        this.inrange = (Minecraft.getMinecraft().renderViewEntity.getDistanceSq(te.xCoord + 0.5, te.yCoord + 0.5, te.zCoord + 0.5) < 512.0);
        GL11.glDisable(2912);
        if (!te.getWorldObj().getBlock(te.xCoord, te.yCoord + 1, te.zCoord).isOpaqueCube()) {
            this.drawPlaneYNeg(x, y, z, f);
        }
        if (!te.getWorldObj().getBlock(te.xCoord, te.yCoord - 1, te.zCoord).isOpaqueCube()) {
            this.drawPlaneYPos(x, y, z, f);
        }
        if (!te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord - 1).isOpaqueCube()) {
            this.drawPlaneZPos(x, y, z, f);
        }
        if (!te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord + 1).isOpaqueCube()) {
            this.drawPlaneZNeg(x, y, z, f);
        }
        if (!te.getWorldObj().getBlock(te.xCoord - 1, te.yCoord, te.zCoord).isOpaqueCube()) {
            this.drawPlaneXPos(x, y, z, f);
        }
        if (!te.getWorldObj().getBlock(te.xCoord + 1, te.yCoord, te.zCoord).isOpaqueCube()) {
            this.drawPlaneXNeg(x, y, z, f);
        }
        GL11.glEnable(2912);
    }
    
    public void drawPlaneYPos(final double x, final double y, final double z, final float f) {
        final float px = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float py = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float pz = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 0.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f2 = 16 - i;
                float f3 = 0.0625f;
                float f4 = 1.0f / (f2 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f4 = 0.1f;
                    f2 = 65.0f;
                    f3 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f3 = 0.5f;
                }
                final float f5 = (float)(y + offset);
                final float f6 = f5 - ActiveRenderInfo.objectY;
                final float f7 = f5 + f2 - ActiveRenderInfo.objectY;
                float f8 = f6 / f7;
                f8 += (float)(y + offset);
                GL11.glTranslatef(px, f8, pz);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-px, -pz, -py);
                GL11.glTranslatef(ActiveRenderInfo.objectX * f2 / f6, ActiveRenderInfo.objectZ * f2 / f6, -py);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f8 = random.nextFloat() * 0.5f + 0.1f;
                float f9 = random.nextFloat() * 0.5f + 0.4f;
                float f10 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f9 = (f8 = (f10 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f8 * f4, f9 * f4, f10 * f4, 1.0f);
                tessellator.addVertex(x, y + offset, z + 1.0);
                tessellator.addVertex(x, y + offset, z);
                tessellator.addVertex(x + 1.0, y + offset, z);
                tessellator.addVertex(x + 1.0, y + offset, z + 1.0);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x, y + offset, z + 1.0, 1.0, 1.0);
            tessellator2.addVertexWithUV(x, y + offset, z, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + offset, z, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + offset, z + 1.0, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    public void drawPlaneYNeg(final double x, final double y, final double z, final float f) {
        final float f2 = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float f3 = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float f4 = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 1.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f5 = 16 - i;
                float f6 = 0.0625f;
                float f7 = 1.0f / (f5 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f7 = 0.1f;
                    f5 = 65.0f;
                    f6 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f6 = 0.5f;
                }
                final float f8 = (float)(-(y + offset));
                final float f9 = f8 + ActiveRenderInfo.objectY;
                final float f10 = f8 + f5 + ActiveRenderInfo.objectY;
                float f11 = f9 / f10;
                f11 += (float)(y + offset);
                GL11.glTranslatef(f2, f11, f4);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f6, f6, f6);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-f2, -f4, -f3);
                GL11.glTranslatef(ActiveRenderInfo.objectX * f5 / f9, ActiveRenderInfo.objectZ * f5 / f9, -f3);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f11 = random.nextFloat() * 0.5f + 0.1f;
                float f12 = random.nextFloat() * 0.5f + 0.4f;
                float f13 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f12 = (f11 = (f13 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0f);
                tessellator.addVertex(x, y + offset, z);
                tessellator.addVertex(x, y + offset, z + 1.0);
                tessellator.addVertex(x + 1.0, y + offset, z + 1.0);
                tessellator.addVertex(x + 1.0, y + offset, z);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x, y + offset, z, 1.0, 1.0);
            tessellator2.addVertexWithUV(x, y + offset, z + 1.0, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + offset, z + 1.0, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + offset, z, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    public void drawPlaneZNeg(final double x, final double y, final double z, final float f) {
        final float px = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float py = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float pz = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 1.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f2 = 16 - i;
                float f3 = 0.0625f;
                float f4 = 1.0f / (f2 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f4 = 0.1f;
                    f2 = 65.0f;
                    f3 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f3 = 0.5f;
                }
                final float f5 = (float)(-(z + offset));
                final float f6 = f5 + ActiveRenderInfo.objectZ;
                final float f7 = f5 + f2 + ActiveRenderInfo.objectZ;
                float f8 = f6 / f7;
                f8 += (float)(z + offset);
                GL11.glTranslatef(px, py, f8);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-px, -py, -pz);
                GL11.glTranslatef(ActiveRenderInfo.objectX * f2 / f6, ActiveRenderInfo.objectY * f2 / f6, -pz);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f8 = random.nextFloat() * 0.5f + 0.1f;
                float f9 = random.nextFloat() * 0.5f + 0.4f;
                float f10 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f9 = (f8 = (f10 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f8 * f4, f9 * f4, f10 * f4, 1.0f);
                tessellator.addVertex(x, y + 1.0, z + offset);
                tessellator.addVertex(x, y, z + offset);
                tessellator.addVertex(x + 1.0, y, z + offset);
                tessellator.addVertex(x + 1.0, y + 1.0, z + offset);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x, y + 1.0, z + offset, 1.0, 1.0);
            tessellator2.addVertexWithUV(x, y, z + offset, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y, z + offset, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + 1.0, z + offset, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    public void drawPlaneZPos(final double x, final double y, final double z, final float f) {
        final float px = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float py = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float pz = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 0.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f2 = 16 - i;
                float f3 = 0.0625f;
                float f4 = 1.0f / (f2 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f4 = 0.1f;
                    f2 = 65.0f;
                    f3 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f3 = 0.5f;
                }
                final float f5 = (float)(z + offset);
                final float f6 = f5 - ActiveRenderInfo.objectZ;
                final float f7 = f5 + f2 - ActiveRenderInfo.objectZ;
                float f8 = f6 / f7;
                f8 += (float)(z + offset);
                GL11.glTranslatef(px, py, f8);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-px, -py, -pz);
                GL11.glTranslatef(ActiveRenderInfo.objectX * f2 / f6, ActiveRenderInfo.objectY * f2 / f6, -pz);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f8 = random.nextFloat() * 0.5f + 0.1f;
                float f9 = random.nextFloat() * 0.5f + 0.4f;
                float f10 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f9 = (f8 = (f10 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f8 * f4, f9 * f4, f10 * f4, 1.0f);
                tessellator.addVertex(x, y, z + offset);
                tessellator.addVertex(x, y + 1.0, z + offset);
                tessellator.addVertex(x + 1.0, y + 1.0, z + offset);
                tessellator.addVertex(x + 1.0, y, z + offset);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x, y, z + offset, 1.0, 1.0);
            tessellator2.addVertexWithUV(x, y + 1.0, z + offset, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y + 1.0, z + offset, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + 1.0, y, z + offset, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    public void drawPlaneXNeg(final double x, final double y, final double z, final float f) {
        final float px = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float py = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float pz = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 1.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f2 = 16 - i;
                float f3 = 0.0625f;
                float f4 = 1.0f / (f2 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f4 = 0.1f;
                    f2 = 65.0f;
                    f3 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f3 = 0.5f;
                }
                final float f5 = (float)(-(x + offset));
                final float f6 = f5 + ActiveRenderInfo.objectX;
                final float f7 = f5 + f2 + ActiveRenderInfo.objectX;
                float f8 = f6 / f7;
                f8 += (float)(x + offset);
                GL11.glTranslatef(f8, py, pz);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-pz, -py, -px);
                GL11.glTranslatef(ActiveRenderInfo.objectZ * f2 / f6, ActiveRenderInfo.objectY * f2 / f6, -px);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f8 = random.nextFloat() * 0.5f + 0.1f;
                float f9 = random.nextFloat() * 0.5f + 0.4f;
                float f10 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f9 = (f8 = (f10 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f8 * f4, f9 * f4, f10 * f4, 1.0f);
                tessellator.addVertex(x + offset, y + 1.0, z);
                tessellator.addVertex(x + offset, y + 1.0, z + 1.0);
                tessellator.addVertex(x + offset, y, z + 1.0);
                tessellator.addVertex(x + offset, y, z);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x + offset, y + 1.0, z, 1.0, 1.0);
            tessellator2.addVertexWithUV(x + offset, y + 1.0, z + 1.0, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + offset, y, z + 1.0, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + offset, y, z, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    public void drawPlaneXPos(final double x, final double y, final double z, final float f) {
        final float px = (float)TileEntityRendererDispatcher.staticPlayerX;
        final float py = (float)TileEntityRendererDispatcher.staticPlayerY;
        final float pz = (float)TileEntityRendererDispatcher.staticPlayerZ;
        GL11.glDisable(2896);
        final Random random = new Random(31100L);
        final float offset = 0.0f;
        if (this.inrange) {
            for (int i = 0; i < 16; ++i) {
                GL11.glPushMatrix();
                float f2 = 16 - i;
                float f3 = 0.0625f;
                float f4 = 1.0f / (f2 + 1.0f);
                if (i == 0) {
                    bindTexture(this.t1);
                    f4 = 0.1f;
                    f2 = 65.0f;
                    f3 = 0.125f;
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                }
                if (i == 1) {
                    bindTexture(this.t2);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(1, 1);
                    f3 = 0.5f;
                }
                final float f5 = (float)(x + offset);
                final float f6 = f5 - ActiveRenderInfo.objectX;
                final float f7 = f5 + f2 - ActiveRenderInfo.objectX;
                float f8 = f6 / f7;
                f8 += (float)(x + offset);
                GL11.glTranslatef(f8, py, pz);
                GL11.glTexGeni(8192, 9472, 9217);
                GL11.glTexGeni(8193, 9472, 9217);
                GL11.glTexGeni(8194, 9472, 9217);
                GL11.glTexGeni(8195, 9472, 9216);
                GL11.glTexGen(8193, 9473, this.calcFloatBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GL11.glTexGen(8192, 9473, this.calcFloatBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GL11.glTexGen(8194, 9473, this.calcFloatBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                GL11.glTexGen(8195, 9474, this.calcFloatBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GL11.glEnable(3168);
                GL11.glEnable(3169);
                GL11.glEnable(3170);
                GL11.glEnable(3171);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                GL11.glLoadIdentity();
                GL11.glTranslatef(0.0f, System.currentTimeMillis() % 700000L / 250000.0f, 0.0f);
                GL11.glScalef(f3, f3, f3);
                GL11.glTranslatef(0.5f, 0.5f, 0.0f);
                GL11.glRotatef((i * i * 4321 + i * 9) * 2.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.5f, -0.5f, 0.0f);
                GL11.glTranslatef(-pz, -py, -px);
                GL11.glTranslatef(ActiveRenderInfo.objectZ * f2 / f6, ActiveRenderInfo.objectY * f2 / f6, -px);
                final Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                f8 = random.nextFloat() * 0.5f + 0.1f;
                float f9 = random.nextFloat() * 0.5f + 0.4f;
                float f10 = random.nextFloat() * 0.5f + 0.5f;
                if (i == 0) {
                    f9 = (f8 = (f10 = 1.0f));
                }
                tessellator.setBrightness(180);
                tessellator.setColorRGBA_F(f8 * f4, f9 * f4, f10 * f4, 1.0f);
                tessellator.addVertex(x + offset, y, z);
                tessellator.addVertex(x + offset, y, z + 1.0);
                tessellator.addVertex(x + offset, y + 1.0, z + 1.0);
                tessellator.addVertex(x + offset, y + 1.0, z);
                tessellator.draw();
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
            }
        }
        else {
            GL11.glPushMatrix();
            bindTexture(this.t3);
            final Tessellator tessellator2 = Tessellator.instance;
            tessellator2.startDrawingQuads();
            tessellator2.setBrightness(180);
            tessellator2.addVertexWithUV(x + offset, y, z, 1.0, 1.0);
            tessellator2.addVertexWithUV(x + offset, y, z + 1.0, 1.0, 0.0);
            tessellator2.addVertexWithUV(x + offset, y + 1.0, z + 1.0, 0.0, 0.0);
            tessellator2.addVertexWithUV(x + offset, y + 1.0, z, 0.0, 1.0);
            tessellator2.draw();
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }
    
    private FloatBuffer calcFloatBuffer(final float f, final float f1, final float f2, final float f3) {
        this.fBuffer.clear();
        this.fBuffer.put(f).put(f1).put(f2).put(f3);
        this.fBuffer.flip();
        return this.fBuffer;
    }
}
