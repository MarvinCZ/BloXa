package cz.youngdevelopers.bloxa.proxy;

import cz.youngdevelopers.bloxa.EventHandlers.LivingDeathEventHandler;
import cz.youngdevelopers.bloxa.EventHandlers.RegistryEventHandler;
import cz.youngdevelopers.bloxa.EventHandlers.ServerTickEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void onPreInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ServerTickEventHandler.class);
        MinecraftForge.EVENT_BUS.register(LivingDeathEventHandler.class);
        MinecraftForge.EVENT_BUS.register(RegistryEventHandler.class);
    }

    public void onInit(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
