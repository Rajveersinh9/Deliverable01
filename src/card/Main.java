package card;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("Go Fish", 4);

        // Display the cards in the deck
        for (Card card : game.getDeck().getCards()) {
            System.out.println(card);
        }

        // Play the game
        game.play();
    }
}
