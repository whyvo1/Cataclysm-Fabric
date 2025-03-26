package com.github.l_ender.cataclysm.util;

import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;

public class EntityExcludedDamageSource extends DamageSource {

	protected final List<EntityType<?>> entities;

	public EntityExcludedDamageSource(RegistryEntry<DamageType> type, EntityType<?>... entities) {
		super(type);
		this.entities = Arrays.stream(entities).toList();
	}

	@Override
	public Text getDeathMessage(LivingEntity living) {
		LivingEntity livingentity = living.getPrimeAdversary();
		String s = "death.attack." + this.getType().msgId();
		String s1 = s + ".player";
		if (livingentity != null) {
			for (EntityType<?> entity : entities) {
				if (livingentity.getType() == entity) {
					return Text.translatable(s, living.getDisplayName());
				}
			}
		}
		return livingentity != null ? Text.translatable(s1, living.getDisplayName(), livingentity.getDisplayName()) : Text.translatable(s, living.getDisplayName());
	}
}
