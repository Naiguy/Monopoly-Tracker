package mply.winona.cs.CS471.monopoly.commandLine;

import mply.winona.cs.CS471.monopoly.core.CommandLineGameReporter;
import mply.winona.cs.CS471.monopoly.core.GamePersistenceService;
import mply.winona.cs.CS471.monopoly.core.MonopolyGame;

public class Game {
	GamePersistenceService service = GamePersistenceService.getInstance();

	public static void usage() {
		System.out.println("java mply.winona.cs.CS471.monopoly.commandLine.Game ROUNDS PLAYER1 PLAYER2 [PLAYER]*\n");
	}
	
	public static void main(String[] args) {
	   if (args.length < 3) {
		   usage();
	   } else {
		   int rounds = Integer.parseInt(args[0]); 
		   String[] players = new String[args.length - 1];
		   for (int i = 0; i < args.length-1; i++) {
			   players[i] = args[i+1];
		   }
		   
		   MonopolyGame monopolyGame = new MonopolyGame(players, rounds);
		   CommandLineGameReporter lineReporter = new CommandLineGameReporter();
		   monopolyGame.addObserver(lineReporter);
		   System.out.println("GAME START STATE");
		   System.out.println(monopolyGame.toString());
		   
		  while (monopolyGame.getRoundsPlayed() < monopolyGame.getTotalRounds()) {
		   System.out.println("Running");
		   monopolyGame.playRound();
		   System.out.println((lineReporter.getCurrent()));
		   System.out.println("\n------------------------\n");
		   }
		   System.out.println("GAME END STATE");
		   
	   }

	}

}
