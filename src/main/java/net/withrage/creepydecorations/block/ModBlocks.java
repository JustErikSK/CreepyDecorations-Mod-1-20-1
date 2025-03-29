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
            .noOcclusion().strength(1f).sound(SoundType.STEM).lightLevel(state -> 10)));

    public static final RegistryObject<Block> BROKEN_DOLL = registerBlock("broken_doll", () -> new BrokenDoll(BlockBehaviour.Properties.of()
            .noOcclusion().strength(1f).sound(SoundType.WOOL)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
