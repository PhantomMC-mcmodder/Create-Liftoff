package net.tazer.createliftoff.common.registry;

import com.simibubi.create.content.contraptions.relays.encased.SplitShaftRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.BlockEntityEntry;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.content.air_compressor.AirCompressorInstance;
import net.tazer.createliftoff.common.content.air_compressor.AirCompressorTileEntity;

public class CLTileEntities {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    public static final BlockEntityEntry<AirCompressorTileEntity> AIR_COMPRESSOR = REGISTRATE
            .tileEntity("air_compressor", AirCompressorTileEntity::new)
            .instance(() -> AirCompressorInstance::new)
            .validBlock(CLBlocks.AIR_COMPRESSOR)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static void register() {}
}
