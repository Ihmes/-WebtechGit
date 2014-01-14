package models;

import play.data.validation.Constraints.Required;
import java.util.Date;

/**
 * Created by Markus on 05.01.14.
 */
public class User extends Entity {

    public String id;
    public String vorname;
    public String nachname;
    @Required
    public String email;
    @Required
    public String password;
    public boolean remember;


    public User(String id,String email, String password, String vorname , String nachname, boolean remember){
        this.id = id;
        this.email = email;
        this.password = password;
        this.vorname = vorname;
        this.nachname = nachname;
        this.remember = remember;
    }

}
