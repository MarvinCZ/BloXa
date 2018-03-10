package cz.youngdevelopers.bloxa.Worker;

import cz.youngdevelopers.bloxa.ModConfig;
import cz.youngdevelopers.bloxa.controller.MinerManager;
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
            String[] parts = job.split(" ");
            if (parts[0].equals("miner")) {
                int dir = Integer.parseInt(parts[1]);
                int count = Integer.parseInt(parts[2]);
                int mine = Integer.parseInt(parts[3]);
                MinerManager.getInstance().setMine(dir, count, mine);
            }
            if (parts[0].equals("stop")) {
                MinerManager.getInstance().stop();
            }
            System.out.println(job);
        }
    }
}
