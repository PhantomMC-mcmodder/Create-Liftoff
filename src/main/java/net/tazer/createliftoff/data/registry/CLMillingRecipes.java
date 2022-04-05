package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

public class CLMillingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    COARSE_BASALT = create("coarse_basalt", builder -> builder
            .duration(100)
            .require(Blocks.BASALT)
            .output(CLItems.COARSE_BASALT.get())
            .output(.5f, CLItems.COARSE_BASALT.get()));

    public CLMillingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.MILLING;
    }
}
