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
    public String email;
    public String geburtsdatum;
    public String password;
    public String username;

    public User(String vorname, String nachname, String email, String geburtsdatum ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
    }

    public  User(){}

    public User(String vorname, String nachname, String email, String geburtsdatum,String id ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
        this.id = id;

    }

    public User(String vorname, String nachname, String email, String geburtsdatum, String username , String password ) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
        this.username = username;
        this.password = password;
    }


}
