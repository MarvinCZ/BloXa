package cz.youngdevelopers.bloxa.controller;


import cz.youngdevelopers.bloxa.entity.AOutTileEntity;
import cz.youngdevelopers.bloxa.entity.EntityMiner;

import java.util.ArrayList;
import java.util.HashSet;

public class BlockManager {
    private static BlockManager instance;

    private ArrayList<AOutTileEntity> blocks = new ArrayList<>();

    private BlockManager() {}

    public static BlockManager getInstance()
    {
        if (instance == null) {
            instance = new BlockManager();
        }
        return instance;
    }

    public synchronized void addBlock(AOutTileEntity block)
    {
        blocks.add(block);
    }

    public synchronized void setState(boolean state)
    {
        for(AOutTileEntity e : blocks) {
            e.setActivated(state);
        }
    }

    public synchronized void removeBlock(AOutTileEntity entity) {
        blocks.remove(entity);
    }
}
