package net.tazer.createliftoff.common.content.air_compressor;

import com.jozufozu.flywheel.repack.joml.Math;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.contraptions.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.tazer.createliftoff.common.registry.CLFluids;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AirCompressorTileEntity extends SplitShaftTileEntity implements IHaveGoggleInformation {

    public FluidTank airTank;
    public LazyOptional<IFluidHandler> capability;

    public int prevRunningTicks;
    public int runningTicks;

    public AirCompressorTileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
        airTank = new FluidTank(10000,
                stack -> stack.getFluid() == CLFluids.COMPRESSED_AIR.get());
        capability = LazyOptional.of(() -> airTank);

    }

    @Override
    public float getRotationSpeedModifier(Direction face) {
        return 1;
    }

    @Override
    public void tick() {
        super.tick();

        if (!level.isClientSide) {
            int compressedAirGenerated = (int) (Math.abs(getSpeed()) / 256 * 20);

            airTank.fill(new FluidStack(CLFluids.COMPRESSED_AIR.get(), compressedAirGenerated),
                    IFluidHandler.FluidAction.EXECUTE);
            sendData();
        }

        prevRunningTicks = runningTicks;
        runningTicks += getRunningTickSpeed();
        runningTicks %= 360;

        sendData();
    }

    public float getRenderedBellowOffset(float partialTicks) {
        if (getSpeed() == 0)
            return 0;
        float ticks = Mth.lerp(partialTicks, prevRunningTicks, runningTicks);
        return (Math.sin(Math.toRadians(ticks)) - 1) / 10;
    }

    public int getRunningTickSpeed() {
        if (getSpeed() == 0)
            return 0;
        return (int) Mth.lerp(Mth.clamp(Math.abs(getSpeed()) / 512f, 0, 1), 1, 60);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && capability != null) return capability.cast();
        return super.getCapability(cap, side);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        capability.invalidate();
    }

    @Override
    protected void write(CompoundTag compound, boolean clientPacket) {
        compound.put("AirTank", airTank.writeToNBT(new CompoundTag()));
        compound.putInt("Ticks", runningTicks);
        super.write(compound, clientPacket);
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        airTank.readFromNBT(compound.getCompound("AirTank"));
        prevRunningTicks = runningTicks = compound.getInt("Ticks");
        super.read(compound, clientPacket);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        containedFluidTooltip(tooltip, isPlayerSneaking, capability);
        return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
    }
}
