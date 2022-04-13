package net.tazer.createliftoff.common.registry;

import com.simibubi.create.content.contraptions.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.FluidEntry;
import net.tazer.createliftoff.CreateLiftoff;

public class CLFluids {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    public static final FluidEntry<VirtualFluid> MAGMA_RESIN = REGISTRATE.virtualFluid("magma_resin")
            .lang("Magma Resin")
            .register();

    public static final FluidEntry<VirtualFluid> COMPRESSED_AIR = REGISTRATE.virtualFluid("compressed_air")
            .lang("Compressed Air")
            .attributes(builder -> builder.density(-10))
            .register();

    // TODO: Add Gaseous Oxygen, as well as Gaseous and Liquid Hydrogen

    public static final FluidEntry<VirtualFluid> LIQUID_OXYGEN = REGISTRATE.virtualFluid("liquid_oxygen")
            .lang("Liquid Oxygen")
            .register();

    public static void register() {}
}
