package net.cerulitys.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.AutoInvokingEvent;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cerulity implements ModInitializer
{
    public static final Item LPOWDER_ITEM = new PrankGunpowder(new Item.Settings().group(ItemGroup.MISC));
    public static final Block LPOWDER_BLOCK = new PrankPowderBlock();
    public static List<Identifier> everyItem = new ArrayList();
    public static List<String> everyItemStr = new ArrayList();

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier("cerulity", "prank_gunpowder"), LPOWDER_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("cerulity", "prank_gunpowder_block"), LPOWDER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("cerulity", "prank_gunpowder_block"), new BlockItem(LPOWDER_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        for (Item item : Registry.ITEM) {
            System.out.println(Registry.ITEM.getKey(item).get().getValue().toString());
        }
        everyItem = Registry.ITEM.stream().map(Registry.ITEM::getId).toList();
        for (Identifier item : everyItem) {
            everyItemStr.add(item.toString());
        }
    }
}