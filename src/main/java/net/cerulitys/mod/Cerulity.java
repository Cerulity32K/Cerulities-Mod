package net.cerulitys.mod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Cerulity implements ModInitializer
{
    public static final Item LPOWDER_ITEM = new PrankGunpowder(new Item.Settings().group(ItemGroup.MISC));
    public static final Block LPOWDER_BLOCK = new PrankPowderBlock();

    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier("cerulity", "prank_gunpowder"), LPOWDER_ITEM);
        Registry.register(Registry.BLOCK, new Identifier("cerulity", "prank_gunpowder_block"), LPOWDER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("cerulity", "prank_gunpowder_block"), new BlockItem(LPOWDER_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
    }
}