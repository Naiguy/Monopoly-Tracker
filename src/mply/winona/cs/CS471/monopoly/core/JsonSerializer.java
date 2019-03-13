package mply.winona.cs.CS471.monopoly.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer implements GameSerializer {

	@Override
	public String serializeGame(SavableGame game) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(game);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			System.out.println("java serialization failure");
			return null;
		}
	}
	
	
	
}
