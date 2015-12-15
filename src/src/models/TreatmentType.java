package models;

public enum TreatmentType {
    HYGIENE("Hygiene", 45),
    CHECK_UP("Check-up", 45),
    AMALGAM_FILLING("Silver Amalgam Filling", 90),
    RESIN_FILLING("White Composite Resin Filling", 150),
    GOLD_CROWN("Gold Crown Fitting", 500);

    private String type;
    private double cost;
    TreatmentType(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public double getCost(){
        return this.cost;
    }

    public String toString() { return type; }
    public static String[] getList() {
        String[] temp = {
                CHECK_UP.toString(),
                HYGIENE.toString(),
                AMALGAM_FILLING.toString(),
                RESIN_FILLING.toString(),
                GOLD_CROWN.toString() };
        return temp;
    }

    public static TreatmentType getTreatmentType(String type){
        System.out.println(type);
        switch(type){
            case "Check-up":
                return CHECK_UP;
            case "Hygiene":
                return HYGIENE;
            case "Amalgam Filling":
                return AMALGAM_FILLING;
            case "Resin Filling":
                return RESIN_FILLING;
            default:
                return GOLD_CROWN;
        }
    }
}
