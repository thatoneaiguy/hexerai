package com.thatoneaiguy.hexerei.block;

import com.sammy.lodestone.network.screenshake.PositionedScreenshakePacket;
import com.sammy.lodestone.setup.LodestoneParticles;
import com.sammy.lodestone.setup.LodestoneScreenParticles;
import com.sammy.lodestone.systems.rendering.particle.Easing;
import com.sammy.lodestone.systems.rendering.particle.ParticleBuilders;
import com.sammy.lodestone.systems.rendering.particle.type.LodestoneParticleType;
import com.thatoneaiguy.hexerei.init.HexereiItems;
import io.netty.buffer.Unpooled;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.codec.binary.Hex;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

public class Pedestal extends Block {
	public Pedestal(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(player.getStackInHand(hand).isOf(HexereiItems.IDFK)) {
			ritual(world, player, pos);
		}
		return super.onUse(state, world, pos, player, hand, hit);
	}

	private void ritual(World world, PlayerEntity player, BlockPos pos) {
		if(world instanceof ServerWorld s) {
			PlayerEntity user = player;
			s.getPlayers(players -> players.getWorld().isChunkLoaded(new ChunkPos(user.getBlockPos()).x, new ChunkPos(user.getBlockPos()).z)).forEach(players -> {
				PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
				new PositionedScreenshakePacket(120, Vec3d.ofCenter(pos),20f, 0.3f, 25f, Easing.CIRC_IN).setIntensity(0f, 9f, 0f).setEasing(Easing.CIRC_OUT, Easing.CIRC_IN).write(buf);
				ServerPlayNetworking.send(players, PositionedScreenshakePacket.ID, buf);
			});
		}
	}
}

