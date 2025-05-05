package net.withrage.creepydecorations.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.creepydecorations.CreepyDecorations;
import net.withrage.creepydecorations.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreepyDecorations.MOD_ID);

    public static final RegistryObject<Block> HAUNTED_PUMPKIN = registerBlock("haunted_pumpkin", () -> new HauntedPumpkin(BlockBehaviour.Properties.of()
            .noOcclusion().strength(2f).sound(SoundType.STEM).lightLevel(state -> 10).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BROKEN_DOLL = registerBlock("broken_doll", () -> new BrokenDoll(BlockBehaviour.Properties.of()
            .noOcclusion().strength(0.5f).sound(SoundType.WOOL).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOSSY_GRAVESTONE = registerBlock("mossy_gravestone", () -> new MossyGravestone(BlockBehaviour.Properties.of()
            .noOcclusion().strength(3f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WOODEN_CROSS = registerBlock("wooden_cross", () -> new WoodenCross(BlockBehaviour.Properties.of()
            .noOcclusion().strength(2f).sound(SoundType.WOOD).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEG_SHACKLE = registerBlock("leg_shackle", () -> new LegShackle(BlockBehaviour.Properties.of()
            .noOcclusion().strength(5f).sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EMERGING_HAND = registerBlock("emerging_hand", () -> new EmergingHand(BlockBehaviour.Properties.of()
            .noOcclusion().strength(0.5f).sound(SoundType.MUD).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        RegistryObject<T> block = ModBlocks.BLOCKS.register(name, blockSupplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
