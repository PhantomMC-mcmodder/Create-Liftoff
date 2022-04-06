package net.tazer.createliftoff.common.registry;

import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.tazer.createliftoff.CreateLiftoff;

public class CLItems {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    public static final ItemEntry<Item> COARSE_BASALT = REGISTRATE
            .item("coarse_basalt", Item::new)
            .register();

    public static final ItemEntry<Item> BASALT_ALLOY = REGISTRATE
            .item("basalt_alloy", Item::new)
            .register();

    public static final ItemEntry<Item> ELECTRICAL_MECHANISM = REGISTRATE
            .item("electrical_mechanism", Item::new)
            .register();

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_ELECTRICAL_MECHANISM = REGISTRATE
            .item("incomplete_electrical_mechanism", SequencedAssemblyItem::new)
            .register();

    public static void register() {}
}
