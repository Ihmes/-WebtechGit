package models;

import play.data.validation.Constraints;

/**
 * Created by Markus on 21.01.14.
 */
public class ValideBuchungssystem extends Entity {

    public ValideBuchungssystem(String mfgID, String mfgStatus, String userID ) {
        this.mfgID = mfgID;
        this.mfgStatus = mfgStatus;
        this.userID = userID;
    }


    public String userID;
    public String mfgStatus;
    public String mfgID;
}


