package card;



public class Game {

	private String name;
	private Player player;

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void play() {
		// TODO - implement Game.play
		throw new UnsupportedOperationException();
	}

	public void declareWinner() {
		// TODO - implement Game.declareWinner
		throw new UnsupportedOperationException();
	}

}