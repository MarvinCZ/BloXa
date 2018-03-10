package cz.youngdevelopers.bloxa.entity.render;

import cz.youngdevelopers.bloxa.entity.EntityMiner;
import cz.youngdevelopers.bloxa.entity.model.ModelMiner;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;


public class RenderMiner extends RenderLiving<EntityMiner> {
    public static final ResourceLocation MINER_TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/miner.png");

    public RenderMiner(RenderManager manager) {
        super(manager, new ModelMiner(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMiner entity) {
        return MINER_TEXTURES;
    }

    @Override
    protected void applyRotations(EntityMiner entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
