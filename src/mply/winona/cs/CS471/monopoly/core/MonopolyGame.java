package mply.winona.cs.CS471.monopoly.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
	

public class MonopolyGame extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final long START_CASH = 1500;
	private int roundsPlayed = 0;
	private int totalRounds;
	private List<Player> players;
	private Board board = new Board();
	private Die[] dice = { new Die(), new Die() };
	private GamePersistenceService persistenceService = GamePersistenceService.getInstance();
	
	public MonopolyGame(String[] inPlayers, int totalRounds) {
		players = new ArrayList<Player>(inPlayers.length);
		for (int i = 0; i < inPlayers.length; i++) {
			Player p;
			p = new Player(inPlayers[i], dice, board);
			players.add(p);
		}
		this.totalRounds = totalRounds;
	}

	public MonopolyGame(SavableGame game) {
		players = new ArrayList<Player>(2);
		String inPlayers[] = new String[2];
		inPlayers[0] = game.p1name;
		inPlayers[1] = game.p2name;
	
		Player p1 = new Player(inPlayers[0], dice, board, game.getP1cash(), game.getP1loc());
		players.add(p1);
		Player p2 = new Player(inPlayers[1], dice, board, game.getP2cash(), game.getP2loc());
		players.add(p2);
		this.totalRounds = game.getTotalTurn();
		this.roundsPlayed = game.getCurrentTurn();

	}
	
	public void addRounds(int addRounds) { 
		totalRounds += addRounds; 
	}
	
	public void ringTheBell() {
		setChanged();
		notifyObservers(this.toString());
	}
	
	
	public void playGame() {
		while (roundsPlayed < totalRounds) {
			playRound();
		}
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	
	public int getRoundsPlayed() {
		return roundsPlayed;
	}

	public void setRoundsPlayed(int roundsPlayed) {
		this.roundsPlayed = roundsPlayed;
	}

	public int getTotalRounds() {
		return totalRounds;
	}

	public void setTotalRounds(int totalRounds) {
		this.totalRounds = totalRounds;
	}

	public void playRound() {
		for (Iterator<Player> iter = players.iterator(); iter.hasNext();) {
			Player player = (Player) iter.next();
			player.takeTurn();
		}
		roundsPlayed++;
		//persistenceService.saveGame(this);
		ringTheBell();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Rounds Played: " + roundsPlayed + "/" + totalRounds + "\n");
		for (Iterator<Player> iter = players.iterator(); iter.hasNext();) {
			Player player = (Player) iter.next();
			sb.append("Player: ");
			sb.append(player.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	public GamePersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(GamePersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
}
