package controllers;

import database.UserDB;
import database.mfgDBHandler;
import models.User;
import models.ValideMFG;
import models.ValideSearchForm;
import play.Logger;
import play.api.mvc.Security;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import java.lang.Double;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


import scala.collection.immutable.*;
import scala.*;

/**
 * Created by Markus on 18.01.14.
 */
public class memberController extends Controller {

    public static UserDB userDB = new UserDB();
    public static String user ="";
    public static int age;

    @play.mvc.Security.Authenticated(Secured.class)
    public static Result showMemberIndex(){

        String email = session("email");
        UserDB userDB = new UserDB();
        userDB.getDBCollection();
        String user = userDB.getUsernameByEmail(email);
        userDB.getDBCollection();
        String userID = userDB.getUserIdByEmail(email);
        mfgDBHandler.getDBCollection();


/*
        mfgDBHandler.getMFGbestaetigt();
*/


        return ok(views.html.memberIndex.render("Hallo " + user, session("email"), user, "true" , mfgDBHandler.getMFGAngeboten(userID),
                mfgDBHandler.getMFGStatus(userID, "anfrage"), mfgDBHandler.getMFGStatus(userID, "bestaetigt"),mfgDBHandler.getMFGStatus(userID, "abgelehnt")));
    }


    @play.mvc.Security.Authenticated(Secured.class)
    public static Result showSuche(){

        mfgDBHandler mfgInstance = new mfgDBHandler();
        mfgInstance.getDBCollection();
        // Ausgabe einer Liste bla
        return ok(views.html.mfgSuchen.render(null, session("email"), user, mfgDBHandler.getPrevList()));
    }


    @play.mvc.Security.Authenticated(Secured.class)
    public static Result actionSuche(){
        Form<ValideSearchForm> searchForm = Form.form(ValideSearchForm.class);
        searchForm = searchForm.bindFromRequest();

        if (searchForm.hasErrors()) {
            return badRequest(views.html.mfgSuchen.render("Da ist etwas schiefgelaufen : " + searchForm.errors(), null, null, null));
        } else {
            ValideSearchForm newSearch = searchForm.get();

            mfgDBHandler mfgDB = new mfgDBHandler();
            mfgDB.getDBCollection();


            if(!newSearch.startort.isEmpty() || !newSearch.zielort.isEmpty())
            {

                if(newSearch.startort.isEmpty() && !newSearch.zielort.isEmpty())
                {
                    List<ValideMFG> resultSearch = mfgDB.searchByParameter(newSearch.zielort, "zielort");
                    return ok(views.html.mfgSuchen.render(null, session("email"), user, resultSearch));
                }

                if(!newSearch.startort.isEmpty() && newSearch.zielort.isEmpty())
                {
                    List<ValideMFG> resultSearch = mfgDB.searchByParameter(newSearch.startort, "startort");
                    return ok(views.html.mfgSuchen.render(null, session("email"), user, resultSearch));

                }
                if(!newSearch.startort.isEmpty() && !newSearch.zielort.isEmpty())
                {
                    List<ValideMFG> resultSearch = mfgDB.searchByStartEnd(newSearch.startort,newSearch.zielort);
                    return ok(views.html.mfgSuchen.render(null, session("email"), user, resultSearch));
                }

            }
        }


        return ok(views.html.mfgSuchen.render("Bitte geben Sie min. ein Ort bei der Suche an!", session("email"), user, null));
    }

    /***
     * Eine MFG kann nur von Volljährigen angeboten werden. Daher nimmt eine Person unter 18 die Rolle "Mitfahrer" ein
     * Eine Person die über 18 ist hat kann die Rolle "Fahrer" und "Mitfahrer" besitzen
     *
     * @return
     */
    @play.mvc.Security.Authenticated(Secured.class)
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
            sb.append(years);
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
    @play.mvc.Security.Authenticated(Secured.class)
    public static Result actionAnbieterMaske(){

        Form<ValideMFG> mfgForm = Form.form(ValideMFG.class);
        mfgForm = mfgForm.bindFromRequest();

        if (mfgForm.hasErrors()) {
            return badRequest(views.html.mfgAnbieten.render("Da ist etwas schiefgelaufen : " + mfgForm.errors(), null, null));
        } else {

            String email = session("email");
            UserDB userDB = new UserDB();
            userDB.getDBCollection();
            String user = userDB.getUsernameByEmail(email);


            userDB.getDBCollection();
            String userID = userDB.getUserIdByEmail(email);
            mfgDBHandler mfgInstance = new mfgDBHandler();
            mfgInstance.getDBCollection();
            ValideMFG newMFG = mfgForm.get();
            String StatusMessage = mfgInstance.getMFGSave(newMFG.startort ,newMFG.zielort, newMFG.mitfahrer, newMFG.datum, newMFG.uhrzeit, false, user, userID);

            return ok(views.html.memberIndex.render( StatusMessage, session("email"), user,null, null, null, null, null));
        }
    }
}
