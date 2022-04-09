package net.tazer.createliftoff.data.providers;

import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.data.registry.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * For generating processing recipes, such as crushing or milling.
 * @author FortressNebula
 */
public abstract class CLProcessingRecipeProvider extends CreateRecipeProvider {

    protected static final List<CLProcessingRecipeProvider> ALL_GENERATORS = new ArrayList<>();

    public static void registerAllGenerators(DataGenerator generator) {
        ALL_GENERATORS.add(new CLMillingRecipes(generator));
        ALL_GENERATORS.add(new CLMixingRecipes(generator));
        ALL_GENERATORS.add(new CLCrushingRecipes(generator));
        ALL_GENERATORS.add(new CLPressingRecipes(generator));
        ALL_GENERATORS.add(new CLFillingRecipes(generator));
        ALL_GENERATORS.add(new CLEmptyingRecipes(generator));

        generator.addProvider(new DataProvider() {

            @Override
            public @NotNull String getName() {
                return "Create: Liftoff's Processing Recipes";
            }

            @Override
            public void run(@NotNull HashCache cache) {
                ALL_GENERATORS.forEach(g -> {
                    try {
                        g.run(cache);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    public CLProcessingRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    /*
    Most of the following functions are copied from Create's ProcessingRecipeGen class.
     */

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                                   UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get()))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(String name,
                                                                     UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return createWithDeferredId(() -> CreateLiftoff.resource(name), transform);
    }

    protected abstract IRecipeTypeInfo getRecipeType();

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }

    @Override
    public @NotNull String getName() {
        return "Create: Liftoff's Processing Recipes: " + getRecipeType().getId()
                .getPath();
    }
}
