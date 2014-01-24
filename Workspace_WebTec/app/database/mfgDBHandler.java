package database;

import com.mongodb.*;
import models.User;
import models.ValideMFG;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import play.mvc.Result;
import scala.math.Ordering;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Markus on 20.01.14.
 */
public class mfgDBHandler {

    public static String COLLECTION_USERS = "User";
    public static String COLLECTION_MFGBS = "buchungssystem";
    public static String COLLECTION_MFG = "mfg";
    private static ConnectDB dbInstance = new ConnectDB();
    private static DBCollection coll = null;

    /**
     *  Datenbankverbindung herstellen
     *  User Collection aufrufen
     */
    public static void getDBCollection(){
        DB db = dbInstance.getDB();
        coll = db.getCollection(COLLECTION_MFG);
    }


    public static String getMFGSave( String startort, String zielort, int mitfahrer, String datum, String uhrzeit, boolean status, String fahrer, String userID){

            BasicDBObject doc = new BasicDBObject("startort", startort).append("zielort", zielort)
                .append("mitfahrer", mitfahrer).append("datum", datum)
                .append("uhrzeit", uhrzeit).append("status", status).append("fahrer", fahrer).append("fahrerID", userID);
        coll.insert(doc);
        dbInstance.dispose();

        return "MFG wurde erfolgreich veröffentlicht";
    }


    public static List<ValideMFG> getPrevList(){

        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();

        try {
            com.mongodb.DBCursor cursor = coll.find();
            BasicDBObject query = (BasicDBObject) new BasicDBObject("status",
                    false);
            cursor = coll.find(query);

            DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date currentDate = Calendar.getInstance().getTime();
            Date ParseDateformDB = null;
            long ValidTimeandDate =0;

            for (DBObject s : cursor) {
                String dateDB = (String) s.get("datum") + " "
                        + (String) s.get("uhrzeit");

                try {

                    ParseDateformDB = date.parse(dateDB);
                    ValidTimeandDate = currentDate.getTime()
                            - ParseDateformDB.getTime() - 1800000;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(ValidTimeandDate <= 0){
                    ergDBquery.add(new ValideMFG( s.get("_id").toString(),
                            (String) s.get("startort"),(String) s.get("zielort"),
                            (String) s.get("datum"),
                            (String) s.get("uhrzeit")));
                }
            }

        } catch (Exception e) {

        }
        dbInstance.dispose();
        return ergDBquery;
    }

    public static List<ValideMFG> getDetailList(String id){

        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();

        try {
            com.mongodb.DBCursor cursor = coll.find();
            BasicDBObject query = (BasicDBObject) new BasicDBObject("_id",
                    new ObjectId(id));
            cursor = coll.find(query);

            DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date currentDate = Calendar.getInstance().getTime();
            Date ParseDateformDB = null;
            long ValidTimeandDate =0;

            for (DBObject s : cursor) {
                String dateDB = (String) s.get("datum") + " "
                        + (String) s.get("uhrzeit");

                try {

                    ParseDateformDB = date.parse(dateDB);
                    ValidTimeandDate = currentDate.getTime()
                            - ParseDateformDB.getTime() - 1800000;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(ValidTimeandDate <= 0){
                    ergDBquery.add(new ValideMFG( s.get("_id").toString(),
                            (String) s.get("startort"),(String) s.get("zielort"),
                            (int) s.get("mitfahrer"),
                            (String) s.get("datum"),
                            (String) s.get("uhrzeit"),(String) s.get("fahrer")));

                }
            }

        } catch (Exception e) {

        }
        dbInstance.dispose();
        return ergDBquery;

    }




    public static List<ValideMFG> searchByParameter(String ort,String parameter){
        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = (BasicDBObject) new BasicDBObject(parameter,
                ort );
        cursor = coll.find(query);

        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date currentDate = Calendar.getInstance().getTime();
        Date ParseDateformDB = null;
        long ValidTimeandDate =0;

        for (DBObject s : cursor) {
            String dateDB = (String) s.get("datum") + " "
                    + (String) s.get("uhrzeit");

            try {

                ParseDateformDB = date.parse(dateDB);
                ValidTimeandDate = currentDate.getTime()
                        - ParseDateformDB.getTime() - 1800000;

            } catch (Exception e) {
                e.printStackTrace();
        }

            if(ValidTimeandDate <= 0){
                    ergDBquery.add(new ValideMFG(s.get("_id").toString(),
                            (String) s.get("startort"),(String) s.get("zielort"),
                            (String) s.get("datum"),
                            (String) s.get("uhrzeit")));

            }
        }
        dbInstance.dispose();
        return ergDBquery;
    }


    public static List<ValideMFG> searchByStartEnd(String startort, String zielort){
        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = (BasicDBObject) new BasicDBObject("startort",
                startort).append("zielort", zielort);

        cursor = coll.find(query);

        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date currentDate = Calendar.getInstance().getTime();
        Date ParseDateformDB = null;
        long ValidTimeandDate =0;

        for (DBObject s : cursor) {
            String dateDB = (String) s.get("datum") + " "
                    + (String) s.get("uhrzeit");

            try {

                ParseDateformDB = date.parse(dateDB);
                ValidTimeandDate = currentDate.getTime()
                        - ParseDateformDB.getTime() - 1800000;

            } catch (Exception e) {
                e.printStackTrace();
            }

            if(ValidTimeandDate <= 0){
                ergDBquery.add(new ValideMFG(s.get("_id").toString(),
                        (String) s.get("startort"),(String) s.get("zielort"),
                        (String) s.get("datum"),
                        (String) s.get("uhrzeit")));

            }
        }
        dbInstance.dispose();
        return ergDBquery;

    }

    public static String setAnfrageMFG(String userID, String mfgID, String mfgStatus){

        com.mongodb.DBCursor cursor = coll.find();
        DB db = dbInstance.getDB();
        String findMFG = "";
        String fahrerID ="";

        coll = db.getCollection(COLLECTION_MFG);
        com.mongodb.DBCursor cursorMFG = coll.find();

        BasicDBObject queryMFG = new BasicDBObject("_id", new ObjectId(mfgID));
        cursorMFG = coll.find(queryMFG);

        for(DBObject s : cursorMFG) {
            fahrerID = (String) s.get("fahrerID");
        }

        coll = db.getCollection(COLLECTION_MFGBS);
        BasicDBObject query = (BasicDBObject) new BasicDBObject("userID",
                userID).append("mfgID", mfgID);
        cursor = coll.find(query);


        try {
            while (cursor.hasNext()) {
                findMFG += cursor.next();
            }
        } finally {
            cursor.close();
        }

        if (!findMFG.isEmpty()) {
            dbInstance.dispose();
            return "Du hast für diese Fahrt schon eine Buchungsanfrage gesendet";
        }

        //idUserMitfahrer == UserID
        if(userID.contentEquals(fahrerID)){
            return "Du kannst deine eigene Fahrt nicht buchen!";
        }

        BasicDBObject doc = new BasicDBObject("userID", userID).append("mfgStatus", mfgStatus)
                .append("mfgID", mfgID).append("fahrerID",fahrerID);
        coll.insert(doc);

        dbInstance.dispose();

        return "Deine Anfrage wurde an den Fahrer gesendet";
    }

    public static List<ValideMFG> getMFGStatus(String UserID, String status){

        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();
        String mfgID ="";

        DB db = dbInstance.getDB();
        coll = db.getCollection(COLLECTION_MFGBS);
        com.mongodb.DBCursor cursor = coll.find();

        BasicDBObject queryMFG = new BasicDBObject("userID", UserID).append("mfgStatus", status);
        cursor = coll.find(queryMFG);

        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date currentDate = Calendar.getInstance().getTime();
        Date ParseDateformDB = null;
        long ValidTimeandDate =0;

        for(DBObject d : cursor) {
            mfgID = (String) d.get("mfgID");


                coll = db.getCollection(COLLECTION_MFG);
                com.mongodb.DBCursor cursorMFG = coll.find();

                BasicDBObject query = new BasicDBObject("_id", new ObjectId(mfgID));
                cursorMFG = coll.find(query);

                for (DBObject s : cursorMFG) {
                    String dateDB = (String) s.get("datum") + " "
                        + (String) s.get("uhrzeit");

                try {

                    ParseDateformDB = date.parse(dateDB);
                    ValidTimeandDate = currentDate.getTime()
                            - ParseDateformDB.getTime() - 1800000;

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(ValidTimeandDate <= 0){

                    for (DBObject i : cursorMFG) {
                        ergDBquery.add(new ValideMFG(i.get("_id").toString(),
                                (String) i.get("startort"),(String) i.get("zielort"),
                                (String) i.get("datum"),
                                (String) i.get("uhrzeit")));
                    }


                }

        }

        }
        dbInstance.dispose();
        return ergDBquery;
    }
    public static List<ValideMFG> getMFGAngeboten(String UserID){

        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();
        String mfgID ="";

        DB db = dbInstance.getDB();
        coll = db.getCollection(COLLECTION_MFGBS);
        com.mongodb.DBCursor cursor = coll.find();

        BasicDBObject queryMFG = new BasicDBObject("fahrerID", UserID).append("mfgStatus", "anfrage");
        cursor = coll.find(queryMFG);

        for(DBObject d : cursor) {
            mfgID = (String) d.get("mfgID");


            coll = db.getCollection(COLLECTION_MFG);
            com.mongodb.DBCursor cursorMFG = coll.find();

            BasicDBObject query = new BasicDBObject("_id", new ObjectId(mfgID));
            cursorMFG = coll.find(query);

            for (DBObject s : cursorMFG) {
                ergDBquery.add(new ValideMFG(s.get("_id").toString(),
                        (String) s.get("startort"),(String) s.get("zielort"),
                        (String) s.get("datum"),
                        (String) s.get("uhrzeit")));
            }

        }
        dbInstance.dispose();
        return ergDBquery;

    }

    public static List<ValideMFG> getAllMFGs(String UserID){

    //   Alle eingestellten fahrten des Useres ausgeben ohne Status

        List<ValideMFG> ergDBquery = new ArrayList<ValideMFG>();

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject queryMFG = new BasicDBObject("fahrerID", UserID);
        cursor = coll.find(queryMFG);

        for (DBObject s : cursor) {
            ergDBquery.add(new ValideMFG(s.get("_id").toString(),
                    (String) s.get("startort"),(String) s.get("zielort"),
                    (String) s.get("datum"),
                    (String) s.get("uhrzeit")));
        }


        dbInstance.dispose();
        return ergDBquery;

    }

    public static List<User> getMFGMitfahrer(String mfgID){

        List<User> ergDBquery = new ArrayList<User>();
        String userID ="";

        DB db = dbInstance.getDB();
        coll = db.getCollection(COLLECTION_MFGBS);
        com.mongodb.DBCursor cursor = coll.find();

        BasicDBObject queryMFG = new BasicDBObject("mfgID", mfgID).append("mfgStatus", "anfrage");
        cursor = coll.find(queryMFG);

        for(DBObject d : cursor) {
            userID = (String) d.get("userID");


            coll = db.getCollection(COLLECTION_USERS);
            com.mongodb.DBCursor cursorMFG = coll.find();

            BasicDBObject query = new BasicDBObject("_id", new ObjectId(userID));
            cursorMFG = coll.find(query);

            for (DBObject s : cursorMFG) {
                ergDBquery.add(new User(
                        (String) s.get("vorname"),(String) s.get("nachname"),(String) s.get("email"),(String) s.get("geburtsdatum"),s.get("_id").toString()));
            }

        }
        dbInstance.dispose();
        return ergDBquery;

    }

    public static String setMFGStatus(String mfgID, String userID, String status ){

        if(status.equalsIgnoreCase("abgelehnt"))
        {
            DB db = dbInstance.getDB();
            coll = db.getCollection(COLLECTION_MFGBS);
            com.mongodb.DBCursor cursor = coll.find();

            BasicDBObject queryMFG = new BasicDBObject("mfgID", mfgID).append("userID", userID);
            cursor = coll.find(queryMFG);

            BasicDBObject doc = new BasicDBObject();
            doc.put("mfgStatus", "abgelehnt");
            BasicDBObject newStatusAb = new BasicDBObject();
            newStatusAb.put("$set", doc);
            coll.update(queryMFG, newStatusAb);

            return "Du hast die Mitfahrt abgelehnt";
        }

        if(status.contentEquals("bestaetigt"))
        {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // Anzahl der Mitfahrer -1 wenn die Buchung bestätigz wird
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            DB dbMFG = dbInstance.getDB();
            coll = dbMFG.getCollection(COLLECTION_MFG);
            com.mongodb.DBCursor cursorMFG = coll.find();

            BasicDBObject query = new BasicDBObject("_id", new ObjectId(mfgID));
            cursorMFG = coll.find(query);

            int mitfahrerAnz =0;
            for(DBObject s : cursorMFG) {
                mitfahrerAnz = (int) s.get("mitfahrer");
            }

            if(mitfahrerAnz >= 1){
                mitfahrerAnz --;
                BasicDBObject idoc = new BasicDBObject();
                idoc.put("mitfahrer", mitfahrerAnz);
                BasicDBObject newFahrerAnz = new BasicDBObject();
                newFahrerAnz.put("$set", idoc);
                coll.update(query, newFahrerAnz);


                // Status auf bestaetigt setzten
                DB db = dbInstance.getDB();
                coll = db.getCollection(COLLECTION_MFGBS);
                com.mongodb.DBCursor cursor = coll.find();

                BasicDBObject queryMFG = new BasicDBObject("mfgID", mfgID).append("userID",userID);
                cursor = coll.find(queryMFG);

                BasicDBObject doc = new BasicDBObject();
                doc.put("mfgStatus", "bestaetigt");
                BasicDBObject newStatusAb = new BasicDBObject();
                newStatusAb.put("$set", doc);
                coll.update(queryMFG, newStatusAb);

                return "Du hast die Mitfahrt bestätigt";
            }else{
                return "Es sind keine Plätze mehr frei! ";
            }

        }

        return "Ein Fehler ist aufgetreten!! Versuch es nochmal";
    }

}
