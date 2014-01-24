package controllers;

import database.UserDB;
import database.mfgDBHandler;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.mfgDetailAnzeigen;
import views.html.mfgBestaetigen;
import views.html.mfgDetailindex;
/**
 * Created by Markus on 21.01.14.
 */
public class mfgController extends Controller {


    public static Result showDetailAnzeigen(String id){

        mfgDBHandler detailliste = new mfgDBHandler();
        detailliste.getDBCollection();

        return ok(mfgDetailAnzeigen.render(null, session("email"), null , detailliste.getDetailList(id)));

    }

    public static Result showDetailIndex(String id){

        mfgDBHandler detailliste = new mfgDBHandler();
        detailliste.getDBCollection();

        return ok(mfgDetailindex.render(null, session("email"), null , detailliste.getDetailList(id)));

    }

    public static Result actionBuchungAnfrage(String id){

        String email = session("email");
        UserDB userDB = new UserDB();
        userDB.getDBCollection();

        String idUserMitfahrer = userDB.getUserIdByEmail(email);
        String idMFG = id;

        mfgDBHandler anfrageInc = new mfgDBHandler();
        String MassageResult = anfrageInc.setAnfrageMFG( idUserMitfahrer, idMFG, "anfrage");

        return ok(views.html.memberIndex.render( MassageResult, email , null, null, null,null,null,null));

    }

    public static Result showMfgBesteatigen(String id){
        mfgDBHandler detailliste = new mfgDBHandler();
        detailliste.getDBCollection();

        return ok(mfgBestaetigen.render(null, session("email"), null , detailliste.getDetailList(id), detailliste.getMFGMitfahrer(id)));

    }

    public static Result actionMfgBesteatigen(String mfgID, String userID){
        String email = session("email");
        mfgDBHandler mfgStatus = new mfgDBHandler();
        mfgStatus.getDBCollection();
        return ok(views.html.memberIndex.render(mfgStatus.setMFGStatus( mfgID,  userID, "bestaetigt")
                , email , null, null, null,null,null,null));

    }
    public static Result actionMfgAbgelehnt(String mfgID, String userID){
        String email = session("email");
        mfgDBHandler mfgStatus = new mfgDBHandler();
        mfgStatus.getDBCollection();

        return ok(views.html.memberIndex.render(mfgStatus.setMFGStatus( mfgID,  userID, "abgelehnt"), email , null, null, null,null,null,null));
    }






}
