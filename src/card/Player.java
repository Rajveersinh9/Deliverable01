package card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final String name;
    private final List<Card> hand;
    private int sets;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.sets = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
        checkForSets();
    }

    public Card removeCardFromHand(String rank) {
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                hand.remove(card);
                return card;
            }
        }
        return null;
    }

    public boolean hasCard(String rank) {
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    public void playTurn(Game game) {
        System.out.println(name + "'s turn:");
        displayHand();
        String action = InputHandler.getStringInput("Choose an action (draw/ask/exit): ").toLowerCase();

        while (!action.equals("draw") && !action.equals("ask") && !action.equals("exit")) {
            System.out.println("Invalid action. Please choose 'draw', 'ask', or 'exit'.");
            action = InputHandler.getStringInput("Choose an action (draw/ask/exit): ").toLowerCase();
        }

        if (action.equals("exit")) {
            System.out.println(name + " has chosen to exit the game.");
            System.exit(0);
        } else if (action.equals("draw")) {
            drawCard(game);
        } else if (action.equals("ask")) {
            askForCard(game);
        }
    }

    private void drawCard(Game game) {
        if (!hand.isEmpty()) {
            Card drawnCard = game.getDeck().drawCard();
            if (drawnCard != null) {
                hand.add(drawnCard);
                System.out.println(name + " drew a card: " + drawnCard);
                checkForSets();
            } else {
                System.out.println("No more cards in the deck.");
            }
        } else {
            System.out.println(name + " has no cards left.");
        }
    }

    private void askForCard(Game game) {
        String rank = InputHandler.getStringInput("Enter the rank of the card to ask for: ").trim();
        
        while (!isValidRank(rank)) {
            System.out.println("Invalid rank. Please enter a valid rank.");
            rank = InputHandler.getStringInput("Enter the rank of the card to ask for: ").trim();
        }

        Player targetPlayer = choosePlayer(game);
        if (targetPlayer.hasCard(rank)) {
            Card transferredCard = targetPlayer.removeCardFromHand(rank);
            hand.add(transferredCard);
            System.out.println(name + " received " + rank + " from " + targetPlayer.getName());
            checkForSets();
        } else {
            System.out.println(targetPlayer.getName() + " does not have " + rank);
        }
    }

    private Player choosePlayer(Game game) {
        List<Player> players = game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).equals(this)) {
                System.out.println((i + 1) + ": " + players.get(i).getName());
            }
        }
        int playerIndex = InputHandler.getIntInput("Choose a player to ask (number): ") - 1;
        while (playerIndex < 0 || playerIndex >= players.size() || players.get(playerIndex).equals(this)) {
            playerIndex = InputHandler.getIntInput("Invalid choice. Choose a player to ask (number): ") - 1;
        }
        return players.get(playerIndex);
    }

    public int getNumOfSets() {
        return sets;
    }

    private void checkForSets() {
        Map<String, Integer> rankCount = new HashMap<>();
        List<Card> cardsToRemove = new ArrayList<>();

        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
            if (rankCount.get(card.getRank()) == 4) {
                sets++;
                for (Card c : hand) {
                    if (c.getRank().equals(card.getRank())) {
                        cardsToRemove.add(c);
                    }
                }
            }
        }
        hand.removeAll(cardsToRemove);
    }

    private void displayHand() {
        System.out.println("Current hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    private boolean isValidRank(String rank) {
        String[] validRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String r : validRanks) {
            if (r.equals(rank)) {
                return true;
            }
        }
        return false;
    }
}

