package com.github.l_ender.cataclysm.entity.partentity;

public interface Partable {
    default Cm_Part_Entity<?>[] getParts() {
        return null;
    }
}
