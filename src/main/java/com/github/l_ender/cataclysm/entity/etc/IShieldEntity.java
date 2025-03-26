package com.github.l_ender.cataclysm.entity.etc;

public interface IShieldEntity {

    int getShieldCooldownTime();

    void setShieldCooldownTime(int shieldCooldownTime);

    void disableShield(boolean guaranteeDisable);

    boolean isShieldDisabled();

}
