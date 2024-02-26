package com.thatoneaiguy.hexerei.item.spells;

import com.thatoneaiguy.hexerei.entities.AufwindEntity;
import com.thatoneaiguy.hexerei.entities.GreifenEntity;
import com.thatoneaiguy.hexerei.init.HexereiSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Greifen extends Item {
	public Greifen(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		ItemStack itemStack = user.getStackInHand(hand);
		user.getItemCooldownManager().set(this, 5);
		float pitch = .9f + (user.getRandom().nextFloat() * .2f);
		user.world.playSound(null, user.getBlockPos(), HexereiSoundEvents.SPELLCAST_SOUND_EVENT, SoundCategory.PLAYERS, 1.f, pitch);
		Vec3d vec3d = user.getRotationVec(1.0F);
		double x = user.getX() + vec3d.x;
		double y = user.getEyeY() + vec3d.y;
		double z = user.getZ() + vec3d.z;

		if (!world.isClient) {
			GreifenEntity greifenEntity = new GreifenEntity(world, user, x - user.getX(), y - user.getEyeY(), z - user.getZ());
			greifenEntity.setPosition(x, y, z);
			world.spawnEntity(greifenEntity);
		}

		return super.use(world, user, hand);
	}
}
