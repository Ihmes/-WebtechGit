package controllers;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import models.User;
import database.UserDB;
import models.ValidUserLogin;
import play.data.Form;
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



       List<User> userdata = userDB.getUserProfileDataByEmail(email);


       return ok(views.html.Profileinstellungen.render(null, session("email"), userdata));
   }

    public static Result actionProfil(){
        Form<User> loginForm = Form.form(User.class).bindFromRequest();
        loginForm = loginForm.bindFromRequest();
        String resultmsg ="";
        if (loginForm.hasErrors()) {
            return badRequest("Da ist etwas schiefgelaufen : " +loginForm.errors());
        } else {
            User user = loginForm.get();

            UserDB userDB = new UserDB();
            userDB.getDBCollection();
            if(!user.vorname.isEmpty() && !user.vorname.isEmpty()  && !user.geburtsdatum.isEmpty() && !user.password.isEmpty( )&& !user.username.isEmpty())
            {
            resultmsg = userDB.setProfilUpdate(user.vorname, user.nachname,  user.geburtsdatum, user.password, user.username);
            }else{
                resultmsg ="Du hast nicht alle Daten angebenen! Versuch es noch einmal";
            }

        return ok(views.html.memberIndex.render( resultmsg
                , session("email"),null, null ,null, null,null,null));
        }
   }


}
