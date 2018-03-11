package cz.youngdevelopers.bloxa.block;

import cz.youngdevelopers.bloxa.entity.AOutTileEntity;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static sun.misc.VM.getState;

public class BlockAOutput extends Block implements ITileEntityProvider {
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    public BlockAOutput() {
        super(Material.ROCK);
        String name = "a_output";
        this.setHardness(4f);
        this.setHarvestLevel("pickaxe", 1);
        this.setRegistryName(name);
        this.setUnlocalizedName(Reference.MODID + '.' + name);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public boolean canProvidePower(IBlockState state)
    {
        return true;
    }

    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        TileEntity te = blockAccess.getTileEntity(pos);
        if (te != null && te instanceof AOutTileEntity) {
            return ((AOutTileEntity)te).isActivated() ? 15 : 0;
        }
        return 0;
    }

    @Override
    public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        TileEntity te = blockAccess.getTileEntity(pos);
        if (te != null && te instanceof AOutTileEntity) {
            return ((AOutTileEntity)te).isActivated() ? 15 : 0;
        }
        return 0;
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        if (!worldIn.isRemote) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te != null && te instanceof AOutTileEntity) {
                AOutTileEntity e = (AOutTileEntity) te;
                e.setActivated(!e.isActivated());
            }
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);

        System.out.println("x");
        worldIn.markBlockRangeForRenderUpdate(pos, pos);
        for (EnumFacing enumfacing : EnumFacing.values())
        {
            worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, true);
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AOutTileEntity();
    }
}
