package com.thatoneaiguy.hexerei;

import com.thatoneaiguy.hexerei.init.HexereiItems;
import com.thatoneaiguy.hexerei.init.HexereiBlocks;
import com.thatoneaiguy.hexerei.init.HexereiParticles;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Hexerei implements ModInitializer {

	public static final String MOD_ID = "hexerei";

	public static final Logger LOGGER = LoggerFactory.getLogger("hexerei");

	@Override
	public void onInitialize(ModContainer mod) {

		HexereiItems.register();

		HexereiBlocks.register();

		HexereiParticles.register();
	}
}
