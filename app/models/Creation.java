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
    public Long id;

    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String desc;
    
    public List<Image> images = new ArrayList<Image>();
    
    public void addImage(int priority, Image img){
    	images.add(priority, img);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Finder find = new Finder(Long.class, Creation.class);
}
