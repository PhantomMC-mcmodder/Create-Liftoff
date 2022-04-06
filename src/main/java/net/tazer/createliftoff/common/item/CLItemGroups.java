package net.tazer.createliftoff.common.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.registry.CLItems;
import org.jetbrains.annotations.NotNull;

public class CLItemGroups {
    private static final CreativeModeTab BASE_CREATIVE_TAB = new CreativeModeTab("base_creative_tab") {
        public ItemStack makeIcon() {
            return new ItemStack(CLItems.COARSE_BASALT.get()); /*TODO Make sure this uses an actual item!*/
        }
    };
    public static @NotNull CreativeModeTab baseTab() { return BASE_CREATIVE_TAB; }

    // Generate lang entries
    private static final CreateRegistrate REGISTRATE = CreateLiftoff.basicRegistrate()
            .creativeModeTab(CLItemGroups::baseTab, "Create: Liftoff");

    public static void register() {}
}