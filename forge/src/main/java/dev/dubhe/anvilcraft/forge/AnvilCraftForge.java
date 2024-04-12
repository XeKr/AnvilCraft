package dev.dubhe.anvilcraft.forge;

import dev.dubhe.anvilcraft.AnvilCraft;
import dev.dubhe.anvilcraft.config.AnvilCraftConfig;
import dev.dubhe.anvilcraft.init.ModCommands;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod(AnvilCraft.MOD_ID)
public class AnvilCraftForge {
    /**
     * Forge 侧初始化
     */
    public AnvilCraftForge() {
        AnvilCraft.init();
        MinecraftForge.EVENT_BUS.addListener(AnvilCraftForge::registerCommand);

        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                    (mc, screen) -> AutoConfig.getConfigScreen(AnvilCraftConfig.class, screen).get()
                )
        );
    }

    public static void registerCommand(@NotNull RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }
}