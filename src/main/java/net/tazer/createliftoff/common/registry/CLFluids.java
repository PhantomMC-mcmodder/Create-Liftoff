package net.tazer.createliftoff.common.registry;

import com.simibubi.create.content.contraptions.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.FluidEntry;
import net.tazer.createliftoff.CreateLiftoff;

public class CLFluids {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    public static final FluidEntry<VirtualFluid> MAGMA_RESIN = REGISTRATE.virtualFluid("magma_resin")
            .lang("Magma Resin")
            //.attributes(builder -> builder.viscosity(2000).density(1400))
            .register();

    public static void register() {}
}
