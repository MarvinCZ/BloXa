package cz.youngdevelopers.bloxa.proxy;

import cz.youngdevelopers.bloxa.util.ClientRegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {
        super.onPreInit(event);
        ClientRegistryHandler.preInitRegistries();
        ClientRegistryHandler.initRegistries();
    }

    @Override
    public void onInit(FMLInitializationEvent event) {
        super.onInit(event);
        ClientRegistryHandler.initRegistries();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        ClientRegistryHandler.postInitRegistries();
    }

}
