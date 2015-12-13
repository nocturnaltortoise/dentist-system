package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Date extends DateTime {

    private LocalDate date;

    public Date(LocalDate date) {
        this.date = date;
    }
    public Date(String date) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
            this.date = LocalDate.parse(date, formatter);
        }catch(DateTimeParseException e){
            e.printStackTrace();
        }
    }
    public LocalDate getDate() { return date; }

    public boolean equals(Date d) { return date.equals(d.getDate()); }
    public String toString() { return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear(); }

}
