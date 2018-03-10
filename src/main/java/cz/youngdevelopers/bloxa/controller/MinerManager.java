package cz.youngdevelopers.bloxa.controller;


import cz.youngdevelopers.bloxa.entity.EntityMiner;

import java.util.ArrayList;
import java.util.HashSet;

public class MinerManager {
    private static MinerManager instance;

    private HashSet<EntityMiner> miners = new HashSet<>();

    private MinerManager() {}

    public static MinerManager getInstance()
    {
        if (instance == null) {
            instance = new MinerManager();
        }
        return instance;
    }

    public synchronized void addMiner(EntityMiner miner)
    {
        miners.add(miner);
        System.out.println("Miner Added");
    }

    public synchronized void setMine(int dir, int count, int mine)
    {
        for (EntityMiner m : miners) {
            m.mine(dir, count, mine);
        }
    }

    public synchronized void stop()
    {
        for (EntityMiner m : miners) {
            m.count = 0;
        }
    }

    public synchronized void tick()
    {
        for (EntityMiner m : miners) {
            m.tick();
        }
    }

    public synchronized void removeMiner(EntityMiner entity) {
        miners.remove(entity);
    }
}
