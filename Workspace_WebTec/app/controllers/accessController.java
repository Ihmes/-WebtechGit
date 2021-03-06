package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import models.User;
import models.ValidUserRegistrierung;
import play.Logger;
import play.mvc.Result;
import play.data.Form;
import play.mvc.Controller;
import database.RegistrierungDBHandler;
import play.data.*;
import views.html.login;
import models.ValidUserLogin;
import views.html.memberIndex;
import views.html.registrierung;
import play.Plugin.*;
import database.LoginDBHandler;


import static play.data.Form.*;


/**
 * Created by Markus on 12.01.14.
 */
public class accessController extends Controller{

    public static Result showAnmelden(){
        return ok(login.render(""));
    }

    public static Result actionAnmelden(){


        Form<ValidUserLogin> loginForm = Form.form(ValidUserLogin.class).bindFromRequest();
        loginForm = loginForm.bindFromRequest();

        if (loginForm.hasErrors()) {
            return badRequest("Da ist etwas schiefgelaufen : " +loginForm.errors());
        } else {
            ValidUserLogin user = loginForm.get();

            /***
             *  Verbindung zur Datenbank aufbauen
             *  Daten in MongoDB Speichern
             */

            LoginDBHandler LogInstance = new LoginDBHandler();
            LogInstance.getDBCollection();

            //String email, String password, Boolean remember
            boolean Status = LogInstance.getItemsCheckLogin(user.email, user.password, user.remember);

            if(Status){
                session().clear();
                session("email", user.email);
                session("connected", "true");
                return ok(memberIndex.render("Du hast Dich erfolgreich mit dem Konto " + session("email") +" angemeldet", session("email"),null, null ,null, null,null,null));
            }else{
                return ok(views.html.login.render("Password oder Email-Adresse sind falsch"));
            }
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
            return badRequest(registrierung.render("Da ist etwas schiefgelaufen: Es müssen alle Felder ausgefühllt werden" ));
        } else {
            ValidUserRegistrierung newUserData = regForm.get();

            /**
             *  Eingebegne Daten Überprüfen
             */
            if(!newUserData.password.equals(newUserData.repassword))
            {
                return ok(registrierung.render("Passwort stimmen nicht überein"));
            }else{

                /***
                 *  Verbindung zur Datenbank aufbauen
                 *  Daten in MongoDB Speichern
                 */
                RegistrierungDBHandler RegInstance = new RegistrierungDBHandler();
                RegInstance.getDBCollection();

                String email = newUserData.email;
                String user = newUserData.username;
                //String username, String email, String password, String vorname, String nachname
                String StatusMessage = RegInstance.getItemsCheckSave(newUserData.username, newUserData.email, newUserData.password, newUserData.vorname, newUserData.nachname, newUserData.geburtsdatum);

                session().clear();
                session("email", email);
                session("connected", "true");
                if(StatusMessage.contentEquals("true")){
                    return ok(views.html.memberIndex.render("Hallo " +  user +"! Du hast erfolgreich ein Konto erstellt", session("email"), user,null, null,null,null,null));
                }else{
                    return ok(views.html.registrierung.render(StatusMessage));
                }

            }
        }


    }
}