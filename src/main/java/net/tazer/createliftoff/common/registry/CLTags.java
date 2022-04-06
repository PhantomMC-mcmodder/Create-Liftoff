package net.tazer.createliftoff.common.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.providers.ProviderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.tazer.createliftoff.CreateLiftoff;

public class CLTags {
    /*
    Items
     */
    public static final Tag.Named<Item> NETHERITE_SHEET = forgeItemTag("plates/netherite");
    public static final Tag.Named<Item> DIAMOND_DUST = forgeItemTag("dusts/diamond");
    public static final Tag.Named<Item> BASALT = defaultItemTag("basalt");

    /*
    Generic
     */
    public static final Tag.Named<Item> DIAMOND = forgeItemTag("gems/diamond");



    private static Tag.Named<Item> itemTag(String namespace, String path) {
        return ItemTags.bind(namespace + ":" + path);
    }

    private static Tag.Named<Item> forgeItemTag(String path) {
        return itemTag("forge", path);
    }

    private static Tag.Named<Item> defaultItemTag(String path) {
        return itemTag(CreateLiftoff.MOD_ID, path);
    }


    private static Tag.Named<Block> blockTag(String namespace, String path) {
        return BlockTags.bind(namespace + ":" + path);
    }

    private static Tag.Named<Block> forgeBlockTag(String path) {
        return blockTag("forge", path);
    }

    private static Tag.Named<Block> defaultBlockTag(String path) {
        return blockTag(CreateLiftoff.MOD_ID, path);
    }

    public static void addVanillaBlocks() {
        CreateRegistrate registrate = CreateLiftoff.basicRegistrate();

        registrate.addDataGenerator(ProviderType.ITEM_TAGS, prov -> prov
                .tag(BASALT)
                .add(Blocks.BASALT.asItem())
                .add(Blocks.SMOOTH_BASALT.asItem())
                .add(Blocks.POLISHED_BASALT.asItem()));
    }
}
