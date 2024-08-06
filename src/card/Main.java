package card;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Card Game!");
        int numOfPlayers = InputHandler.getIntInput("Enter the number of players (2 or 4): ");
        while (numOfPlayers != 2 && numOfPlayers != 4) {
            numOfPlayers = InputHandler.getIntInput("Invalid input. Please enter 2 or 4: ");
        }

        Game game = new Game("Go Fish");
        game.initializeGame(numOfPlayers);

        game.play();
    }
}
