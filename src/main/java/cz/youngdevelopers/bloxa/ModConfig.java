package cz.youngdevelopers.bloxa;

import net.minecraftforge.common.config.Config;

@Config(modid = Bloxa.MODID)
public class ModConfig {
    @Config.Comment("Redis endpoind")
    public static String redisEndpoint = "localhost";

    @Config.Comment("Redis port")
    public static int redisPort = 6379;
}
