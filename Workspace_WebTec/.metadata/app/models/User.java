package models;

import play.data.validation.Constraints.Required;
import java.util.Date;

/**
 * Created by Markus on 05.01.14.
 */
public class User extends Entity {

    public String userId;
    public String vorname;
    public String nachname;
    public String email;
    public String geburtsdatum;

    public User(String vorname, String nachname, String email, String geburtsdatum ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
    }


    public User(String vorname, String nachname, String userId ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.userId = userId;
    }

}
