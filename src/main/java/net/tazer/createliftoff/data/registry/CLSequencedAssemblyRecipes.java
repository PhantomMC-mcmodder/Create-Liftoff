package net.tazer.createliftoff.data.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.contraptions.components.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.contraptions.components.press.PressingRecipe;
import com.simibubi.create.content.contraptions.fluids.actors.FillingRecipe;
import com.simibubi.create.content.contraptions.itemAssembly.SequencedAssemblyRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tazer.createliftoff.CreateLiftoff;
import net.tazer.createliftoff.common.registry.CLFluids;
import net.tazer.createliftoff.common.registry.CLItems;
import net.tazer.createliftoff.common.registry.CLTags;

import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class CLSequencedAssemblyRecipes extends CreateRecipeProvider {

    GeneratedRecipe

    NETHERITE_COMPOSITE = create("netherite_composite", builder -> builder
            .require(Items.NETHERITE_INGOT)
            .transitionTo(CLItems.INCOMPLETE_NETHERITE_COMPOSITE.get())
            .addOutput(new ItemStack(CLItems.NETHERITE_COMPOSITE.get(), 6), 120)
            .loops(1)
            .addStep(DeployerApplicationRecipe::new, b -> b.require(CLTags.DIAMOND_DUST))
            .addStep(FillingRecipe::new, b -> b.require(CLFluids.MAGMA_RESIN.get(), 100))
            .addStep(DeployerApplicationRecipe::new, b -> b.require(Items.NETHERITE_INGOT))
            .addStep(PressingRecipe::new, b -> b)
    ),

    ELECTRICAL_MECHANISM = create("electrical_mechanism", builder -> builder
            .require(CLTags.COPPER_SHEET)
            .transitionTo(CLItems.INCOMPLETE_ELECTRICAL_MECHANISM.get())
            .addOutput(CLItems.ELECTRICAL_MECHANISM.get(), 120)
            .loops(5)
            .addStep(DeployerApplicationRecipe::new, b -> b.require(AllBlocks.COGWHEEL.get()))
            .addStep(DeployerApplicationRecipe::new, b -> b.require(AllItems.IRON_SHEET.get()))
            .addStep(DeployerApplicationRecipe::new, b -> b.require(AllItems.ELECTRON_TUBE.get()))
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
