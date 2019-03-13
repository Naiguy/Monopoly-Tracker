package mply.winona.cs.CS471.monopoly.core;

public class FormatterFactory {

	public static GameFormatter getFormatter(String filepath) {
		
		final String JSON_FILE_ENDING = ".json";
		final String JAVA_FILE_ENDING = ".ser";
		
		if (filepath.contains(JSON_FILE_ENDING)) {
			return new GameFormatter(new JsonSerializer(), new JsonDeserializer());
		}
		
		else if (filepath.contains(JAVA_FILE_ENDING)) {
			return new GameFormatter(new JavaSerializer(), new JavaDeserializer());
		}
		
		else {
			System.out.println("Unrecognized file extension... please verify.");
			return null;
		}
		
		
		

	}

}
