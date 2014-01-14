package database;


import com.mongodb.MongoClientURI;
import com.mongodb.MongoURI;
import play.Logger;
import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Created by Markus on 05.01.14.
 **/
public class ConnectDB {
        /**
         * Name of the mongodb collection
         **/
        public static final String COLLECTION_USERS = "User";

        private static MongoClient mongo;
        private static DB db;



        public static DB getDB(){
            if(null == db){
                try {
                    // IP and Port
                   //mongo = new MongoClient("ds039487.mongolab.com", 39487);
                   //DB db = mongo.getDB("mongolab_db");
                   //db.authenticate("Webtec", "6e559MB".toCharArray() );

                   mongo = new MongoClient("localhost",27017);
                   db = mongo.getDB("mfgDB");


                    Logger.info("DB created");
                } catch (UnknownHostException e) {
                    throw new RuntimeException("Failed to connect to db", e);
                }
                // Database name

            }

            return db;
        }

        public static void dispose(){
            Logger.info("releasing MongoClient");
            if(null != mongo){
                mongo.close();
                mongo = null;
                db = null;
            }
        }
}
