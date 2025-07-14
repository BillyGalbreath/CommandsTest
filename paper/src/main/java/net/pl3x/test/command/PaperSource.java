package net.pl3x.test.command;

public class PaperSource implements Source {
    private final PaperSender sender;

    public PaperSource(PaperSender sender) {
        this.sender = sender;
    }

    @Override
    public PaperSender getSender() {
        return this.sender;
    }
}
