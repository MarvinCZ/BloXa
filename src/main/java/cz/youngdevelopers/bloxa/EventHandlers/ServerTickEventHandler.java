package cz.youngdevelopers.bloxa.EventHandlers;

import cz.youngdevelopers.bloxa.Worker.QueueWorker;
import cz.youngdevelopers.bloxa.controller.MinerManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ServerTickEventHandler {
    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        if (event.side.isServer()) {
            QueueWorker.getInstance().work();

            MinerManager.getInstance().tick();
        }
    }
}
