package cz.youngdevelopers.bloxa.entity.render.handlers;

import cz.youngdevelopers.bloxa.entity.EntityMiner;
import cz.youngdevelopers.bloxa.entity.render.RenderMiner;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMiner.class, RenderMiner::new);
    }
}
