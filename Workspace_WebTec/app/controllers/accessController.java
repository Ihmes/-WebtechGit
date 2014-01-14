package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import models.User;
import models.ValidUserRegistrierung;
import play.Logger;
import play.mvc.Result;
import play.data.Form;
import play.mvc.Controller;
import database.UserDB;
import play.data.*;
import views.html.login;
import models.ValidUserLogin;
import views.html.registrierung;
import play.Plugin.*;



import static play.data.Form.*;


/**
 * Created by Markus on 12.01.14.
 */
public class accessController extends Controller{

    public static Result showAnmelden(){
        return ok(login.render());
    }

    public static Result actionAnmelden(){

        Form<ValidUserLogin> loginForm = Form.form(ValidUserLogin.class).bindFromRequest();
        loginForm = loginForm.bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest("Da ist etwas schiefgelaufen : " +loginForm.errors());
        } else {
            ValidUserLogin user = loginForm.get();
            session().clear();
            session("email", user.email);
            return ok(views.html.index.render("Hallo" + user.email +
                    "Deine Eingaben: " +user.email +" " +user.password +" " + user.remember));
        }
    }


    public static Result showRegistrierung() {
        return ok(
                views.html.registrierung.render("Erstelle jetzt ein Profil bei MFG")
        );
    }

    public static Result actionRegistrierung(){

        Form<ValidUserRegistrierung> regForm = Form.form(ValidUserRegistrierung.class);
        regForm = regForm.bindFromRequest();

        if (regForm.hasErrors()) {
            return badRequest(registrierung.render("Da ist etwas schiefgelaufen : " + regForm.errors()));
        } else {
            ValidUserRegistrierung newUserData = regForm.get();


            UserDB users = UserDB.get();
            User newUser = users.create(new User("122334434332", newUserData.email, newUserData.password,
                    newUserData.vorname, newUserData.nachname, false));


            if (newUser != null) {

                return ok(views.html.login.render());
            } else {
                return badRequest(registrierung.render("E-Mail existiert bereits"));
            }

        }


    }



}


