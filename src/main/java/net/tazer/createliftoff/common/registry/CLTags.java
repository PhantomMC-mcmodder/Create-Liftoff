package net.tazer.createliftoff.common.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.providers.ProviderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.tazer.createliftoff.CreateLiftoff;

public class CLTags {
    /*
    Items
     */
    public static final TagKey<Item> NETHERITE_SHEET = forgeItemTag("plates/netherite");
    public static final TagKey<Item> COPPER_SHEET = forgeItemTag("plates/copper");
    public static final TagKey<Item> DIAMOND_DUST = forgeItemTag("dusts/diamond");
    public static final TagKey<Item> BASALT = defaultItemTag("basalt");

    /*
    Generic
     */
    public static final TagKey<Item> DIAMOND = forgeItemTag("gems/diamond");



    private static TagKey<Item> itemTag(String namespace, String path) {
        return ItemTags.create(new ResourceLocation(namespace, path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return itemTag("forge", path);
    }

    private static TagKey<Item> defaultItemTag(String path) {
        return itemTag(CreateLiftoff.MOD_ID, path);
    }


    private static TagKey<Block> blockTag(String namespace, String path) {
        return BlockTags.create(new ResourceLocation(namespace, path));
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return blockTag("forge", path);
    }

    private static TagKey<Block> defaultBlockTag(String path) {
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
