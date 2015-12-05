import java.time.LocalTime;

public class Appointment {

    LocalTime startTime;
    LocalTime endTime;
    Patient patient;
    Partner partner;
    LocalTime date;
    LocalTime length;

    public Appointment(LocalTime startTime, LocalTime endTime, Patient patient, Partner partner, LocalTime date){
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.partner = partner;
        this.date = date;
        this.length = this.startTime
                        .minusHours(this.endTime.getHour())
                        .minusMinutes(this.endTime.getMinute());
    }

}
