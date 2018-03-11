package cz.youngdevelopers.bloxa.entity;

import cz.youngdevelopers.bloxa.block.BlockAOutput;
import cz.youngdevelopers.bloxa.controller.BlockManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

import javax.annotation.Nullable;

public class AOutTileEntity extends TileEntity {
    private String name = "";
    private boolean activated = false;

    public AOutTileEntity()
    {
        BlockManager.getInstance().addBlock(this);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("name")) {
            name = compound.getString("name");
        }
        if (compound.hasKey("activated")) {
            activated = compound.getBoolean("activated");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setString("name", name);
        compound.setBoolean("activated", activated);
        return compound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.markDirty();
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
        getWorld().notifyBlockUpdate(pos, getWorld().getBlockState(pos), getWorld().getBlockState(pos), 3);
        IBlockState state = getWorld().getBlockState(pos);

        getWorld().scheduleUpdate(pos, getBlockType(), 10);
        this.markDirty();
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getNbtCompound());
        this.markDirty();
        getWorld().scheduleUpdate(pos, getBlockType(), 10);
        getWorld().markBlockRangeForRenderUpdate(pos, pos);
    }

}
