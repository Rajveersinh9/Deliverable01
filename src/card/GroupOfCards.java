package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private int size;
    private List<Card> cards;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
