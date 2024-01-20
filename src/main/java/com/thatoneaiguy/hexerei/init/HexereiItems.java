package com.thatoneaiguy.hexerei.init;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.item.KugelScroll;
import com.thatoneaiguy.hexerei.item.Key;
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
		new Identifier(Hexerei.MOD_ID, "hexerei"), () -> new ItemStack(HexereiItems.KUGEL_SCROLL));

	public static final Item KUGEL_SCROLL = registerItem("kugel_scroll", new KugelScroll(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item IDFK = registerItem("idfk", new Key(new QuiltItemSettings().group(HEXEREI).rarity(Rarity.UNCOMMON).maxCount(1)));

	public static final Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Hexerei.MOD_ID, name), item);
	}

	public static void register() {
	}
}
