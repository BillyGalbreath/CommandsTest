package net.pl3x.test.command.commands;

import com.mojang.brigadier.context.CommandContext;
import net.pl3x.test.command.BaseCommand;
import net.pl3x.test.command.Player;
import net.pl3x.test.command.Sender;
import net.pl3x.test.command.Source;

public class FooCommand extends BaseCommand {
    public FooCommand() {
        super("foo");
        requires(source -> source.getSender().hasPermission("foo.command.perm"));
    }

    @Override
    protected int execute(CommandContext<Source> ctx) {
        Source source = ctx.getSource();
        Sender sender = source.getSender();
        sender.sendMessage("Foo!");

        if (sender instanceof Player player) {
            player.sendMessage("You're a player, %s!".formatted(player.getName()));
        }
        return 1;
    }
}
