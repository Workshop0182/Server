package controllers;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
 
public class PropertiesReader {
	
	private HashMap<String,String> properties = new HashMap<String,String>();
 
	public PropertiesReader(String filePath) {
		System.out.println(filePath);
		
		BufferedReader br = null;
		
		try {
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader(filePath));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				String propertyName = sCurrentLine.substring(sCurrentLine.indexOf("[")+1,sCurrentLine.lastIndexOf("]"));
				String propertyValue = sCurrentLine.substring(sCurrentLine.indexOf(":")+2);
				
				System.out.println("propertyName = " + propertyName);
				System.out.println("propertyValue = " + propertyValue);
				System.out.println();
				
				properties.put(propertyName,propertyValue);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException s) {
			//Do absolutely nothing with this error, deal with it, I'm to lazy to prevent it >:D
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
}
