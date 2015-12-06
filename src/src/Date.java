import java.time.LocalDate;

public class Date extends DateTime {

    private LocalDate date;

    public Date(LocalDate date) {
        this.date = date;
    }
    public Date(String date) {
        this.date = parseDate(date);
    }
    public LocalDate getDate() { return date; }

    public boolean equals(Date d) { return date.equals(d.getDate()); }
    public String toString() { return date.toString(); }

}
