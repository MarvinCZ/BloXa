package cz.youngdevelopers.bloxa.Worker;

import cz.youngdevelopers.bloxa.ModConfig;
import net.minecraft.server.MinecraftServer;
import redis.clients.jedis.Jedis;

public class QueueWorker {
    private static QueueWorker instance = null;

    private Jedis redis;

    private QueueWorker()
    {
        redis = new Jedis(ModConfig.redisEndpoint);
    }

    public static QueueWorker getInstance()
    {
        if (instance == null) {
            instance = new QueueWorker();
        }

        return instance;
    }

    public void work()
    {
        while (redis.llen("que") > 0) {
            String job = redis.rpop("que");
            System.out.println(job);
        }
    }
}
