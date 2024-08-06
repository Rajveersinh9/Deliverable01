package card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends AbstractPlayer {

    private final PlayerTurnHandler turnHandler;

    public Player(String name) {
        super(name);
        this.turnHandler = new PlayerTurnHandler(this);
    }

    @Override
    public void playTurn(AbstractGame game) {
        turnHandler.playTurn(game);
    }

    @Override
    protected void checkForSets() {
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
}
