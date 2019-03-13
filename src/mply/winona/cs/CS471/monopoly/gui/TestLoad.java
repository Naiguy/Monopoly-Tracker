package mply.winona.cs.CS471.monopoly.gui;

import mply.winona.cs.CS471.monopoly.core.GamePersistenceService;
import mply.winona.cs.CS471.monopoly.core.MonopolyGame;

public class TestLoad {

	public static void main(String[] args) {
		GamePersistenceService service = GamePersistenceService.getInstance();
		System.out.println("service created");
		String[] players = new String[2];
		players[0] = "Nai";
		players[1] = "Evan";
		System.out.println("players instantiated: " + players[0] + " and " + players[1]);
		int rounds = 15;
		System.out.println("rounds instantiated: " + rounds);
		MonopolyGame monopolyGame = new MonopolyGame(players, rounds);
		System.out.println("game created");
		monopolyGame.playGame();
		System.out.println("game played");
		service.saveGame(monopolyGame);
		System.out.println("game saved");
		MonopolyGame loadedGame = service.loadGame();
		System.out.println("game loaded");
		loadedGame.playGame();
		

	}

}
