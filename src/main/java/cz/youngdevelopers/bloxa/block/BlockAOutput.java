package cz.youngdevelopers.bloxa.block;

import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAOutput extends Block {

    public BlockAOutput() {
        super(Material.ROCK);
        String name = "a_output";
        this.setRegistryName(name);
        this.setUnlocalizedName(Reference.MODID + '.' + name);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
