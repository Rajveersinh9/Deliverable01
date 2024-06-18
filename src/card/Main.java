package card;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Alice");
        Game game = new Game("Go Fish", player);
        GroupOfCards deck = new GroupOfCards(52);

        // Add some cards to the deck
        deck.addCard(new Card("Hearts", "Ace"));
        deck.addCard(new Card("Spades", "King"));

        // Shuffle the deck
        deck.shuffle();

        // Display the cards in the deck
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }

        // Play the game
        game.play();

        // Declare the winner
        game.declareWinner();
    }
}
