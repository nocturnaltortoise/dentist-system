package models;

import java.util.ArrayList;

public class Appointment {

    private Time startTime;
    private Time endTime;
    private Patient patient;
    private Partner partner;
    private AppointmentType type;
    private Date date;
    private Time length;
    private ArrayList<Treatment> treatments;

    public Appointment(Time startTime, Time endTime, Patient patient, Partner partner, AppointmentType type, Date date){
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.partner = partner;
        this.type = type;
        this.date = date;
        this.length = new Time(this.startTime.getTime()
                .minusHours(this.endTime.getTime().getHour())
                .minusMinutes(this.endTime.getTime().getMinute()));
        this.treatments = new ArrayList<>();
//        this.treatments.add(new Treatment(TreatmentType.AMALGAM_FILLING, this));
    }

    public Appointment(Time startTime, Time endTime, Patient patient, Partner partner, AppointmentType type, Date date, ArrayList<Treatment> treatments){
        this(startTime, endTime, patient, partner, type, date);
        this.treatments = treatments;
    }

    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public Patient getPatient() { return patient; }
    public Partner getPartner() { return partner; }
    public AppointmentType getType() { return type; }
    public Date getDate() { return date; }
    public Time getLength() { return length; }
    public String toString(){
        return this.date + " " + this.startTime + " - " + this.endTime + " Patient: " + this.patient.toString() + " With: " + this.partner.getName() + " Type: " + this.type;
    }

}
