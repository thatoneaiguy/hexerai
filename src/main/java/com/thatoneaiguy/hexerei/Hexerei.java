package com.thatoneaiguy.hexerei;

import com.thatoneaiguy.hexerei.init.*;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Hexerei implements ModInitializer {

	public static final String MOD_ID = "hexerei";

	public static final Logger LOGGER = LoggerFactory.getLogger("hexerei");

	public static final Color MAGIC = new Color(0x5C0000);

	public static @NotNull Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize(ModContainer mod) {

		HexereiItems.register();

		HexereiBlocks.register();

		HexereiParticles.register();

		HexereiSoundEvents.register();

		HexereiEntities.register();

	}
}
