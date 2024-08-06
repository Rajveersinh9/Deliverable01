/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer {
    protected String name;
    protected List<Card> hand;
    protected int sets;

    public AbstractPlayer(String name) {
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

    public abstract void playTurn(AbstractGame game);

    protected abstract void checkForSets();

    public int getNumOfSets() {
        return sets;
    }
}

