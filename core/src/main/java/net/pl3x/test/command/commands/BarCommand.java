package net.pl3x.test.command.commands;

import com.mojang.brigadier.context.CommandContext;
import java.util.function.Function;
import net.pl3x.test.command.BaseCommand;
import net.pl3x.test.command.Sender;
import net.pl3x.test.command.Source;

public class BarCommand<T> extends BaseCommand<T> {
    public BarCommand(Function<T, Source> func) {
        super("bar", func);
        requires(source -> func.apply(source).getSender().hasPermission("bar.command.perm"));
    }

    @Override
    protected int execute(Source source, CommandContext<T> ctx) {
        Sender sender = source.getSender();
        sender.sendMessage("Bar!");
        return 1;
    }
}
