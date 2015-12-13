package models;

public class Treatment {

    private AppointmentType type;
    private double cost;
    private Appointment app;

    public Treatment(AppointmentType treatmentType, double cost, Appointment app){
        this.type = treatmentType;
        this.cost = cost;
        this.app = app;
    }

    @Override
    public String toString(){
        return this.type.toString() + " " + "£" + this.cost + " For Appointment: " + this.app.toString();
    }


}
