package models;

public enum HealthcarePlan {
    NONE("None"),
    NHS_FREE_PLAN("NHS Free Plan"),
    MAINTENANCE_PLAN("Maintenance Plan"),
    ORAL_HEALTH_PLAN("Oral Health Plan"),
    DENTAL_REPAIR_PLAN("Dental Repair Plan");

    private String name;
    HealthcarePlan(String name){ this.name = name; }
}
