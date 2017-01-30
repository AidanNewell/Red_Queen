package Yahtzee;

public class YahtzeeGamePlayer extends GamePlayer{

	private AbstractComputerYahtzeePlayer player;
	private YahtzeeGame game;
	@Override
	public double playGame(Strategy strat) throws StrategyCrashedException {
		player = (AbstractComputerYahtzeePlayer)strat;
		game = new YahtzeeGame();
		return game.yahtzeeGame(player);
	}

}
