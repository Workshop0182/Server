package controllers;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
 
public class PropertiesReader {
	
	public static String getValue(String filePath,String propertyName){
        BufferedReader br = null;
        HashMap<String,String> properties = new HashMap<String,String>();

        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader(filePath));

            while ((sCurrentLine = br.readLine()) != null) {

                String pName = sCurrentLine.substring(sCurrentLine.indexOf("[")+1,sCurrentLine.lastIndexOf("]"));
                String pValue = sCurrentLine.substring(sCurrentLine.indexOf(":")+2);

                properties.put(pName,pValue);
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

		return (String) properties.get(propertyName);
	}
	
}
