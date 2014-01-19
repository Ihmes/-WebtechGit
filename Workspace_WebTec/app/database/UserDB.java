package database;

import models.User;
import org.mongojack.DBCursor;
import play.Logger;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static String COLLECTION_USERS = "User";
    private static ConnectDB dbInstance = new ConnectDB();
    private static DBCollection coll = null;

    /**
     *  Datenbankverbindung herstellen
     *  User Collection aufrufen
     */
    public static void getDBCollection(){
        DB db = dbInstance.getDB();
        coll = db.getCollection(COLLECTION_USERS);
    }


    public static List getUserDataByEmail(String email)
    {
        getDBCollection();
        List<User> Userdata = new ArrayList<>();

        BasicDBObject query = new BasicDBObject("email", email);
        com.mongodb.DBCursor cursor = coll.find();
        cursor = coll.find(query);

        for (DBObject s : cursor) {
            Userdata.add(new User((String) s.get("vorname"),
                    (String) s.get("nachname"), (String) s.get("email")));
        }

        dbInstance.dispose();
        return Userdata;

    }


}