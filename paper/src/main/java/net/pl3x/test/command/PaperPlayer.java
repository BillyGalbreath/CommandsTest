package net.pl3x.test.command;

public class PaperPlayer extends PaperSender implements Player {
    private final org.bukkit.entity.Player player;

    public PaperPlayer(org.bukkit.entity.Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public String getName() {
        return this.player.getName();
    }
}
