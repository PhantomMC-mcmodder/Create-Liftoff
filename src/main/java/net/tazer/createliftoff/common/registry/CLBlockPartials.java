package net.tazer.createliftoff.common.registry;

import com.jozufozu.flywheel.core.PartialModel;
import net.tazer.createliftoff.CreateLiftoff;

public class CLBlockPartials {
    public static final PartialModel
    AIR_COMPRESSOR_BELLOW = create("air_compressor/bellow");

    private static PartialModel create(String path) {
        return new PartialModel(CreateLiftoff.resource("block/" + path));
    }

    public static void register() {}
}
