package com.github.l_ender.cataclysm.event;

import com.github.l_ender.cataclysm.mixin.Client.MinecraftClientMixin;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

/**
 * Callback for left-clicking ("attacking") anything.
 * Hooked by {@link MinecraftClientMixin}, so make sure to check for the player's game mode as well!
 * <p>
 * This callback considers return result only on the logical client side.
 * The logical server side is trigger by logical client side's result.
 *
 * <p>On the logical client, the return values have the following meaning:
 * <ul>
 *     <li>SUCCESS cancels further processing, causes a hand swing, and sends a packet to the server.</li>
 *     <li>CONSUME cancels further processing, and sends a packet to the server. It does NOT cause a hand swing.</li>
 *     <li>PASS falls back to further processing.</li>
 *     <li>FAIL cancels further processing and does not send a packet to the server.</li>
 * </ul>
 */
public interface AttackCallback {
    Event<AttackCallback> EVENT = EventFactory.createArrayBacked(AttackCallback.class,
            (listeners) -> (player, world, type) -> {
                for (AttackCallback event : listeners) {
                    ActionResult result = event.interact(player, world, type);

                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }

                return ActionResult.PASS;
            }
    );

    ActionResult interact(PlayerEntity player, World world, HitResult.Type type);
}
