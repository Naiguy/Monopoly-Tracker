package mply.winona.cs.CS471.monopoly.core;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserializer implements GameDeserializer {

	@Override
	public SavableGame deserializeGame(String serialized) {
		ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.readValue(serialized, SavableGame.class);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
	}
}
