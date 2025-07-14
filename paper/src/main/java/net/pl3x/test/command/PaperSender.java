package net.pl3x.test.command;

import org.bukkit.command.CommandSender;

public class PaperSender implements Sender {
    private final CommandSender sender;

    public PaperSender(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(String message) {
        this.sender.sendMessage(message);
    }
}
