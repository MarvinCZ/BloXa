package cz.youngdevelopers.bloxa.entity;

import cz.youngdevelopers.bloxa.controller.MinerManager;
import net.minecraft.entity.EntityFlying;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class EntityMiner extends EntityFlying {
     private static int[][][] MINE_DIRS = new int[][][]{
             {
                     {0,0}
             },
             {
                     {-1, -1}, {-1, 0}, {-1, 1},
                     {0, 0}, {0, 1}, {0, -1},
                     {1, -1}, {1, 0}, {1, 1},
             },
             {
                     {-2, -2}, {-2, -1}, {-2, 0}, {-2, 1}, {-2, 2},
                     {-1, -2}, {-1, -1}, {-1, 0}, {-1, 1}, {-1, 2},
                     {0, -2}, {0, 0}, {0, 1}, {0, -1}, {0, 2},
                     {1, -2}, {1, 0}, {1, 1}, {1, -1}, {1, 2},
                     {2, -2}, {2, 0}, {2, 1}, {2, -1}, {2, 2},
             },
     };
    public int count = 0;
    public int dir = 0;
    public int mine = 1;

    private Vec3d start;

    public EntityMiner(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(0.9f, 0.9f);
        MinerManager.getInstance().addMiner(this);
    }

    @Override
    protected void initEntityAI() {
        this.setNoAI(true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    public void tick() {
        if (!this.isEntityAlive()) {
            MinerManager.getInstance().removeMiner(this);
            return;
        }
        if (start == null) {
            return;
        }
        Vec3d p = this.getPositionVector();
        double d = Math.abs(start.x - p.x);
        d += Math.abs(start.y - p.y);
        d += Math.abs(start.z - p.z);
        if (d >= count) {
            count = 0;
            start = null;
            return;
        }
        int x = getPosition().getX();
        int y = getPosition().getY();
        int z = getPosition().getZ();

        Vec3d v = getPositionVector();

        for (int i = 0; i < MINE_DIRS[mine].length; i++) {
            int d1 = MINE_DIRS[mine][i][0];
            int d2 = MINE_DIRS[mine][i][1];
            if (dir == 0) {
                this.getEntityWorld().destroyBlock(new BlockPos(x+d1, y+d2, z + 1), false);
            }
            if (dir == 2) {
                this.getEntityWorld().destroyBlock(new BlockPos(x+d1, y+d2, z - 1), false);
            }
            if (dir == 1) {
                this.getEntityWorld().destroyBlock(new BlockPos(x+1, y+d1, z+d2), false);
            }
            if (dir == 3) {
                this.getEntityWorld().destroyBlock(new BlockPos(x-1, y+d1, z+d2), false);
            }
            if (dir == 4) {
                this.getEntityWorld().destroyBlock(new BlockPos(x+d1, y+1, z+d2), false);
            }
            if (dir == 5) {
                this.getEntityWorld().destroyBlock(new BlockPos(x+d1, y-1, z+d2), false);
            }
        }

        if (dir == 0) {
            this.setPosition(v.x, v.y, v.z + 0.06F);
            if (v.z%1 == 0) count--;
        }
        if (dir == 2) {
            this.setPosition(v.x, v.y, v.z - 0.06F);
            if (v.z%1 == 0) count--;
        }
        if (dir == 1) {
            this.setPosition(v.x + 0.06F, v.y, v.z);
            if (v.x%1 == 0) count--;
        }
        if (dir == 3) {
            this.setPosition(v.x - 0.06F, v.y, v.z);
            if (v.x%1 == 0) count--;
        }
        if (dir == 4) {
            this.setPosition(v.x, v.y + 0.06F, v.z);
            if (v.x%1 == 0) count--;
        }
        if (dir == 5) {
            this.setPosition(v.x, v.y - 0.06F, v.z);
            if (v.x%1 == 0) count--;
        }
    }

    public void mine(int dir, int count, int size)
    {
        if (dir >= 0 && dir <= 5) {
            this.dir = dir;
        }

        if (count > 0) {
            this.count = count;
        }

        if (size >= 0 && size <= 2) {
            this.mine = size;
        }

        start = this.getPositionVector();
    }
}
