package models;

import play.db.ebean.Model;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task extends Model {

    @Id
    public String id;

    @Constraints.Required
    public String contents;

}