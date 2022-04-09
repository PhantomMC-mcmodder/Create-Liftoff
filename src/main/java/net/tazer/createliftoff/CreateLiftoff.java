package net.tazer.createliftoff;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tazer.createliftoff.common.item.CLItemGroups;
import net.tazer.createliftoff.common.registry.CLBlocks;
import net.tazer.createliftoff.common.registry.CLFluids;
import net.tazer.createliftoff.common.registry.CLItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreateLiftoff.MOD_ID)
public class CreateLiftoff
{
    public static final String MOD_ID = "createliftoff";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean isAlloyedLoaded = false;
    public static boolean isSteamPoweredLoaded = false;

    private static final NonNullSupplier<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(MOD_ID);

    public CreateLiftoff() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        isAlloyedLoaded = ModList.get().isLoaded("alloyed");
        isSteamPoweredLoaded = ModList.get().isLoaded("steampowered");

        //basicRegistrate().creativeModeTab(CLItemGroups::baseTab, "Create: Liftoff");
        //CLItemGroups.register();
        CLItems.register();
        CLBlocks.register();
        CLFluids.register();
    }

    public static ResourceLocation resource(String path) { return new ResourceLocation(MOD_ID, path); }

    public static CreateRegistrate basicRegistrate() {
        return REGISTRATE.get();
    }

    // Utility method to save having to type out the item group each time.
    public static CreateRegistrate defaultRegistrate() {
        return basicRegistrate().creativeModeTab(CLItemGroups::baseTab);
    }
}