package models;

public enum HealthcarePlan {
    NONE("NONE"),
    NHS_FREE_PLAN("NHS Free Plan"),
    MAINTENANCE_PLAN("Maintenance Plan"),
    ORAL_HEALTH_PLAN("Oral Health Plan"),
    DENTAL_REPAIR_PLAN("Dental Repair Plan");

    private String name;
    HealthcarePlan(String name){ this.name = name; }

    public String toString() { return name; }

    public static HealthcarePlan getHealthcarePlan(String type){
        switch(type){
            case "NONE":
                return NONE;
            case "NHS Free Plan":
                return NHS_FREE_PLAN;
            case "Maintenance Plan":
                return MAINTENANCE_PLAN;
            case "Oral Health Plan":
                return ORAL_HEALTH_PLAN;
            default:
                return DENTAL_REPAIR_PLAN;
        }
    }
}
