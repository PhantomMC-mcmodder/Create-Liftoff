package net.tazer.createliftoff.common.registry;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.tazer.createliftoff.CreateLiftoff;

public class CLItems {
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.defaultRegistrate();

    /*
    MATERIALS
     */

    public static final ItemEntry<Item>
            COARSE_BASALT = ingredient("coarse_basalt"),
            BASALT_ALLOY = ingredient("basalt_alloy"),
            NETHERITE_COMPOSITE = ingredient("netherite_composite"),
            ELECTRICAL_MECHANISM = ingredient("electrical_mechanism");

    public static final ItemEntry<Item>
            NETHERITE_SHEET = taggedIngredient("netherite_sheet", CLTags.NETHERITE_SHEET),
            DIAMOND_GRIT = taggedIngredient("diamond_grit", CLTags.DIAMOND_DUST),
            MAGMA_RESIN_BOTTLE = taggedIngredient("magma_resin_bottle", AllTags.AllItemTags.UPRIGHT_ON_BELT.tag);

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_NETHERITE_COMPOSITE = REGISTRATE
            .item("incomplete_netherite_composite", SequencedAssemblyItem::new)
            .register();

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_ELECTRICAL_MECHANISM = REGISTRATE
            .item("incomplete_electrical_mechanism", SequencedAssemblyItem::new)
            .register();

    public static void register() {}

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new).tag(tags).register();
    }

    private static ItemEntry<Item> ingredient(String name) {
        return taggedIngredient(name);
    }
}
