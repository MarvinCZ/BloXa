package cz.youngdevelopers.bloxa.EventHandlers;

import cz.youngdevelopers.bloxa.controller.MinerManager;
import cz.youngdevelopers.bloxa.entity.EntityMiner;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingDeathEventHandler {

    @SubscribeEvent
    public static void entityDied(LivingDeathEvent event)
    {
        if (event.getEntity() instanceof EntityMiner) {
            MinerManager.getInstance().removeMiner((EntityMiner) event.getEntity());
        }
    }
}
