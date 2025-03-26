package com.github.l_ender.cataclysm.entity.util;

import com.github.l_ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.l_ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class TidalTentacleUtil {



    public static void setLastTentacle(LivingEntity entity, Tidal_Tentacle_Entity tendon) {


//        TidalTentacleAttachment portal = entity.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
        TidalTentacleCapability capability = ModCapabilities.getOrCreate(entity, ModCapabilities.TIDAL_TENTACLE_CAPABILITY);
        capability.setHasTentacle(tendon != null);

    }

    public static void retractFarTentacles(World level, LivingEntity livingEntity) {
        Tidal_Tentacle_Entity last = getLastTendon(livingEntity);
        if (last != null) {
            last.remove(Entity.RemovalReason.DISCARDED);
            setLastTentacle(livingEntity, null);
        }
    }

    public static boolean canLaunchTentacles(World level, LivingEntity livingEntity) {
        Tidal_Tentacle_Entity last = getLastTendon(livingEntity);
        if (last != null) {
            return last.isRemoved();
        }
        return true;
    }


    public static Tidal_Tentacle_Entity getLastTendon(LivingEntity livingEntity) {
//        TidalTentacleAttachment portal = livingEntity.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
        TidalTentacleCapability capability = ModCapabilities.getOrCreate(livingEntity, ModCapabilities.TIDAL_TENTACLE_CAPABILITY);
        UUID uuid = capability.getLastTentacleUUID();
        int id = capability.getLastTentacleID();
        if (!livingEntity.getWorld().isClient) {
            if (uuid != null) {
                Entity e = livingEntity.getWorld().getEntityById(id);
                return e instanceof Tidal_Tentacle_Entity ? (Tidal_Tentacle_Entity) e : null;
            }
        } else {
            if (id != -1) {
                Entity e = livingEntity.getWorld().getEntityById(id);
                return e instanceof Tidal_Tentacle_Entity ? (Tidal_Tentacle_Entity) e : null;
            }
        }
        return null;
    }
}
