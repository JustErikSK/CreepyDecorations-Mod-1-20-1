package net.withrage.creepydecorations.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.withrage.creepydecorations.CreepyDecorations;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreepyDecorations.MOD_ID);

    public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
    }

}
