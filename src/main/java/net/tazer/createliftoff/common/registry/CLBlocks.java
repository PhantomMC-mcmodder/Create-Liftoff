package net.tazer.createliftoff.common.registry;

import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.ModelGen;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.content.air_compressor.AirCompressorBlock;

public class CLBlocks {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    public static final BlockEntry<AirCompressorBlock> AIR_COMPRESSOR = REGISTRATE
            .block("air_compressor", AirCompressorBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            //.blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(),
            //        prov.models().getExistingFile(CreateLiftoff.resource("block/air_compressor/block"))))
            .blockstate((ctx, prov) -> BlockStateGen.horizontalAxisBlock(ctx, prov,
                    blockState -> prov.models().getExistingFile(CreateLiftoff.resource("block/air_compressor/block"))))
            .item().transform(ModelGen.customItemModel())
            .transform(BlockStressDefaults.setImpact(4))
            .register();

    public static void register() {}
}
