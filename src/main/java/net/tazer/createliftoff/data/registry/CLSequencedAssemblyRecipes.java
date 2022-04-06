package net.tazer.createliftoff.data.registry;

import com.simibubi.create.content.contraptions.components.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.contraptions.components.press.PressingRecipe;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.common.registry.CLTags;

import java.util.function.UnaryOperator;

public class CLSequencedAssemblyRecipes extends CreateRecipeProvider {

    GeneratedRecipe

    NETHERITE_COMPOSITE = create("netherite_composite", builder -> builder
            .require(CLTags.NETHERITE_SHEET)
            .transitionTo(CLItems.INCOMPLETE_NETHERITE_COMPOSITE.get())
            .addOutput(CLItems.NETHERITE_COMPOSITE.get(), 120)
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, b -> b.require(CLTags.DIAMOND_DUST))
            // TODO: .addStep(DeployerApplicationRecipe::new, b -> b.require(CLItems.MAGMA_RESIN))
            .addStep(DeployerApplicationRecipe::new, b -> b.require(CLTags.NETHERITE_SHEET))
            .addStep(PressingRecipe::new, b -> b)
    );

    public CLSequencedAssemblyRecipes(DataGenerator generator) {
        super(generator);
    }

    protected GeneratedRecipe create(String name, UnaryOperator<SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
                c -> transform.apply(new SequencedAssemblyRecipeBuilder(CreateLiftoff.resource(name)))
                        .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    public static void register(DataGenerator generator) {
        generator.addProvider(new CLSequencedAssemblyRecipes(generator));
    }

    @Override
    public String getName() {
        return "Create: Liftoff's Sequenced Assembly Recipes";
    }

}
