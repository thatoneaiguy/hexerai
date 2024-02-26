package com.thatoneaiguy.hexerei.init;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.item.DebugItem;
import com.thatoneaiguy.hexerei.item.spells.Aufwind;
import com.thatoneaiguy.hexerei.item.spells.Greifen;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class HexereiItems {

	public static final ItemGroup HEXEREI = FabricItemGroupBuilder.build(
		new Identifier(Hexerei.MOD_ID, "hexerei"), () -> new ItemStack(HexereiItems.AUFWIND));

		public static final Item AUFWIND = registerItem("aufwind", new Aufwind(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item GREIFEN = registerItem("greifen", new Greifen(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item ORB_OF_CALAMITAS = registerItem("orb_of_calamitas", new Item(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item DEBUG = registerItem("debug", new DebugItem(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Hexerei.MOD_ID, name), item);
	}

	public static void register() {
	}
}
