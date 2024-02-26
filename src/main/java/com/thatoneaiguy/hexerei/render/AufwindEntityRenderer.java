package com.thatoneaiguy.hexerei.render;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.entities.AufwindEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class AufwindEntityRenderer extends ProjectileEntityRenderer<AufwindEntity> {
	public static final Identifier TEXTURE = new Identifier(Hexerei.MOD_ID, "textures/entity/shatterblade_entity.png");

	public AufwindEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(AufwindEntity entity) {
		return TEXTURE;
	}
}
