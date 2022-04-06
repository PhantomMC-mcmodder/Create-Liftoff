package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.data.providers.CLProcessingRecipeProvider;

public class CLPressingRecipes extends CLProcessingRecipeProvider {
    GeneratedRecipe

    NETHERITE_SHEET = create("netherite_sheet", builder -> builder
            .require(Items.NETHERITE_INGOT)
            .output(CLItems.NETHERITE_SHEET.get()));

    public CLPressingRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected AllRecipeTypes getRecipeType() {
        return AllRecipeTypes.PRESSING;
    }
}
