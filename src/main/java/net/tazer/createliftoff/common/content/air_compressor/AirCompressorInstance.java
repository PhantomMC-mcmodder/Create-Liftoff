package net.tazer.createliftoff.common.content.air_compressor;

import com.jozufozu.flywheel.api.InstanceData;
import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.api.instance.DynamicInstance;
import com.jozufozu.flywheel.core.materials.oriented.OrientedData;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.simibubi.create.content.contraptions.components.deployer.DeployerInstance;
import com.simibubi.create.content.contraptions.components.press.MechanicalPressBlock;
import com.simibubi.create.content.contraptions.components.press.PressInstance;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftInstance;
import com.simibubi.create.content.contraptions.relays.encased.SplitShaftTileEntity;
import com.simibubi.create.foundation.utility.AngleHelper;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.tazer.createliftoff.common.registry.CLBlockPartials;

public class AirCompressorInstance extends SplitShaftInstance implements DynamicInstance {
    final AirCompressorTileEntity tile;
    private final OrientedData bellow1;
    private final OrientedData bellow2;
    private final float yRot;

    private final Direction.Axis facing;

    public AirCompressorInstance(MaterialManager modelManager, SplitShaftTileEntity tile) {
        super(modelManager, tile);
        this.tile = (AirCompressorTileEntity) tile;
        facing = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        yRot = facing == Direction.Axis.X ? 90 : 0;


        bellow1 = getOrientedMaterial()
                .getModel(CLBlockPartials.AIR_COMPRESSOR_BELLOW, blockState)
                .createInstance();

        bellow2 = getOrientedMaterial()
                .getModel(CLBlockPartials.AIR_COMPRESSOR_BELLOW, blockState)
                .createInstance();

        relight(pos, bellow1, bellow2);
        updateRotation();
        updatePosition();
    }

    /**
     * Called every frame, and after initialization.
     * <br>
     * <em>DISPATCHED IN PARALLEL</em>, don't attempt to mutate anything outside this instance.
     * <br>
     * {@link Instancer}/{@link InstanceData} creation/acquisition is safe here.
     */
    @Override
    public void beginFrame() {
        updatePosition();
    }

    @Override
    public void remove() {
        super.remove();
        bellow1.delete();
        bellow2.delete();
    }

    @Override
    public void updateLight() {
        super.updateLight();
        relight(pos, bellow1, bellow2);
    }

    private void updateRotation() {

        Quaternion q = Vector3f.YP.rotationDegrees(yRot);

        bellow1.setRotation(q);
        q.mul(Direction.UP.step().rotationDegrees(180));
        bellow2.setRotation(q);
    }

    private void updatePosition() {

        //float distance = tile.bellowTimer + AnimationTickHolder.getPartialTicks();
        //BlockPos blockPos = getInstancePosition();

        //distance = Math.min(distance,1);
        //distance = Math.max(distance,0);
        //distance *= 0.15;

        float distance = tile.getRenderedBellowOffset(AnimationTickHolder.getPartialTicks());

        float x = facing == Direction.Axis.X ? 0 : distance;
        float z = facing == Direction.Axis.Z ? 0 : distance;

        bellow1.setPosition(getInstancePosition())
                .nudge(-x, 0, z);
        bellow2.setPosition(getInstancePosition())
                .nudge(x, 0, -z);
    }

//    private Vector3f add(Vector3f a, Vector3f b)
//    {
//        return new Vector3f(a.x() + b.x(),a.y() + b.y(),a.z() + b.z());
//    }
//    private Vector3f scale(Vector3f a, float m)
//    {
//        return new Vector3f(a.x() * m,a.y() * m,a.z() * m);
//    }
}
