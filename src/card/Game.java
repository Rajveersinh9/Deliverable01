package card;

public class Game extends AbstractGame {

    public Game(String name) {
        super(name);
    }

    @Override
    protected AbstractPlayer createPlayer(String name) {
        return new Player(name);
    }

    @Override
    protected boolean checkForWinner() {
        for (AbstractPlayer player : players) {
            if (player.getNumOfSets() >= 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void declareWinner() {
        AbstractPlayer winner = null;
        int maxSets = 0;
        for (AbstractPlayer player : players) {
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
}
