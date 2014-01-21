package models;

import org.mongojack.Id;
import org.mongojack.ObjectId;

/**
 * Created by Markus on 12.01.14.
 */
public abstract class Entity {
    /**
     * this is the correct setting for jackson to work for the mapping.
     */

    @Id
    @ObjectId
    public String _id;


    @Override
    public String toString() {
        return "" +getClass().getSimpleName() +" _id:" +_id;
    }

}

