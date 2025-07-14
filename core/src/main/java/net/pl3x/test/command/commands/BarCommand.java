package net.pl3x.test.command.commands;

import com.mojang.brigadier.context.CommandContext;
import net.pl3x.test.command.BaseCommand;
import net.pl3x.test.command.Sender;
import net.pl3x.test.command.Source;

public class BarCommand extends BaseCommand {
    public BarCommand() {
        super("bar");
        requires(source -> source.getSender().hasPermission("bar.command.perm"));
    }

    @Override
    protected int execute(CommandContext<Source> ctx) {
        Source source = ctx.getSource();
        Sender sender = source.getSender();
        sender.sendMessage("Bar!");
        return 1;
    }
}
