package models;

import play.data.validation.Constraints.Required;


/**
 * Created by Markus on 12.01.14.
 */
public class ValidUserRegistrierung {

    @Required
    public String vorname;

    @Required
    public String nachname;

    @Required
    public String email;

    @Required
    public String username;

    @Required
    public String password;
    public String repassword;
    public boolean remember;
}
