package com.thatoneaiguy.hexerei.entities;

import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.init.HexereiEntities;
import com.thatoneaiguy.hexerei.init.HexereiSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class AufwindEntity extends PersistentProjectileEntity {
	LivingEntity player;

	public AufwindEntity(EntityType<? extends AufwindEntity> entityType, World world) {
		super(entityType, world);
		this.setSound(this.getHitSound());
		this.pickupType = PickupPermission.DISALLOWED;
	}

	public AufwindEntity(World world, LivingEntity user, double v, double v1, double v2) {
		super(HexereiEntities.AufwindEntityType, v, v1, v2, world);
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
		target.addStatusEffect(statusEffectInstance, this.getEffectCause());
	}
}

