package cz.youngdevelopers.bloxa;

import cz.youngdevelopers.bloxa.EventHandlers.ServerTickEventHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;

@Mod(modid = BloxaMod.MODID, name = BloxaMod.NAME, version = BloxaMod.VERSION)
public class BloxaMod
{
    public static final String MODID = "bloxa";
    public static final String NAME = "BloXa";
    public static final String VERSION = "0.0.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Jedis jedis = new Jedis("localhost");
        jedis.set("mc-test", "test");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        MinecraftForge.EVENT_BUS.register(ServerTickEventHandler.class);
    }
}
