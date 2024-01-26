package com.thatoneaiguy.hexerei.init;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.particle.ExplosionParticleType;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;

public interface HexereiParticles {

	ExplosionParticleType RITUAL_BLOOM = new ExplosionParticleType();

	ExplosionParticleType FLARE = new ExplosionParticleType();

	ExplosionParticleType SMOKE = new ExplosionParticleType();

	ExplosionParticleType EXPLOSION = new ExplosionParticleType();

	static void register() {

		initParticles(bind(Registry.PARTICLE_TYPE));

	}

	static void registerFactories() {

		ParticleFactoryRegistry.getInstance().register(RITUAL_BLOOM, ExplosionParticleType.Factory::new);

		ParticleFactoryRegistry.getInstance().register(FLARE, ExplosionParticleType.Factory::new);

		ParticleFactoryRegistry.getInstance().register(SMOKE, ExplosionParticleType.Factory::new);

		ParticleFactoryRegistry.getInstance().register(EXPLOSION, ExplosionParticleType.Factory::new);

	}

	private static void initParticles(BiConsumer<ParticleType<?>, Identifier> registry) {

		registry.accept(RITUAL_BLOOM, new Identifier(Hexerei.MOD_ID, "ritual_bloom"));

		registry.accept(FLARE, new Identifier(Hexerei.MOD_ID, "flare"));

		registry.accept(SMOKE, new Identifier(Hexerei.MOD_ID, "smoke"));

		registry.accept(EXPLOSION, new Identifier(Hexerei.MOD_ID, "explosion"));

	}

	private static <T> BiConsumer<T, Identifier> bind(Registry<? super T> registry) {
		return (t, id) -> Registry.register(registry, id, t);
	}
}

