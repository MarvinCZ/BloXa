package cz.youngdevelopers.bloxa.EventHandlers;

import cz.youngdevelopers.bloxa.block.BlockAOutput;
import cz.youngdevelopers.bloxa.block.ModBlocks;
import cz.youngdevelopers.bloxa.item.ModItems;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryEventHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockAOutput());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS);
        event.getRegistry().register(new ItemBlock(ModBlocks.blockAOutput).setRegistryName(ModBlocks.blockAOutput.getRegistryName()));
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        ModBlocks.initModels();
        ModItems.initModels();
    }
}
