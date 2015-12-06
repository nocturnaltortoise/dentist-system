import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Created by George Baron on 06/12/2015.
 */
public abstract class DateTime {

    private DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
    private DateTimeFormatter formatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

    protected LocalDate parseDate(String d) { return LocalDate.parse(d, formatDate); }
    protected LocalTime parseTime(String t) { return LocalTime.parse(t, formatTime); }
    public abstract String toString();

}
