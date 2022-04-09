package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.tazer.createliftoff.common.registry.CLFluids;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

@SuppressWarnings("unused")
public class CLEmptyingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    MAGMA_RESIN = create("magma_resin", builder -> builder
            .require(CLItems.MAGMA_RESIN_BOTTLE.get())
            .output(Items.GLASS_BOTTLE)
            .output(CLFluids.MAGMA_RESIN.get(), 250)
    );

    public CLEmptyingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }
}
