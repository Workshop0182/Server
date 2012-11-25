package models;

import java.util.ArrayList;
import java.util.Collections;
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

    @Constraints.Required
    public int priority;

    @Constraints.Required
    public CreationSet parent;

    public List<Image> children = new ArrayList<Image>();
    
    public void addImage(Image img){
        img.parent = this;
        children.add(img);
        Collections.sort(children);
    }

    public static Finder find = new Finder(Long.class, Creation.class);

    public Creation(){
        int x= 0;

        while( x < 100 ){
            children.add(new Image());
            x++;
        }
    }
}
