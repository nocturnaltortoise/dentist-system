/**
 * Created by George Baron on 06/12/2015.
 */
public enum PartnerType {
    DENTIST("Dentist"),
    HYGIENIST("Hygienist");

    private String type;
    PartnerType(String t) { type = t; }

    public String toString() { return type; }
}
