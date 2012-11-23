package models;

import java.awt.image.BufferedImage;
import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image extends Model{

    @Id
    public Long id;

    @Constraints.Required
    public BufferedImage img;

    @Constraints.Required
    public String name;

    public static Finder<Long,Image> find = new Finder<Long,Image>(
            Long.class, Image.class
    );
}
