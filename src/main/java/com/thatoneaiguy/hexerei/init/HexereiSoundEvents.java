package com.thatoneaiguy.hexerei.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HexereiSoundEvents {

	public static final Identifier BOOM = new Identifier("hexerei:boom");

	public static SoundEvent BOOM_SOUND_EVENT = new SoundEvent(BOOM);


	public static final Identifier RINGING = new Identifier("hexerei:ringing");

	public static SoundEvent RINGING_SOUND_EVENT = new SoundEvent(RINGING);


	public static final Identifier SPELLCAST = new Identifier("hexerei:spellcast");

	public static SoundEvent SPELLCAST_SOUND_EVENT = new SoundEvent(SPELLCAST);

	public static void register() {

		Registry.register(Registry.SOUND_EVENT, HexereiSoundEvents.BOOM, BOOM_SOUND_EVENT);

		Registry.register(Registry.SOUND_EVENT, HexereiSoundEvents.RINGING, RINGING_SOUND_EVENT);

		Registry.register(Registry.SOUND_EVENT, HexereiSoundEvents.SPELLCAST, SPELLCAST_SOUND_EVENT);

	}
}
