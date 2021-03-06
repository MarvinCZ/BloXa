package cz.youngdevelopers.bloxa.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiner extends ModelBase {
    private ModelRenderer box1;

    public ModelMiner() {
        textureHeight = 28;
        textureWidth  = 56;

        box1 = new ModelRenderer(this, 0, 0);
        box1.addBox(-7f, 9f, -7f, 14, 14, 14);
        box1.setTextureOffset(0, 0);
        box1.setTextureSize(textureWidth, textureHeight);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        box1.renderWithRotation(scale);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
