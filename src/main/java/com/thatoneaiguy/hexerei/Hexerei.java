package com.thatoneaiguy.hexerei;

import com.thatoneaiguy.hexerei.init.HexereiItems;
import com.thatoneaiguy.hexerei.init.HexereiBlocks;
import com.thatoneaiguy.hexerei.init.HexereiParticles;
import com.thatoneaiguy.hexerei.init.HexereiSoundEvents;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Hexerei implements ModInitializer {

	public static final String MOD_ID = "hexerei";

	public static final Logger LOGGER = LoggerFactory.getLogger("hexerei");

	public static final Color MAGIC_BLUE = new Color(0x7B9DCA);

	public static @NotNull Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize(ModContainer mod) {

		HexereiItems.register();

		HexereiBlocks.register();

		HexereiParticles.register();

		HexereiSoundEvents.register();

	}
}
