package com.github.l_ender.cataclysm.util;

import java.util.List;
import net.minecraft.client.network.ServerInfo;

public class ClientUtil {

    public static boolean set(ServerInfo p_233840_, List<ServerInfo> p_233841_) {
        for(int i = 0; i < p_233841_.size(); ++i) {
            ServerInfo serverdata = p_233841_.get(i);
            if (serverdata.name.equals(p_233840_.name) && serverdata.address.equals(p_233840_.address)) {
                p_233841_.set(i, p_233840_);
                return true;
            }
        }

        return false;
    }
}
