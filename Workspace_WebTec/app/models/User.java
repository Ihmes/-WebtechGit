package models;

import play.data.validation.Constraints.Required;
import java.util.Date;

/**
 * Created by Markus on 05.01.14.
 */
public class User extends Entity {


    public String vorname;
    public String nachname;
    public String email;


    public User(String vorname, String nachname, String email ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
    }

}
