import java.time.LocalTime;

/**
 * Created by George Baron on 06/12/2015.
 */
public class Time extends DateTime {


    private LocalTime time;

    public Time(LocalTime time) {
        this.time = time;
    }
    public Time(String time) {
        this.time = parseTime(time);
    }
    public LocalTime getTime() { return time; }

    public boolean equals(Time d) { return time.equals(d.getTime()); }
    public String toString() { return time.toString(); }
}
