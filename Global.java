import models.Creation;
import models.Image;
import play.*;
import models.*;
import controllers.PropertiesReader;
import play.Logger;

import org.apache.commons.io.FilenameUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.System;
import java.util.Arrays;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Global extends GlobalSettings {

	static int CreationSetCount = 0;
	static int CreationCount = 0;
	static int ImageCount = 0;

    public static PropertiesReader pr = new PropertiesReader();

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
				Creation c = createCreation(f);
                cs.addCreation(c);
			}else if(FilenameUtils.getExtension(f.getName()).equals("conf")){
                cs.desc = pr.getValue(f.getPath(),"desc");
                cs.priority = Integer.parseInt(pr.getValue(f.getPath(),"priority"));
			}
		}

	 cs.id = new Long(++CreationSetCount);
	 cs.name = FilenameUtils.getBaseName(file.getName());
     cs.save();

	 return cs;
  }

  public Creation createCreation(File file){
	 Creation c = new Creation();

	 	for(File f:file.listFiles()) {
            String ext = FilenameUtils.getExtension(f.getName());
			if(ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg")){
				Image i = createImage(f);
                c.addImage(i);
			}else if(ext.equals("conf")){
				c.desc = pr.getValue(f.getPath(),"desc");
                c.priority = Integer.parseInt(pr.getValue(f.getPath(),"priority"));
			}
		}
	 c.id = new Long(++CreationCount);
	 c.name = FilenameUtils.getBaseName(file.getName());
     c.save();

	 return c;
  }

  public Image createImage(File file){
	 Image i = new Image();
	 i.id = new Long(++ImageCount);
	 i.name = FilenameUtils.getBaseName(file.getName());
	 i.setImg(file);
     i.save();

	 return i;
  }

}
