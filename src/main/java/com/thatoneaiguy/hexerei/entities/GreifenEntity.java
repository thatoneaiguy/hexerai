package com.thatoneaiguy.hexerei.entities;

import com.thatoneaiguy.hexerei.init.HexereiEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GreifenEntity extends PersistentProjectileEntity {
	LivingEntity player;

	public GreifenEntity(EntityType<? extends GreifenEntity> entityType, World world) {
		super(entityType, world);
		this.setSound(this.getHitSound());
		this.pickupType = PickupPermission.DISALLOWED;
	}

	public GreifenEntity(World world, LivingEntity user, double v, double v1, double v2) {
		super(HexereiEntities.GreifenEntityType, v, v1, v2, world);
		this.player = user;
		this.addVelocity(v * 3, v1 * 3, v2 * 3);
	}

	@Override
	protected ItemStack asItemStack() {
		return new ItemStack(Items.AIR);
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
	}

	@Override
	protected SoundEvent getHitSound() {
		return SoundEvents.BLOCK_GLASS_BREAK;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.world.isClient && !this.inGround) {
			this.world.addParticle(ParticleTypes.END_ROD, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
		}
		if (this.inGround) {
			for (int i = 0; i < 8; ++i) {
				this.kill();
			}
		}
		if (this.age > 50) {
			for (int i = 0; i < 8; ++i) {
				this.kill();
			}
		}
	}

	protected void onHit(LivingEntity target) {
		super.onHit(target);
		StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.LEVITATION, 100, 1);
		target.removeStatusEffect(StatusEffects.LEVITATION);
		double distance = target.squaredDistanceTo(player);
		double dx = Math.max(3, (target.getX() - player.getX()) * distance);
		double dy = Math.max(3, (target.getY() - player.getY()) / distance);
		double dz = Math.max(3, (target.getZ() - player.getZ()) * distance);
		target.addVelocity(-dx / 1.5, dy * 1.25 + 0.45, -dz / 1.5);

	}
}

