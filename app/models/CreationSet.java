package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreationSet extends Model {
    @Id
    public String id;

    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public String desc;
    
    public List<Creation> creations = new ArrayList<Creation>();
    
    public void addCreations(int priority, Creation creation){
    	creations.add(priority, creation);
    }
    
    
    public String toString(){
		String retString = id+" | "+name+" | "+desc;
		return retString;
	}
}
