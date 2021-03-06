package mply.winona.cs.CS471.monopoly.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SaveAsXmlMain {

	public static void main(String[] args) {

		System.out.println("Testing the jackson json store");
		try {
			XmlMapper xmlMapper = new XmlMapper();
			CounterObserver observer = new CounterObserver();
			xmlMapper.writeValue(new File("observer.json"), observer);

			BufferedReader reader = new BufferedReader(new FileReader("observer.json"));
			System.out.println("reading saved file");

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
			System.out.println("File completely read");
			
			// Read an objects
			System.out.println("Reading object");
			CounterObserver observer2  = xmlMapper.readValue(new File("observer.json"), CounterObserver.class);
			System.out.println("Object read"); 
			System.out.println("Information is "+observer2.information) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
