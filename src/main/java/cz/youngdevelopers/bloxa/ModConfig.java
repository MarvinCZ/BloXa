package cz.youngdevelopers.bloxa;

import net.minecraftforge.common.config.Config;

@Config(modid = Main.MODID)
public class ModConfig {
    @Config.Comment("Redis endpoind")
    public static String redisEndpoint = "localhost";
}
