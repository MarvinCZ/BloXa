package cz.youngdevelopers.bloxa.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiner extends ModelBase {
    private ModelRenderer box1;

    public ModelMiner() {
        textureHeight = 32;
        textureWidth = 32;

        box1 = new ModelRenderer(this, 0, 0);
        box1.addBox(9f, 9f, 9f, 14, 14, 14);
        box1.setTextureSize(14, 14);
        setRotation(box1, 0f, 0f, 0f);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        box1.render(scale);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.box1.rotateAngleX = f3 / (180f / (float)Math.PI);
    }

    private void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
