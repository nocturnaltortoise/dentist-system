package models;

public enum AppointmentType {
    HYGIENE("Hygiene"),
    CHECK_UP("Check Up"),
    AMALGAM_FILLING("Amalgam Filling"),
    RESIN_FILLING("Resin Filling"),
    GOLD_CROWN("Gold Crown Filling");

    private String type;
    AppointmentType(String t) { type = t; }
    public String toString() { return type; }
    public static String[] getList() {
        String[] temp = {
                HYGIENE.toString(),
                CHECK_UP.toString(),
                AMALGAM_FILLING.toString(),
                RESIN_FILLING.toString(),
                GOLD_CROWN.toString() };
        return temp;
    }

    public static long getLength(AppointmentType appType){

        switch(appType){
            case HYGIENE:
                return 20;
            case CHECK_UP:
                return 20;
            default:
                return 60;
        }

    }
}
