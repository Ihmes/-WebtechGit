package database;

import com.mongodb.*;
import models.ValideMFG;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
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

    //newMFG.id,newMFG.startort,newMFG.zielort, newMFG.mitfahrer, newMFG.datum, newMFG.uhrzeit, false
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

    public static void searchByStartEnd(String start, String end){
       /*
        DBCollection coll = db.getCollection("user");
        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = (BasicDBObject) new BasicDBObject("username",
                nutzer);
        cursor = coll.find(query);

        for (DBObject s : cursor) {
            details.add(new KontoDetails((String) s
                    .get("registrierungsdatum"),
                    (String) s.get("username"), (String) s.get("email")));
        }

        if (!sucheDocumentFuerUser.isEmpty()) {
            fertig = true;
            if (sucheDocumentFuerUser.contains("Mitfahrer")) {
                testeFahrer = true;
            }
        }
        */
    }


    public static List<ValideMFG> getPrevList(){

        List<ValideMFG> details = new ArrayList<ValideMFG>();

        try {

            com.mongodb.DBCursor cursor = coll.find();
            BasicDBObject query = (BasicDBObject) new BasicDBObject("status",
                    false);

            cursor = coll.find(query);

            for (DBObject s : cursor) {
                details.add(new ValideMFG((String) s.get("id"),
                        (String) s.get("startort"),(String) s.get("zielort"),
                        Integer.parseInt((String) s.get("mitfahrer"))  ,(String) s.get("datum"),
                        (String) s.get("uhrzeit")));
            }

        } catch (Exception e) {
        }

        return details;
    }


}
