package net.cerulitys.mod;


import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientBlockEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.BlockEvent;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PrankPowderBlock extends Block {
    public PrankPowderBlock() {
        super(FabricBlockSettings.copyOf(Blocks.SAND).breakByTool(FabricToolTags.SHOVELS).noCollision());
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Vec3d look = player.getRotationVector();
        Vec3d playerPos = player.getPos();
        player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0F, 0.5F);
        player.setVelocity(look.x*2, look.y*2, look.z*2);
        for (int i = 0; i < 20; i++){
            world.addParticle(ParticleTypes.FLAME, playerPos.x + Math.random()*1.5-0.75, playerPos.y+Math.random()*1.5-0.25, playerPos.z+Math.random()*1.5-0.75, 0, 0, 0);
        }
        return ActionResult.SUCCESS;
    }
}
