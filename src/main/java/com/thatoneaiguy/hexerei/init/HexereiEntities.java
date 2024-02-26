package com.thatoneaiguy.hexerei.init;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.entities.AufwindEntity;
import com.thatoneaiguy.hexerei.entities.GreifenEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class HexereiEntities {

	public static final EntityType<AufwindEntity> AufwindEntityType = Registry.register(

		Registry.ENTITY_TYPE,
		new Identifier(Hexerei.MOD_ID, "aufwind_entity"),
		QuiltEntityTypeBuilder.<AufwindEntity>create(SpawnGroup.MISC, AufwindEntity::new)
			.setDimensions(EntityDimensions.fixed(0.5F, 0.5F))
			.maxBlockTrackingRange(4).trackingTickInterval(10)
			.build());


	public static final EntityType<GreifenEntity> GreifenEntityType = Registry.register(

		Registry.ENTITY_TYPE,
		new Identifier(Hexerei.MOD_ID, "greifen_entity"),
		QuiltEntityTypeBuilder.<GreifenEntity>create(SpawnGroup.MISC, GreifenEntity::new)
			.setDimensions(EntityDimensions.fixed(0.5F, 0.5F))
			.maxBlockTrackingRange(4).trackingTickInterval(10)
			.build());
	public static void register() {
	}
}
