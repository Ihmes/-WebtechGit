package controllers;

import database.LoginDBHandler;
import database.RegistrierungDBHandler;
import database.UserDB;
import database.mfgDBHandler;
import models.ValidUserRegistrierung;
import models.ValideMFG;
import models.ValideSearchForm;
import play.Logger;
import play.api.mvc.Security;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registrierung;
import org.bson.types.ObjectId;
import scala.collection.JavaConversions.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Markus on 18.01.14.
 */
public class memberController extends Controller {

    public static UserDB userDB = new UserDB();
    public static String user ="";
    public static int age;
    //@Security.Authenticator(Secured.class)
    public static Result showMemberIndex(){


        userDB.getDBCollection();
        mfgDBHandler mfgInstance = new mfgDBHandler();
        mfgInstance.getDBCollection();

        String email = session("email");
        user = userDB.getUsernameByEmail(email);
        //List<User> userDetails = userDB.getUserDetails(email);
        mfgInstance.getPrevList();
        return ok(views.html.memberIndex.render("Hallo " + user, session("email"), user));
    }



    public static Result showSuche(){
        mfgDBHandler mfgInstance = new mfgDBHandler();
        mfgInstance.getDBCollection();
        List<ValideMFG> userData = mfgInstance.getPrevList();

        // Ausgabe einer Liste bla
        return ok(views.html.mfgSuchen.render(null, session("email"), user, userData));
    }

    public static Result actionSuche(){
        Form<ValideSearchForm> searchForm = Form.form(ValideSearchForm.class);
        searchForm = searchForm.bindFromRequest();

        if (searchForm.hasErrors()) {
            return badRequest(views.html.mfgSuchen.render("Da ist etwas schiefgelaufen : " + searchForm.errors(), null, null));
        } else {
            ValideSearchForm newSearch = searchForm.get();

            if(!newSearch.startort.isEmpty() || !newSearch.zielort.isEmpty())
            {

                if(newSearch.startort.isEmpty() && !newSearch.zielort.isEmpty())
                {
                    return ok(views.html.mfgSuchen.render("Startort ist leer", session("email"), user));
                }

                if(!newSearch.startort.isEmpty() && newSearch.zielort.isEmpty())
                {
                    return ok(views.html.mfgSuchen.render("Zielort ist leer", session("email"), user));

                }
                if(!newSearch.startort.isEmpty() && !newSearch.zielort.isEmpty())
                {
                    return ok(views.html.mfgSuchen.render("beide da", session("email"), user));
                }
            }
        }
        return ok(views.html.mfgSuchen.render("Bitte geben Sie min. ein Ort bei der Suche an!", session("email"), user));
    }

    /***
     * Eine MFG kann nur von Volljährigen angeboten werden. Daher nimmt eine Person unter 18 die Rolle "Mitfahrer" ein
     * Eine Person die über 18 ist hat kann die Rolle "Fahrer" und "Mitfahrer" besitzen
     *
     * @return
     */
    public static Result showAnbieterMaske(){

        userDB.getDBCollection();
        String email = session("email");
        String birthdayUserDB = userDB.getUserBirthdayByEmail(email);

        try{
            DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            Date userBirthdayPrase = dateformat.parse(birthdayUserDB);
            GregorianCalendar GreBirthday = new GregorianCalendar();
            GreBirthday.setTime(userBirthdayPrase);

            GregorianCalendar today = new GregorianCalendar();
            long difference = today.getTimeInMillis() - GreBirthday.getTimeInMillis();
            int days = (int) (difference / (1000 * 60 * 60 * 24));
            double years = (double) days / 365;
            StringBuilder sb = new StringBuilder();
            //sb.append("");
            sb.append(years);
            //String alter = sb.toString();
            age = (int) Math.floor(Double.parseDouble(sb.toString()));
            }catch  (Exception e) {
                Logger.info("Datum konnte nicht geparse werden" + e);
            }
        if(age < 18)
        {
            return ok(views.html.mfgAnbieten.render("Du bist keine 18 Jahre, daher kannst du keine MFG anbieten", session("email"), user));
        }else{
            return ok(views.html.mfgAnbieten.render( null, session("email"), user));
        }

    }

    public static Result actionAnbieterMaske(){

        Form<ValideMFG> mfgForm = Form.form(ValideMFG.class);
        mfgForm = mfgForm.bindFromRequest();

        if (mfgForm.hasErrors()) {
            return badRequest(views.html.mfgAnbieten.render("Da ist etwas schiefgelaufen : " + mfgForm.errors(), null, null));
        } else {
            mfgDBHandler mfgInstance = new mfgDBHandler();
            mfgInstance.getDBCollection();

            // Get User ID
            UserDB userInstance = new UserDB();
            userInstance.getDBCollection();

            // HIER umbedingt noch richtihge
            String userID = "11"; //userInstance.getUserIdByEmail(session("email"));

            ValideMFG newMFG = mfgForm.get();
            String StatusMessage = mfgInstance.getMFGSave(userID,newMFG.startort ,newMFG.zielort, newMFG.mitfahrer, newMFG.datum, newMFG.uhrzeit, false);

            return ok(views.html.memberIndex.render( StatusMessage + "ID: " + userID, session("email"), user));
        }
    }
}
