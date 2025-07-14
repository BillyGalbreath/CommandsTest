package net.pl3x.test.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

public abstract class BaseCommand extends LiteralArgumentBuilder<Source> {
    protected BaseCommand(String name) {
        super(name);
    }

    protected abstract int execute(CommandContext<Source> ctx);
}
