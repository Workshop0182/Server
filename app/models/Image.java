package models;

import java.awt.image.BufferedImage;
import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image extends Model{
    @Id
    public String id;

    @Constraints.Required
    public BufferedImage img;
    
    @Constraints.Required
    public String name;
}
