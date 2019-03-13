package mply.winona.cs.CS471.monopoly.core;

public class GameFormatter {
	private GameSerializer serializer;
	private GameDeserializer deserializer;
	
	public GameFormatter(GameSerializer serializer, GameDeserializer deserializer) {
		this.serializer = serializer;
		this.deserializer = deserializer;
	}

	public String serializeGame(SavableGame writableGame)
	{
		return serializer.serializeGame(writableGame);
	}
	
	public SavableGame deserializeGame(String gameStr) 
	{
		return deserializer.deserializeGame(gameStr);
	}
}
