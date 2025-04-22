package net.withrage.creepydecorations.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.creepydecorations.CreepyDecorations;
import net.withrage.creepydecorations.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreepyDecorations.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREEPY_DECORATIONS_CREATIVE_TAB = CREATIVE_MODE_TABS.register("creepy_decorations_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.HAUNTED_PUMPKIN.get()))
                    .title(Component.translatable("creativetab.creepydecorations.creepy_decorations_creative_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.HAUNTED_PUMPKIN.get());
                        output.accept(ModBlocks.BROKEN_DOLL.get());
                        output.accept(ModBlocks.MOSSY_GRAVESTONE.get());
                        output.accept(ModBlocks.WOODEN_CROSS.get());
                        output.accept(ModBlocks.LEG_SHACKLE.get());
                        output.accept(ModBlocks.EMERGING_HAND.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
