package controllers;

import database.LoginDBHandler;
import database.UserDB;
import play.api.mvc.Security;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import models.User;

import play.api.mvc.Session;


/**
 * Created by Markus on 18.01.14.
 */
public class memberController extends Controller {

    public static UserDB userDB = new UserDB();
    public static String user ="";

    //@Security.Authenticator(Secured.class)
    public static Result showMemberIndex(){


        userDB.getDBCollection();

        String email = session("email");
        user = userDB.getUsernameByEmail(email);
        //List<User> userDetails = userDB.getUserDetails(email);

        return ok(views.html.memberIndex.render("Hallo " + user, session("email"), user));
    }

    public static Result showSuche(){

        return ok(views.html.mfgSuchen.render("Hallo " + user, session("email"), user));
    }


    public static Result showAnbieterMaske(){

        return ok(views.html.mfgAnbieten.render("Hallo " + user, session("email"), user));
    }
}
