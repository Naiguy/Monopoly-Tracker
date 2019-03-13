package mply.winona.cs.CS471.monopoly.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class JavaSerializer implements GameSerializer {

	@Override
	/*
	public String serializeGame(SavableGame game) {
		 String serializedObject = "";

		 // serialize the object
		 try {
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(game);
		     so.flush();
		     serializedObject = bo.toString();
		 } catch (Exception e) {
		     System.out.println(e);
		 }
		return serializedObject;
	}

	*/
	
	public String serializeGame(SavableGame game) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outStream;
  
		try {
			outStream = new ObjectOutputStream( byteStream );
			outStream.writeObject(game);
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = Base64.getEncoder().encodeToString(byteStream.toByteArray());
        return result; 
	}

	
	
	

}
