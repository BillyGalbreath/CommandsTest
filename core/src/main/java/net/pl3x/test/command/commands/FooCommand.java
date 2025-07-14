package net.pl3x.test.command.commands;

import com.mojang.brigadier.context.CommandContext;
import java.util.function.Function;
import net.pl3x.test.command.BaseCommand;
import net.pl3x.test.command.Player;
import net.pl3x.test.command.Sender;
import net.pl3x.test.command.Source;

public class FooCommand<T> extends BaseCommand<T> {
    public FooCommand(Function<T, Source> func) {
        super("foo", func);
        requires(source -> func.apply(source).getSender().hasPermission("foo.command.perm"));
    }

    @Override
    protected int execute(Source source, CommandContext<T> ctx) {
        Sender sender = source.getSender();
        sender.sendMessage("Foo!");

        if (sender instanceof Player player) {
            player.sendMessage("You're a player, %s!".formatted(player.getName()));
        }
        return 1;
    }
}
