package mply.winona.cs.CS471.monopoly.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class JavaDeserializer implements GameDeserializer {

	@Override
	/*
	public SavableGame deserializeGame(String serialized) {
		
		ByteArrayInputStream byteStream = new ByteArrayInputStream(serialized.getBytes());
		try {
			ObjectInputStream inStream = new ObjectInputStream(byteStream);
			return (SavableGame) inStream.readObject();
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}
	*/
	
public SavableGame deserializeGame(String serialized) {
		
	try {
	     byte b[] = Base64.getDecoder().decode(serialized); 
	     ByteArrayInputStream bi = new ByteArrayInputStream(b);
	     ObjectInputStream si = new ObjectInputStream(bi);
	     SavableGame game = (SavableGame) si.readObject();
			return game;
	 } catch (Exception e) {
	     System.out.println(e);
	     return null;
	 }

	}
	
	
	
	
	public String serializeGame(MonopolyGame game) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outStream;
		try {
			outStream = new ObjectOutputStream( byteStream );
			outStream.writeObject(game);
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return Base64.getEncoder().encodeToString(byteStream.toByteArray()); 
	}

}
