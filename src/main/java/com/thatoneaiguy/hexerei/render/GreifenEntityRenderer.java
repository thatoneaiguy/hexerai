package com.thatoneaiguy.hexerei.render;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.entities.AufwindEntity;
import com.thatoneaiguy.hexerei.entities.GreifenEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class GreifenEntityRenderer extends ProjectileEntityRenderer<GreifenEntity> {
	public static final Identifier TEXTURE = new Identifier(Hexerei.MOD_ID, "textures/entity/shatterblade_entity.png");

	public GreifenEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(GreifenEntity entity) {
		return TEXTURE;
	}
}
