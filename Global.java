import play.*;
import java.io.File;
import java.util.Arrays;
import java.net.URL;

import models.*;
import controllers.PropertiesReader;

public class Global extends GlobalSettings {
	
	static int CreationSetCount = 0;
	static int CreationCount = 0;
	static int ImageCount = 0;

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started :D");
    
    String fs = File.separator;
    URL res = getClass().getClassLoader().getResource("public/images/creations");
    File creationsFolder = new File(res.getFile());
    
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
			}
		}
	 
	 cs.id = "" + ++CreationSetCount;
	 cs.name = file.getName();
	 cs.desc = file.getPath();
	 
	 return cs;
  }
  
  public Creation createCreation(File file){
	 Creation c = new Creation(); 
	 c.id = "" + ++CreationCount;
	 c.name = file.getName();
	 c.desc = file.getPath();
	 
	 return c;
  }
  
  public Image createImage(File file){
	 Image i = new Image(); 
	 i.id = "" + ++ImageCount;
	 i.name = file.getName();
	 i.desc = file.getPath();
	 
	 return i;
  }
    
}
