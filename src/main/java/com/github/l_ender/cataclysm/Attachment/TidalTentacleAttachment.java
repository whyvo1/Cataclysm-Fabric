package com.github.l_ender.cataclysm.Attachment;

import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import java.util.UUID;

public class TidalTentacleAttachment {

	private UUID lastTentacle;
	private boolean tentacle;
	public int id;

	public void setHasTentacle(boolean Tentacle) {
		this.tentacle = Tentacle;
	}

	public boolean hasTentacle() {
		return this.tentacle;
	}

	public void setLastTentacleID(int frozenPitch) {
		this.id = frozenPitch;
	}

	public int getLastTentacleID() {
		return id;
	}

	public void setLastTentacleUUID(UUID livingEntity) {
		lastTentacle = livingEntity;
	}

	public UUID getLastTentacleUUID() {
		return lastTentacle;
	}
}
