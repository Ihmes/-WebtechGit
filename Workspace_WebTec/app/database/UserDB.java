package database;

import models.User;
import org.mongojack.DBCursor;
import play.Logger;

import com.mongodb.DB;


public class UserDB extends Finder<User>{
    public UserDB(DB db) {
        super(db, ConnectDB.COLLECTION_USERS, User.class);
    }

    private static UserDB instance = new UserDB(ConnectDB.getDB());


    public static void init() {
        Logger.info("Datenbank wird Inizalisiert");
        get().db.getCollection(ConnectDB.COLLECTION_USERS);
    }
    public static UserDB get(){
        return instance;
    }



//	public static UserDB get(){
//		if(instance == null){
//			instance = new UserDB(DBConnect.getDB());
//		}
//		return instance;
//	}

    public User create(User User){
        if(!contains(User)){
            return save(User);
        }else{
            return null;
        }
    }
//	public User addMFG(User user,String mfg_id){
//			user.mf_MFG_id.add(mfg_id);
//			return save(user);
//	}

    /**
     * @param skip offset
     * @param maxNum maximum number to return
     */
    public DBCursor<User> list(int skip, int maxNum){
        DBCursor<User> Users = getColl().find().skip(skip).limit(maxNum);
        return Users;
    }

    public boolean contains(User user){
        DBCursor<User> Users = getColl().find();

        for(User userDB : Users){
            if(user.email.equals(userDB.email)){
                return true;
            }
        }
        return false;
    }

    public User findByEmail(String email){
        DBCursor<User> Users = getColl().find();

        for(User userDB : Users){
            if(email.equals(userDB.email)){
                return userDB;
            }
        }
        return null;
    }

    public String getIdFromUser(User user){
        DBCursor<User> Users = getColl().find();

        for(User userDB : Users){
            if(user.email.equals(userDB.email)){
                return userDB._id;
            }
        }
        return null;
    }

    public DBCursor<User> list(){
        DBCursor<User> Users = getColl().find();
        return Users;
    }


    public User validateUser(String email, String password){

//		UserDB users = UserDB.get();
//		for(User u : users.collectionName("")){
//			
//		}
        DBCursor<User> Users = getColl().find();
        for(User user : Users){
            if(user.email.equals(email) && user.password.equals(password)){
                return user;
            }
        }
        return null;
    }


    public User validateUser(String email){

//		UserDB users = UserDB.get();
//		for(User u : users.collectionName("")){
//			
//		}
        DBCursor<User> Users = getColl().find();
        for(User user : Users){
            if(user.email.equals(email)){
                return user;
            }
        }
        return null;
    }
}





