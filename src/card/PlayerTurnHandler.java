/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.List;

public class PlayerTurnHandler {
    private final AbstractPlayer player;

    public PlayerTurnHandler(AbstractPlayer player) {
        this.player = player;
    }

    public void playTurn(AbstractGame game) {
        System.out.println(player.getName() + "'s turn:");
        displayHand();
        String action = InputHandler.getStringInput("Choose an action (draw/ask/exit): ").toLowerCase();

        while (!action.equals("draw") && !action.equals("ask") && !action.equals("exit")) {
            System.out.println("Invalid action. Please choose 'draw', 'ask', or 'exit'.");
            action = InputHandler.getStringInput("Choose an action (draw/ask/exit): ").toLowerCase();
        }

        if (action.equals("exit")) {
            System.out.println(player.getName() + " has chosen to exit the game.");
            System.exit(0);
        } else if (action.equals("draw")) {
            drawCard(game);
        } else if (action.equals("ask")) {
            askForCard(game);
        }
    }

    private void drawCard(AbstractGame game) {
        if (!player.getHand().isEmpty()) {
            Card drawnCard = game.getDeck().drawCard();
            if (drawnCard != null) {
                player.addCardToHand(drawnCard);
                System.out.println(player.getName() + " drew a card: " + drawnCard);
                player.checkForSets();
            } else {
                System.out.println("No more cards in the deck.");
            }
        } else {
            System.out.println(player.getName() + " has no cards left.");
        }
    }

    private void askForCard(AbstractGame game) {
        String rank = InputHandler.getStringInput("Enter the rank of the card to ask for: ");

        while (!isValidRank(rank)) {
            System.out.println("Invalid rank. Please enter a valid rank.");
            rank = InputHandler.getStringInput("Enter the rank of the card to ask for: ");
        }

        AbstractPlayer targetPlayer = choosePlayer(game);
        if (targetPlayer.hasCard(rank)) {
            Card transferredCard = targetPlayer.removeCardFromHand(rank);
            player.addCardToHand(transferredCard);
            System.out.println(player.getName() + " received " + rank + " from " + targetPlayer.getName());
            player.checkForSets();
        } else {
            System.out.println(targetPlayer.getName() + " does not have " + rank);
        }
    }

    private AbstractPlayer choosePlayer(AbstractGame game) {
        List<AbstractPlayer> players = game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).equals(player)) {
                System.out.println((i + 1) + ": " + players.get(i).getName());
            }
        }
        int playerIndex = InputHandler.getIntInput("Choose a player to ask (number): ") - 1;
        while (playerIndex < 0 || playerIndex >= players.size() || players.get(playerIndex).equals(player)) {
            playerIndex = InputHandler.getIntInput("Invalid choice. Choose a player to ask (number): ") - 1;
        }
        return players.get(playerIndex);
    }

    private void displayHand() {
        System.out.println("Current hand:");
        for (Card card : player.getHand()) {
            System.out.println(card);
        }
    }

    private boolean isValidRank(String rank) {
        String[] validRanks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};
        for (String r : validRanks) {
            if (r.equals(rank.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
