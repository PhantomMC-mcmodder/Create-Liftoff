package net.tazer.createliftoff.common.content.air_compressor;

import com.simibubi.create.content.contraptions.base.HorizontalAxisKineticBlock;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.tazer.createliftoff.common.registry.CLTileEntities;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class AirCompressorBlock extends HorizontalAxisKineticBlock implements LiquidBlockContainer, ITE<AirCompressorTileEntity> {
    public AirCompressorBlock(Properties properties) {
        super(properties);
    }

    private boolean ifCanPlaceLiquidDo(BlockGetter level, BlockPos pos, Fluid fluid, Consumer<AirCompressorTileEntity> cons) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AirCompressorTileEntity airCompressor) {
            if (airCompressor.airTank.fill(new FluidStack(fluid, 1000),
                    IFluidHandler.FluidAction.SIMULATE) == 1000) {
                cons.accept(airCompressor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return ifCanPlaceLiquidDo(pLevel, pPos, pFluid, $ -> {});
    }

    @Override
    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        return ifCanPlaceLiquidDo(pLevel, pPos, pFluidState.getType(), te -> te.airTank.
                fill(new FluidStack(pFluidState.getType(), 1000), IFluidHandler.FluidAction.EXECUTE));
    }

    @Override
    public Class<AirCompressorTileEntity> getTileEntityClass() {
        return AirCompressorTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends AirCompressorTileEntity> getTileEntityType() {
        return CLTileEntities.AIR_COMPRESSOR.get();
    }
}
