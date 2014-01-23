package models;

/**
 * Created by Markus on 20.01.14.
 */
public class ValideMFG extends Entity {

    public ValideMFG(String id, String startort, String zielort, int mitfahrer, String datum,
                          String uhrzeit, String fahrer  ) {
        this.id = id;
        this.startort = startort;
        this.zielort = zielort;
        this.mitfahrer = mitfahrer;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.fahrer = fahrer;
    }

    public ValideMFG(){}

    public ValideMFG(String id, String startort, String zielort, String datum,
                     String uhrzeit) {
        this.id = id;
        this.startort = startort;
        this.zielort = zielort;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
    }

    public String fahrer;
    public String id;
    public String startort;
    public String zielort;
    public int mitfahrer;
    public String datum;
    public String uhrzeit;
    public boolean status;

}