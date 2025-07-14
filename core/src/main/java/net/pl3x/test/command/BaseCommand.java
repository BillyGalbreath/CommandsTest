package net.pl3x.test.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.function.Function;

public abstract class BaseCommand<T> extends LiteralArgumentBuilder<T> {
    protected final Function<T, Source> func;

    protected BaseCommand(String name, Function<T, Source> func) {
        super(name);
        executes(this::execute);
        this.func = func;
    }

    protected int execute(CommandContext<T> ctx) {
        return this.execute(func.apply(ctx.getSource()), ctx);
    }

    protected abstract int execute(Source src, CommandContext<T> ctx);
}
