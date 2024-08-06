package card;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final String name;
    private final List<Player> players;
    private final Deck deck;
    private int currentPlayerIndex;

    public Game(String name, int numOfPlayers) {
        this.name = name;
        this.players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            String playerName = InputHandler.getStringInput("Enter name for Player " + (i + 1) + ": ");
            this.players.add(new Player(playerName));
        }
        this.deck = Deck.getInstance();
        this.currentPlayerIndex = 0;
        dealCards();
    }

    public void play() {
        System.out.println("Starting the game: " + name);
        int maxTurns = 50; // Set a maximum number of turns
        int turns = 0;

        while (!checkForWinner() && !deck.getCards().isEmpty() && turns < maxTurns) {
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.playTurn(this);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            turns++;
        }
        declareWinner();
    }

    public void declareWinner() {
        Player winner = null;
        int maxSets = 0;
        for (Player player : players) {
            int playerSets = player.getNumOfSets();
            if (playerSets > maxSets) {
                maxSets = playerSets;
                winner = player;
            }
        }
        if (winner != null) {
            System.out.println(winner.getName() + " wins with " + maxSets + " sets!");
        } else {
            System.out.println("No winner. The deck is empty.");
        }
    }

    private void dealCards() {
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.addCardToHand(deck.drawCard());
            }
        }
    }

    private boolean checkForWinner() {
        for (Player player : players) {
            if (player.getNumOfSets() >= 4) {  // Example winning condition
                return true;
            }
        }
        return false;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
