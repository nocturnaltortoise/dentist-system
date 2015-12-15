package models;

public class Treatment {

    private TreatmentType type;
    private double cost;
    private Appointment app;

    public Treatment(TreatmentType treatmentType, Appointment app){
        this.type = treatmentType;
        this.cost = this.type.getCost();
        this.app = app;
    }

    @Override
    public String toString(){
        return this.type.toString() + " " + "£" + this.cost + " For Appointment: " + this.app.toString();
    }


}
