package net.cerulitys.mod;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PrankGunpowder extends Item {
    public PrankGunpowder(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        Vec3d look = player.getRotationVector();
        Vec3d pos = player.getPos();
        player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0F, 0.5F);
        player.setVelocity(look.x*2, look.y*2, look.z*2);
        for (int i = 0; i < 20; i++){
            world.addParticle(ParticleTypes.FLAME, pos.x + Math.random()*1.5-0.75, pos.y+Math.random()*1.5-0.25, pos.z+Math.random()*1.5-0.75, 0, 0, 0);
        }

        if(!player.isCreative()){
            player.getStackInHand(hand).setCount(player.getStackInHand(hand).getCount() - 1);
        }
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, player.getStackInHand(hand));
    }
}
