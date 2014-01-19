package controllers;

import database.UserDB;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import models.User;
import views.html.*;

/**
 * Created by Markus on 18.01.14.
 */
public class memberController extends Controller {

    public static UserDB userDB = new UserDB();

    //@Security.Authenticated(Secured.class)
    public static Result showMemberIndex(){


        String email = session("connected");
        List<User> user = userDB.getUserDataByEmail(email);
        return ok(views.html.memberIndex.render("Hello"));

        //return ok(memberIndex.render("Hallo " + email + " Du hast Dich erfolgreich angemeldet!" , user));
    }


}
