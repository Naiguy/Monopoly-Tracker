package mply.winona.cs.CS471.monopoly.core;

import java.io.Serializable;

public class SavableGame implements Serializable {
	String p1name;
	String p2name;
	int p1loc;
	int p2loc;
	long p1cash;
	long p2cash;
	int currentTurn;
	int totalTurn;
	
	public SavableGame (MonopolyGame game) {
		p1name = game.getPlayers().get(0).getName();
		p2name = game.getPlayers().get(1).getName();
		p1loc = game.getPlayers().get(0).getLocation().getIndex();
		p2loc = game.getPlayers().get(1).getLocation().getIndex();
		p1cash = game.getPlayers().get(0).getNetWorth();
		p2cash = game.getPlayers().get(1).getNetWorth();
		currentTurn = game.getRoundsPlayed();
		totalTurn = game.getTotalRounds();
	}
	
	public SavableGame() {
		//default constructor all for our buddy jackson dude can't do jack without one.
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

	public int getTotalTurn() {
		return totalTurn;
	}

	public void setTotalTurn(int totalTurn) {
		this.totalTurn = totalTurn;
	}

	public String getP1name() {
		return p1name;
	}

	public void setP1name(String p1name) {
		this.p1name = p1name;
	}

	public String getP2name() {
		return p2name;
	}

	public void setP2name(String p2name) {
		this.p2name = p2name;
	}

	public int getP1loc() {
		return p1loc;
	}

	public void setP1loc(int p1loc) {
		this.p1loc = p1loc;
	}

	public int getP2loc() {
		return p2loc;
	}

	public void setP2loc(int p2loc) {
		this.p2loc = p2loc;
	}

	public long getP1cash() {
		return p1cash;
	}

	public void setP1cash(long p1cash) {
		this.p1cash = p1cash;
	}

	public long getP2cash() {
		return p2cash;
	}

	public void setP2cash(long p2cash) {
		this.p2cash = p2cash;
	}
	
	
	
	

}
