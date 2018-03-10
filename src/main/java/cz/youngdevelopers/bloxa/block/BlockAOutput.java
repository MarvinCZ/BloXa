package cz.youngdevelopers.bloxa.block;

import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAOutput extends Block {
    public BlockAOutput() {
        super(Material.ROCK);
        String name = "a_output";
        this.setRegistryName(Reference.MODID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
