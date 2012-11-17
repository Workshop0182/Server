import play.*;
import java.io.File;

public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started :D");
    
    String fs = File.separator;
    File creationsFolder = new File(fs+"public"+fs+"images"+fs+"creations");
    
    Logger.info("Check: "+ creationsFolder);
    
  }  
  
  @Override
  public void onStop(Application app) {
    Logger.info("Application shutdown D:");
  }  
    
}
