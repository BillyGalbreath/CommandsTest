package net.pl3x.test;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import java.util.function.Function;
import net.pl3x.test.command.PaperPlayer;
import net.pl3x.test.command.PaperSender;
import net.pl3x.test.command.PaperSource;
import net.pl3x.test.command.Source;
import net.pl3x.test.command.commands.BarCommand;
import net.pl3x.test.command.commands.FooCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Function<CommandSourceStack, Source> func = stack -> {
            CommandSender sender = stack.getSender();
            return new PaperSource(sender instanceof Player player
                    ? new PaperPlayer(player)
                    : new PaperSender(sender)
            );
        };

        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(new FooCommand<>(func).build(), "Testing foo");
            event.registrar().register(new BarCommand<>(func).build(), "Testing bar");
            event.registrar().register(LiteralArgumentBuilder.<CommandSourceStack>literal("test")
                    .executes(ctx -> {
                        ctx.getSource().getSender().sendMessage("testing 1 2 3");
                        return 1;
                    })
                    .build()
            );
        });
    }
}
