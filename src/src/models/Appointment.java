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
    private int appId;

    public Appointment(Time startTime, Time endTime, Patient patient, Partner partner, AppointmentType type, Date date, int appId){
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patient;
        this.partner = partner;
        this.type = type;
        this.date = date;
        if(startTime != null) {
            this.length = new Time(this.startTime.getTime()
                    .minusHours(this.endTime.getTime().getHour())
                    .minusMinutes(this.endTime.getTime().getMinute()));
        }
        this.treatments = new ArrayList<>();
        this.appId = appId;
//        this.treatments.add(new Treatment(TreatmentType.AMALGAM_FILLING, this));
    }

    public Appointment(Partner partner, AppointmentType type, Date date, int appId){
        this(null, null, null, partner, type, date, appId);
    }

    public Appointment(Time startTime, Time endTime, Patient patient, Partner partner, AppointmentType type, Date date, ArrayList<Treatment> treatments, int appId){
        this(startTime, endTime, patient, partner, type, date, appId);
        this.treatments = treatments;
    }

    public void setAppId(int appId){
        this.appId = appId;
    }
    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public Patient getPatient() { return patient; }
    public Partner getPartner() { return partner; }
    public AppointmentType getType() { return type; }
    public Date getDate() { return date; }
    public Time getLength() { return length; }
    public int getAppId(){ return this.appId; }
    public String toString(){
        if(startTime != null)
            return this.date + " " + this.startTime + " - " + this.endTime + " Patient: " + this.patient.toString() + this.patient.getAddress().toString() + " With: " + this.partner.getName() + " Type: " + this.type;
        else
            return this.date + " With: " + this.partner.getName() + " Type: " + this.type;
    }

}
