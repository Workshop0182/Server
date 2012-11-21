package controllers;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
 
public class PropertiesReader {
	
	private HashMap<String,String> properties = new HashMap<String,String>();
 
	public PropertiesReader(String filePath) {
		
		BufferedReader br = null;
		
		try {
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader(filePath));
 
			while ((sCurrentLine = br.readLine()) != null) {
				
				String propertyName = sCurrentLine.substring(sCurrentLine.indexOf("[")+1,sCurrentLine.lastIndexOf("]"));
				String propertyValue = sCurrentLine.substring(sCurrentLine.indexOf(":")+2);
				
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
	
	public String getValue(String propertyName){
		return (String) properties.get(propertyName);
	}
	
}
