package net.cerulitys.mod.mixin;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Random;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(at = @At("HEAD"), method = "onBreak")
    private void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfo info){
        Block block = state.getBlock();
        Random rand = new Random();
        if ((block == Blocks.BEE_NEST || block == Blocks.BEEHIVE)){
            BeeEntity bee;
            bee = new BeeEntity(EntityType.BEE, world);
            bee.setPos(pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5);
            bee.setAngerTime(1200);
            bee.setAngryAt(player.getUuid());
            bee.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000000, 255, false, false));
            for (int i = 0; i < 200; i++) {
                world.spawnEntity(bee);
            }
            System.out.println("NOT THE BEEEEEEEEEEEEEEEEEEEES");
        }
        if (block == Blocks.TNT && !(player.getActiveItem().getItem() == Items.SHEARS)){
            TntEntity tnt = new TntEntity(EntityType.TNT, world);
            tnt.setPos(pos.getX()+0.5, pos.getY() + 0.01, pos.getZ()+0.5);
            tnt.setFuse(80);
            world.spawnEntity(tnt);
        }
    }
}