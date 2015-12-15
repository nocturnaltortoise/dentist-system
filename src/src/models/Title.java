package models;

public enum Title {
    MR("Mr"),
    MRS("Mrs"),
    MISS("Miss"),
    MS("Ms"),
    MASTER("Master"),
    DR("Dr");

    private String title;

    Title (String t) { title = t; }
    public String toString() { return title; }
}
