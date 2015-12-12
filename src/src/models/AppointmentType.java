package models;

public enum AppointmentType {
    HYGIENE("Hygiene"),
    CHECK_UP("Check Up"),
    AMALGAM_FILLING("Amalgam Filling");

    private String type;
    AppointmentType(String t) { type = t; }
    public String toString() { return type; }
    public static String[] getList() {
        String[] temp = {
                HYGIENE.toString(),
                CHECK_UP.toString(),
                AMALGAM_FILLING.toString() };
        return temp;
    }
}
