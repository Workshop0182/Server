package models;

import play.Logger;
import play.db.ebean.Model;
import play.data.validation.Constraints;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Constraint;

@Entity
public class Image extends Model implements Comparable<Image>{

    @Id
    public Long id;

    @Constraints.Required
    public String img;

    @Constraints.Required
    public int priority;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public double aspectRatio;

    @Constraints.Required
    public Creation parent;

    public static Finder<Long,Image> find = new Finder<Long,Image>(
            Long.class, Image.class
    );
    
    public void setImg(File image){
		this.img = "/assets/" + image.getPath().substring(7).replaceAll(" ","%20");
        BufferedImage i;
        try {
            i = ImageIO.read(image);

            this.aspectRatio = (double) i.getHeight()/i.getWidth();
            Logger.info(this.aspectRatio+"");
        } catch (IOException e) {
            this.aspectRatio = 0.75;
        }
	}

    @Override
    public int compareTo(Image image) {
        int ret;
        try{
           ret = this.name.compareTo(image.name);
        }catch(NullPointerException ex){
           ret = 255;
        }

        return ret;
    }
}
