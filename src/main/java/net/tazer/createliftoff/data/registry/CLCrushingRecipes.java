package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

public class CLCrushingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    COARSE_BASALT = create("coarse_basalt", builder -> builder
            .duration(150)
            .require(Blocks.BASALT)
            .output(CLItems.COARSE_BASALT.get(), 2)
            .output(.5f, CLItems.COARSE_BASALT.get()));

    public CLCrushingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.CRUSHING;
    }
}
