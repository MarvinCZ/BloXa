package cz.youngdevelopers.bloxa.init;

import cz.youngdevelopers.bloxa.Bloxa;
import cz.youngdevelopers.bloxa.entity.EntityMiner;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("Miner", EntityMiner.class, Reference.ENTITY_MINER, 16, 0, 255);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
         EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, "Miner", id, Bloxa.instance, range, 1, true, color1, color2);
    }
}
