/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame {
    protected String name;
    protected List<AbstractPlayer> players;
    protected Deck deck;
    protected int currentPlayerIndex;

    public AbstractGame(String name) {
        this.name = name;
        this.deck = Deck.getInstance();
        this.currentPlayerIndex = 0;
    }

    protected abstract AbstractPlayer createPlayer(String name);

    public void initializeGame(int numOfPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            String playerName = InputHandler.getStringInput("Enter name for Player " + (i + 1) + ": ");
            this.players.add(createPlayer(playerName));
        }
        dealCards();
    }

    public void play() {
        System.out.println("Starting the game: " + name);
        int maxTurns = 50;
        int turns = 0;

        while (!checkForWinner() && !deck.getCards().isEmpty() && turns < maxTurns) {
            AbstractPlayer currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.playTurn(this);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            turns++;
        }
        declareWinner();
    }

    protected void dealCards() {
        deck.shuffle();
        for (int i = 0; i < 5; i++) {
            for (AbstractPlayer player : players) {
                player.addCardToHand(deck.drawCard());
            }
        }
    }

    protected abstract boolean checkForWinner();
    protected abstract void declareWinner();

    public Deck getDeck() {
        return deck;
    }

    public List<AbstractPlayer> getPlayers() {
        return players;
    }
}
