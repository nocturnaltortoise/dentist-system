/**
 * Created by George Baron on 06/12/2015.
 */
public enum AppointmentType {
    HYGIENE("Hygiene"),
    CHECK_UP("Check Up"),
    AMALGAM_FILLING("Amalgam Filling");

    private String type;
    AppointmentType(String t) { type = t; }
    public String toString() { return type; }
}
