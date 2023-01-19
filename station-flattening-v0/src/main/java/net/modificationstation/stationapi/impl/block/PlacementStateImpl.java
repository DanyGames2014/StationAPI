package net.modificationstation.stationapi.impl.block;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Block;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.maths.Vec3f;
import net.modificationstation.stationapi.api.event.block.BlockEvent;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.mod.entrypoint.EventBusPolicy;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
public final class PlacementStateImpl {

    @EventListener(numPriority = Integer.MAX_VALUE / 2 + Integer.MAX_VALUE / 4)
    private static void handleBlockPlacement(BlockEvent.BeforePlacedByItem event) {
        if (event.blockItem.getType() instanceof Block)
            event.placeFunction = () -> event.world.setBlockStateWithNotify(event.x, event.y, event.z, event.block.getPlacementState(new ItemPlacementContext(
                    event.player,
                    event.blockItem,
                    new HitResult(
                            event.x - event.side.getOffsetX(),
                            event.y - event.side.getOffsetY(),
                            event.z - event.side.getOffsetZ(),
                            event.side.getId(), Vec3f.from(event.x, event.y, event.z)
                    )
            ))) != null;
    }
}