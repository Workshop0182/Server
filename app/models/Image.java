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
    public BufferedImage img = null;
    
    @Constraints.Required
    public String desc;
    
    @Constraints.Required
    public String name;
}
