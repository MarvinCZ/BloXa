package cz.youngdevelopers.bloxa.block;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    @GameRegistry.ObjectHolder("bloxa:a_output")
    public static BlockAOutput blockAOutput = new BlockAOutput();

    public static void initModels() {
        blockAOutput.initModel();
    }
}
