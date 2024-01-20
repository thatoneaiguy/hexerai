package com.thatoneaiguy.hexerei;

import com.thatoneaiguy.hexerei.init.HexereiParticles;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class HexereiClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {
		HexereiParticles.registerFactories();
	}
}
