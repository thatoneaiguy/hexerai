package com.thatoneaiguy.hexerei.block;

import com.sammy.lodestone.handlers.RenderHandler;
import com.sammy.lodestone.network.screenshake.PositionedScreenshakePacket;
import com.sammy.lodestone.setup.LodestoneRenderLayers;
import com.sammy.lodestone.systems.rendering.particle.Easing;
import com.sammy.lodestone.systems.rendering.particle.ParticleBuilders;
import com.thatoneaiguy.hexerei.Hexerei;
import com.thatoneaiguy.hexerei.init.HexereiItems;
import com.thatoneaiguy.hexerei.init.HexereiParticles;
import com.thatoneaiguy.hexerei.init.HexereiSoundEvents;
import io.netty.buffer.Unpooled;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

import static java.lang.Thread.sleep;

public class Pedestal extends Block {
	public Pedestal(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(player.getStackInHand(hand).isOf(HexereiItems.IDFK)) {
			if(world instanceof ServerWorld s) {
				PlayerEntity user = player;
				s.getPlayers(players -> players.getWorld().isChunkLoaded(new ChunkPos(user.getBlockPos()).x, new ChunkPos(user.getBlockPos()).z)).forEach(players -> {
					PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
					new PositionedScreenshakePacket(120, Vec3d.ofCenter(pos),20f, 0.3f, 25f, Easing.CIRC_OUT).setIntensity(0f, 9f, 0f).setEasing(Easing.CIRC_OUT, Easing.CIRC_IN).write(buf);
					ServerPlayNetworking.send(players, PositionedScreenshakePacket.ID, buf);
				});
            }
			ParticleBuilders.create(HexereiParticles.RITUAL_BLOOM)
				.setScale((3f + world.random.nextFloat() * 5f))
				.setColor(Hexerei.MAGIC_BLUE, Hexerei.MAGIC_BLUE)
				.setAlpha(0, 1f, 0)
				.setAlphaEasing(Easing.EXPO_OUT, Easing.SINE_OUT)
				.enableNoClip()
				.setLifetime(240)
				.spawn(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
			ParticleBuilders.create(HexereiParticles.RITUAL_BLOOM)
				.setScale((3f + world.random.nextFloat() * 5f))
				.setColor(Hexerei.MAGIC_BLUE, Hexerei.MAGIC_BLUE)
				.setAlpha(0, 1f, 0)
				.setAlphaEasing(Easing.EXPO_OUT, Easing.SINE_OUT)
				.enableNoClip()
				.setLifetime(240)
				.spawn(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
			ParticleBuilders.create(HexereiParticles.FLARE)
				.setScale((6f + world.random.nextFloat() * 5f))
				.setAlpha(0, 1f, 0)
				.setAlphaEasing(Easing.EXPO_OUT, Easing.SINE_OUT)
				.enableNoClip()
				.setLifetime(40)
				.spawn(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
			ParticleBuilders.create(HexereiParticles.SMOKE)
				.setScale((5f + world.random.nextFloat() * 5f))
				.setAlpha(0, 1f, 0)
				.setAlphaEasing(Easing.EXPO_OUT, Easing.SINE_OUT)
				.enableNoClip()
				.setLifetime(100)
				.spawn(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
			ParticleBuilders.create(HexereiParticles.EXPLOSION)
				.setScale((4f + world.random.nextFloat() * 5f))
				.setAlpha(0, 1f, 0)
				.setAlphaEasing(Easing.EXPO_OUT, Easing.SINE_OUT)
				.enableNoClip()
				.setLifetime(70)
				.spawn(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);

			world.playSound(null, pos, HexereiSoundEvents.BOOM_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);

			world.playSound(null, pos, HexereiSoundEvents.RINGING_SOUND_EVENT, SoundCategory.BLOCKS, 1f, 1f);
		}

		return super.onUse(state, world, pos, player, hand, hit);
	}
}

