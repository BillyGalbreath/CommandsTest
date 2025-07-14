package net.pl3x.test;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.pl3x.test.command.commands.BarCommand;
import net.pl3x.test.command.commands.FooCommand;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public class TestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(new FooCommand().build(), "Testing foo");
            event.registrar().register(new BarCommand().build(), "Testing bar");
        });
    }
}
