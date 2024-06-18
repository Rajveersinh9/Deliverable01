package card;

public class Game {
    private String name;
    private Player player;

    public Game(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void play() {
        System.out.println("Playing the game...");
        // Example play implementation
    }

    public void declareWinner() {
        System.out.println("Declaring the winner...");
        // Example declare winner implementation
    }
}
