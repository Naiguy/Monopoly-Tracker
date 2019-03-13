package mply.winona.cs.CS471.monopoly.core;

public interface GameDeserializer {
	SavableGame deserializeGame(String serialized);
}
