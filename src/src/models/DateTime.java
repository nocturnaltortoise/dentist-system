package models;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import java.time.LocalTime;
import java.time.LocalDate;

public abstract class DateTime {

    // German locale makes for easier to read time formats, the English one is American English, and isn't as readable.
    private DateTimeFormatter formatDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
    private DateTimeFormatter formatTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);

    protected LocalDate parseDate(String d) { return LocalDate.parse(d, formatDate); }
    protected LocalTime parseTime(String t) { return LocalTime.parse(t, formatTime); }
    public abstract String toString();

}
