package database;

import com.mongodb.*;
import play.Logger;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Markus on 18.01.14.
 */
public class LoginDBHandler {

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


    /**
     *  Passwort und Username Abfrage
     *
     * @param email
     * @param password
     * @param remember
     * @return
     */
    public boolean getItemsCheckLogin(String email, String password, boolean remember){

        String findUserDoc = "";

        BasicDBObject query = new BasicDBObject("email", email).append(
                "password", password);
        com.mongodb.DBCursor cursor = coll.find();
        cursor = coll.find(query);

        try {
            while (cursor.hasNext()) {
                findUserDoc += cursor.next();
            }
        } finally {
            cursor.close();
        }

        if (findUserDoc.isEmpty()) {
            return false;
        }

        //ToDo
        /*
        Login mit Username
        LoginDatum
        */

        dbInstance.dispose();
        return true;
    }
}


