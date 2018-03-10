package cz.youngdevelopers.bloxa;

import cz.youngdevelopers.bloxa.proxy.CommonProxy;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Bloxa.MODID, name = Bloxa.NAME, version = Bloxa.VERSION)
public class Bloxa {
    @Mod.Instance
    public static Bloxa instance;

    public static final String MODID = "bloxa";
    public static final String NAME = "BloXa";
    public static final String VERSION = "0.0.1";

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.onPreInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        proxy.onInit(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
