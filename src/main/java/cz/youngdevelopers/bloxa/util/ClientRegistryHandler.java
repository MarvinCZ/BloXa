package cz.youngdevelopers.bloxa.util;

import cz.youngdevelopers.bloxa.entity.render.handlers.RenderHandler;
import cz.youngdevelopers.bloxa.init.EntityInit;

public class ClientRegistryHandler {
    public static void preInitRegistries() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    public static void initRegistries()
    {

    }

    public static void postInitRegistries()
    {

    }

}
