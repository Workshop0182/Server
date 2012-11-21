import play.*;
import models.*;
import controllers.PropertiesReader;

import java.io.File;
import java.util.Arrays;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Global extends GlobalSettings {
	
	static int CreationSetCount = 0;
	static int CreationCount = 0;
	static int ImageCount = 0;

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started :D");
    
    String fs = File.separator;
    File creationsFolder = new File("public"+fs+"images"+fs+"creations");
    
    
    for(File file:creationsFolder.listFiles()) {
		createCreationSet(file);
	}
  }  
  
  @Override
  public void onStop(Application app) {
    Logger.info("Application shutdown D:");
  }  
  
  public CreationSet createCreationSet(File file){
	 CreationSet cs = new CreationSet(); 
	 
		for(File f:file.listFiles()) {
			if(f.isDirectory()){
				createCreation(f);
			}else{
				PropertiesReader pr = new PropertiesReader(f.getPath());
				cs.desc = pr.getValue("desc");
				//TODO: 'Name' value also in properties file or extract file name
			}
		}
	 
	 cs.id = "" + ++CreationSetCount;
	 cs.name = file.getName();
	 
	 return cs;
  }
  
  public Creation createCreation(File file){
	 Creation c = new Creation(); 
	 
	 	for(File f:file.listFiles()) {
			if(f.isDirectory()){
				createImage(f);
			}else{
				PropertiesReader pr = new PropertiesReader(f.getPath());
				c.desc = pr.getValue("desc");
			}
		}
	 c.id = "" + ++CreationCount;
	 c.name = file.getName();
	 c.desc = file.getPath();
	 
	 return c;
  }
  
  public Image createImage(File file){
	 Image i = new Image(); 
	 i.id = "" + ++ImageCount;
	 i.name = file.getName();
	 try {
		i.img = ImageIO.read(file);
	 } catch (IOException e) {
		Logger.info("Image is fucking up: "+i.name);
 	 }
	 
	 return i;
  }
    
}
