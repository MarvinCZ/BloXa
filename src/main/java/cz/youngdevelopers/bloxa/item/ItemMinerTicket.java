package cz.youngdevelopers.bloxa.item;

import cz.youngdevelopers.bloxa.entity.EntityMiner;
import cz.youngdevelopers.bloxa.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMinerTicket extends Item {
    public ItemMinerTicket(String name) {
        this.setRegistryName(Reference.MODID, name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote && !playerIn.isCreative()) {
            System.out.println(playerIn.inventory.removeStackFromSlot(playerIn.inventory.currentItem));
            EntityMiner miner = new EntityMiner(worldIn);
            miner.setPosition(playerIn.posX, playerIn.posY, playerIn.posZ);
            worldIn.spawnEntity(miner);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}