package cz.youngdevelopers.bloxa.Worker;

import cz.youngdevelopers.bloxa.ModConfig;
import cz.youngdevelopers.bloxa.controller.BlockManager;
import cz.youngdevelopers.bloxa.controller.MinerManager;
import net.minecraft.server.MinecraftServer;
import redis.clients.jedis.Jedis;

import java.net.SocketTimeoutException;

public class QueueWorker {
    private static QueueWorker instance = null;

    private Jedis redis;

    private QueueWorker()
    {
        redis = new Jedis(ModConfig.redisEndpoint, ModConfig.redisPort);
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
            if (parts[0].equals("mine")) {
                int dir = 3;
                switch (parts[2]) {
                    case "north":
                        dir = 2;
                        break;
                    case "south":
                        dir = 0;
                        break;
                    case "east":
                        dir = 1;
                        break;
                    case "west":
                        dir = 3;
                        break;
                }
                int count = Integer.parseInt(parts[3]);
                int mine = 0;
                switch (parts[4]) {
                    case "normal":
                        mine = 1;
                        break;
                    case "wide":
                        dir = 2;
                        break;
                }
                MinerManager.getInstance().setMine(dir, count, mine);
            }
            if (parts[0].equals("stop")) {
                MinerManager.getInstance().stop();
            }
            if (parts[0].equals("blockon")) {
                BlockManager.getInstance().setState(true);
            }
            if (parts[0].equals("blockoff")) {
                BlockManager.getInstance().setState(false);
            }
            System.out.println(job);
        }
    }
}
