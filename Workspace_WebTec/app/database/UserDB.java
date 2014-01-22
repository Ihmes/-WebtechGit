package database;

import models.User;
import models.ValideMFG;
import org.mongojack.DBCursor;
import play.Logger;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static String COLLECTION_USERS = "User";
    private static ConnectDB dbInstance = new ConnectDB();
    private static DB db;
    private static DBCollection coll;

    /**
     *  Datenbankverbindung herstellen
     *  User Collection aufrufen
     */
    public static void getDBCollection(){
        db = dbInstance.getDB();
    }

    /*
     * Der Username ist unique in der DB
     */
    public static String getUsernameByEmail(String email)
    {
        coll = db.getCollection(COLLECTION_USERS);
        String username = "";

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);

        cursor = coll.find(query);


        for(DBObject s : cursor) {
            username = (String) s.get("username");
        }

        if(username.isEmpty()) {
           return "Datenbanl Fehler";
        }

        dbInstance.dispose();
        return username;
    }

    // Funktioniert noch nicht
    public static String getUserIdByEmail(String email)
    {
        coll = db.getCollection(COLLECTION_USERS);
        String userId = "";

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);

        cursor = coll.find(query);


        for(DBObject s : cursor) {
            userId = s.get("_id").toString();
        }

        dbInstance.dispose();
        return userId;
    }

    public static String getUserBirthdayByEmail(String email)
    {
        coll = db.getCollection(COLLECTION_USERS);
        String birthday = "";

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);

        cursor = coll.find(query);


        for(DBObject s : cursor) {
            birthday = (String) s.get("geburtsdatum");
        }

        if(birthday.isEmpty()) {
            return "Datenbanl Fehler";
        }

        dbInstance.dispose();
        return birthday;
    }

    public static List<User> getUserdataByEmail(String email){

        coll = db.getCollection(COLLECTION_USERS);
        List<User> Userdata = new ArrayList<User>();

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = new BasicDBObject();
        query.put("email", email);

        cursor = coll.find(query);


        for(DBObject s : cursor) {
            Userdata.add(new User(
                    (String) s.get("vorname"),(String) s.get("nachname"),
                    (String) s.get("email"),(String) s.get("geburtsdatum")));
        }

        dbInstance.dispose();
        return Userdata;
    }


}