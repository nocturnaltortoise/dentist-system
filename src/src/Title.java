public enum Title {
    MR("Mr"),
    MRS("Mrs"),
    MISS("Miss"),
    MS("Ms"),
    MASTER("Master"),
    DR("Dr"),
    SWING_MASTER("Swing Master");

    private String title;

    Title (String t) { title = t; }
    public String toString() { return title; }
}
