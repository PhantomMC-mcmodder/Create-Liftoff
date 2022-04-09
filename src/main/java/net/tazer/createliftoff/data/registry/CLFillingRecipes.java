package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.registry.CLFluids;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.common.registry.CLTags;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

@SuppressWarnings("unused")
public class CLFillingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    MAGMA_RESIN_BOTTLE = create("magma_resin_bottle", builder -> builder
            .require(Items.GLASS_BOTTLE)
            .require(CLFluids.MAGMA_RESIN.get(), 250)
            .output(CLItems.MAGMA_RESIN_BOTTLE.get()));

    public CLFillingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.FILLING;
    }
}
