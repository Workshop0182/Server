package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import play.db.ebean.Model;
import play.data.validation.Constraints;
import play.mvc.Result;
import javax.persistence.Entity;
import javax.persistence.Id;

import static play.libs.Json.toJson;
import org.codehaus.jackson.JsonNode;

@Entity
public class Creation extends Model implements Comparable<Creation> {
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

    private List<Image> children = new ArrayList<Image>();

    private JsonNode JsonChildren = toJson(children);

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

    public JsonNode getJsonChildren(){
        return JsonChildren;
    }

    @Override
    public int compareTo(Creation creation) {
        int ret;
        try{
            ret = this.name.compareTo(creation.name);
        }catch(NullPointerException ex){
            ret = 255;
        }

        return ret;
    }
}
