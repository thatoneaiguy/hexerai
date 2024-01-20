package com.thatoneaiguy.hexerei.item;

import com.sammy.lodestone.LodestoneLib;
import com.sammy.lodestone.network.screenshake.PositionedScreenshakePacket;
import com.sammy.lodestone.setup.LodestoneParticles;
import com.sammy.lodestone.systems.rendering.particle.Easing;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;

public class KugelScroll extends Item {

	public KugelScroll(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		return super.useOnBlock(context);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		return TypedActionResult.success(player.getStackInHand(hand));
	}

	private void spawnParticleLine(ServerWorld world, Vec3d startPos, float yaw, float pitch, PlayerEntity player) {
//make 15 lbokc rayccasr

		double startX = player.getX();
		double startY = player.getEyeY() - 1.2;
		double startZ = player.getZ();

		double endX = startX + 15;
		double endY = startY;
		double endZ = startZ + 15;

		int numParticles = 25;
		double particleSpread = 0.1;

		for (int i = 0; i < numParticles; i++) {
			double t = (double) i / (double) numParticles;
			double posX = startX + (endX - startX) * t;
			double posY = startY + (endY - startY) * t;
			double posZ = startZ + (endZ - startZ) * t;

			double offsetX = (player.world.random.nextDouble() - 0.5) * particleSpread;
			double offsetY = (player.world.random.nextDouble() - 0.5) * particleSpread;
			double offsetZ = (player.world.random.nextDouble() - 0.5) * particleSpread;

			for (PlayerEntity otherPlayer : player.world.getPlayers()) {
				otherPlayer.world.addParticle(ParticleTypes.END_ROD, posX + offsetX, posY + offsetY, posZ + offsetZ, 0.0, 0.0, 0.0);
			}
		}
	}
}
