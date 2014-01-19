package database;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import database.ConnectDB;
import play.Logger;
import scala.languageFeature;

/**
 * Created by Markus on 15.01.14.
 */
public class RegistrierungDBHandler {

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
     * Überprüfen ob Email und Username Eindeutig sind
     *
     * @param username
     *  @param email
     */
    public String getItemsCheckSave(String username, String email, String password, String vorname, String nachname){

        String findUsername = "";
        String findEmail = "";

        com.mongodb.DBCursor cursor = coll.find();
        BasicDBObject query = new BasicDBObject("username", username);
        cursor = coll.find(query);

        try {
            while (cursor.hasNext()) {
                findUsername += cursor.next();
            }
        } finally {
            cursor.close();
        }

        if (!findUsername.isEmpty()) {
            dbInstance.dispose();
            return "Der Username wurde schon verwendet. Bitte verwende einen anderen!";
        }

        query = new BasicDBObject("email", email);
        cursor = coll.find(query);

        try {
            while (cursor.hasNext()) {
                findEmail += cursor.next();
            }
        } finally {
            cursor.close();
        }

        if (!findEmail.isEmpty()) {
            dbInstance.dispose();
            return "Der Username wurde schon verwendet. Bitte verwende einen anderen!";
        }

        //Speichern der Daten

        BasicDBObject doc = new BasicDBObject("username", username)
                .append("email", email).append("password", password)
                        //.append("titel", titel).append("fahrertyp", fahrertyp)
                        //.append("geburtsdatum", geburtsdatum).append("alt", alt)
                .append("vorname", vorname).append("nachname", nachname);
        //.append("tel", telefon)
        //.append("registrierungsdatum", registrierungsdatum);
        coll.insert(doc);
        dbInstance.dispose();

        return "";
    }
}
