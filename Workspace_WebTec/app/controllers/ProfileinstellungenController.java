package controllers;

import java.util.List;
import models.User;
import database.UserDB;
import play.mvc.Controller;
import play.mvc.Security;
import play.mvc.Result;

/**
 * Created by Markus on 20.01.14.
 */
@Security.Authenticated(Secured.class)
public class ProfileinstellungenController  extends Controller {

   public static Result showProfil(){

       UserDB userDB = new UserDB();
       userDB.getDBCollection();
       String email = session("email");

       List<User> userdata = userDB.getUserdataByEmail(email);


       return ok(views.html.Profileinstellungen.render(null, session("email"), userdata));
   }

    public static Result actionProfil(){

        return ok(views.html.Profileinstellungen.render(null, null, null));

   }


}
