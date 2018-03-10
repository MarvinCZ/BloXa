package cz.youngdevelopers.bloxa;

import cz.youngdevelopers.bloxa.EventHandlers.ServerTickEventHandler;
import cz.youngdevelopers.bloxa.proxy.CommonProxy;
import cz.youngdevelopers.bloxa.util.Reference;
import cz.youngdevelopers.bloxa.util.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    @Mod.Instance
    public static Main instance;

    public static final String MODID = "bloxa";
    public static final String NAME = "BloXa";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistries();
        MinecraftForge.EVENT_BUS.register(ServerTickEventHandler.class);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistries();
    }
}
