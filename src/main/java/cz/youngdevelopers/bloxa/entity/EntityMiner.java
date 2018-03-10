package cz.youngdevelopers.bloxa.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityMiner extends EntityAnimal {
    public EntityMiner(World world) {
        super(world);
        this.preventEntitySpawning = true;
        this.setSize(0.9f, 0.9f);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityMiner(world);
    }

    @Override
    protected void initEntityAI() {
        this.setNoAI(true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }
}
