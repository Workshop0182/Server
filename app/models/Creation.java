package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Creation extends Model {
    @Id
    public String id;

    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String desc;
    
    public List<Image> images = new ArrayList<Image>();
    
    public void addImage(int priority, Image img){
    	images.add(priority, img);
    }
}
