package models;

public enum AppointmentType {
    HYGIENE("Hygiene"),
    CHECK_UP("Check-up"),
    TREATMENT("Treatment"),
    HOLIDAY("Holiday");

    private String type;
    AppointmentType(String t) { type = t; }
    public String toString() { return type; }
    public static String[] getList() {
        String[] temp = {
                HYGIENE.toString(),
                CHECK_UP.toString(),
                TREATMENT.toString(),
                HOLIDAY.toString() };
        return temp;
    }

    public static AppointmentType getAppointmentType(String type){
        switch(type){
            case "Check-up":
                return CHECK_UP;
            case "Hygiene":
                return HYGIENE;
            case "Holiday":
                return HOLIDAY;
            default:
                return TREATMENT;
        }
    }

    public static long getLength(AppointmentType appType){

        switch(appType){
            case HYGIENE:
                return 20;
            case CHECK_UP:
                return 20;
            case HOLIDAY:
                return 0;
            default:
                return 60;
        }

    }

    public static long getLength(String appType){
        return getLength(getAppointmentType(appType));
    }
}
