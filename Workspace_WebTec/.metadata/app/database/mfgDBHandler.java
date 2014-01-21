package database;

import com.mongodb.*;
import models.ValideMFG;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import play.mvc.Result;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Markus on 20.01.14.
 */
public class mfgDBHandler {

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

    public static String getMFGSave(String id, String startort, String zielort, int mitfahrer, String datum, String uhrzeit, boolean status){

        //Speichern der Daten

        BasicDBObject doc = new BasicDBObject("id", id)
                .append("startort", startort).append("zielort", zielort)
                .append("mitfahrer", mitfahrer).append("datum", datum)
                .append("uhrzeit", uhrzeit).append("status", status);
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
                    ergDBquery.add(new ValideMFG((String) s.get("id"),
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
                    ergDBquery.add(new ValideMFG((String) s.get("id"),
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
                ergDBquery.add(new ValideMFG((String) s.get("id"),
                        (String) s.get("startort"),(String) s.get("zielort"),
                        (String) s.get("datum"),
                        (String) s.get("uhrzeit")));

            }
        }
        dbInstance.dispose();
        return ergDBquery;

    }




}
