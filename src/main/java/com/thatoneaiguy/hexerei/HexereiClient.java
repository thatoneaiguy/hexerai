package com.thatoneaiguy.hexerei;

import com.sammy.lodestone.handlers.ScreenParticleHandler;
import com.thatoneaiguy.hexerei.init.HexereiEntities;
import com.thatoneaiguy.hexerei.init.HexereiItems;
import com.thatoneaiguy.hexerei.init.HexereiParticles;
import com.thatoneaiguy.hexerei.particle.OrbOfCalamitasParticleEmmiter;
import com.thatoneaiguy.hexerei.render.AufwindEntityRenderer;
import com.thatoneaiguy.hexerei.render.GreifenEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;


public class HexereiClient implements ClientModInitializer {


	@Override
	public void onInitializeClient(ModContainer mod) {

		HexereiParticles.registerFactories();

		ScreenParticleHandler.registerItemParticleEmitter(HexereiItems.ORB_OF_CALAMITAS, OrbOfCalamitasParticleEmmiter::particleTick);

		EntityRendererRegistry.register(HexereiEntities.AufwindEntityType, AufwindEntityRenderer::new);

		EntityRendererRegistry.register(HexereiEntities.GreifenEntityType, GreifenEntityRenderer::new);

	}
}
