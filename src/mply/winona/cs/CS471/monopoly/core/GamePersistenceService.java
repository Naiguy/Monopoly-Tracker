package mply.winona.cs.CS471.monopoly.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//implement singleton
public class GamePersistenceService {
	
	private static final String filepathJSON = "SavedGame.json";
	private static final String filepathJAVA = "SavedGame.ser";
	//switch this next String between the two above to test each.
	private static String filepath = filepathJAVA;
	private GameFormatter formatter;
	private static final GamePersistenceService INSTANCE = new GamePersistenceService(filepath);
	//set filepath to filepathJAVA or filepathJSON to test each one.
	//theoretically, you could add any number of filepaths here, 
	//and the app would figure out which way to save the gamestate.

	
	public void setFilepathToJSON() {
		filepath = filepathJSON;
	}
	
	public void setFilepathToJAVA() {
		filepath = filepathJAVA;
	}
	
	private GamePersistenceService(String filepath) {
		this.formatter = FormatterFactory.getFormatter(filepath);
	}
	
	public static GamePersistenceService getInstance() {
		return INSTANCE;
	}
	
	public void saveGame(MonopolyGame game) {
		SavableGame writableGame = new SavableGame(game);
		String formattedGame = formatter.serializeGame(writableGame);
		writeToFile(formattedGame);
	}
	
	public MonopolyGame loadGame() {
		String formattedGame = readFromFile();
		MonopolyGame game = new MonopolyGame(formatter.deserializeGame(formattedGame));
		return game;
	}
	
	private void writeToFile(String str) {
	     
		    BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(filepath));
			    writer.write(str);
			    writer.flush();
			    writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	private String readFromFile() {
		
		BufferedReader bufferedReader = null;
        try
        {
            String currLine;
            String result = "";
 
            bufferedReader = new BufferedReader(new FileReader(filepath));
 
            while ((currLine = bufferedReader.readLine()) != null)
            {
                result = result + currLine;
            }
            bufferedReader.close();
            return result;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

	}
}
