package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.tazer.createliftoff.common.registry.CLFluids;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

@SuppressWarnings("unused")
public class CLMixingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    BASALT_ALLOY = create("basalt_alloy", builder -> builder
            .require(CLItems.COARSE_BASALT.get())
            .require(CLItems.COARSE_BASALT.get())
            .require(Items.IRON_INGOT)
            .output(CLItems.BASALT_ALLOY.get())
            .requiresHeat(HeatCondition.HEATED)),

    MAGMA_RESIN = create("magma_resin", builder -> builder
           .require(Items.MAGMA_CREAM)
           .require(AllFluids.HONEY.get(), 100)
           .output(CLFluids.MAGMA_RESIN.get(), 100)
           .requiresHeat(HeatCondition.SUPERHEATED));


    public CLMixingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
