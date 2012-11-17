package controllers;

import play.*;
import play.mvc.*;
import models.*;
import play.data.Form;
import views.html.*;
import play.db.ebean.Model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import static play.libs.Json.toJson;

public class Application extends Controller {
	
	
  List<Image> allImages = new ArrayList<Image>();
  

  public static Result index() {
      //return ok(index.render("utterly useless message",form(Task.class)));
      return ok(home.render("utterly useless message"));
  }
  
  public static Result sieraden() {
      //return ok(index.render("utterly useless message",form(Task.class)));
      return ok(sieraden.render("utterly useless message"));
  }
  
  public static Result leer() {
      //return ok(index.render("utterly useless message",form(Task.class)));
      return ok(leer.render("utterly useless message"));
  }
  
  public static Result jochem() {
      //return ok(index.render("utterly useless message",form(Task.class)));
      return ok(jochem.render("utterly useless message"));
  }
  
  public static void addImage(BufferedImage _img) {
      Image img = new Image();
      
  }
  
  public static Result addTask() {
      Form<Task> form = form(Task.class).bindFromRequest();
      if (form.hasErrors()==false) {
          Task task = form.get();
          task.save();
          return redirect(routes.Application.index());
      }else{
    	  Task task = new Task();
    	  task.contents = "Stop entering empty fields you lazy nigger";
    	  task.save();
    	  return redirect(routes.Application.index());
      }
  }
  
  public static Result getTasks() {
      List<Task> tasks = new Model.Finder(String.class, Task.class).all();
      return ok(toJson(tasks));
  }
  
}