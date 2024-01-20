package com.thatoneaiguy.hexerei.init;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.block.Pedestal;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class HexereiBlocks {

	public static final Block PEDESTAL = registerBlock("pedestal", new Pedestal(QuiltBlockSettings.of(Material.METAL).requiresTool().strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE)), HexereiItems.HEXEREI);

	private static Block registerBlock(String name, Block block, ItemGroup tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new Identifier(Hexerei.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
		return Registry.register(Registry.ITEM, new Identifier(Hexerei.MOD_ID, name),
			new BlockItem(block, new QuiltItemSettings().group(tab)));
	}

	public static void register() {
	}
}

