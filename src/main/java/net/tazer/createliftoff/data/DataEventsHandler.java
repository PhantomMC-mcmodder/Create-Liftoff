package net.tazer.createliftoff.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.registry.CLTags;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;
import net.tazer.createliftoff.data.registry.CLSequencedAssemblyRecipes;

@Mod.EventBusSubscriber(modid = CreateLiftoff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEventsHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        CLTags.addVanillaBlocks();

        CLProcessingRecipeProvider.registerAllGenerators(generator);
        CLSequencedAssemblyRecipes.register(generator);
    }
}
