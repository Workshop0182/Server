package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreationSet extends Model {@Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String desc;

    @Constraints.Required
    public int priority;

    public List<Creation> children = new ArrayList<Creation>();
    
    public void addCreation(Creation creation){
        creation.parent = this;
    	children.add(creation.priority, creation);
    }

    public static Finder find = new Finder(Long.class, CreationSet.class);

    public CreationSet(){
        int x= 0;

        while( x < 100 ){
            children.add(new Creation());
            x++;
        }
    }
}
