package models;

public class Treatment {

    private TreatmentType type;
    private double amountPaid;
    private Appointment app;

    public Treatment(TreatmentType treatmentType, Appointment app, double amountPaid){
        this.type = treatmentType;
        this.amountPaid = amountPaid;
        this.app = app;
    }

    public Appointment getApp(){
        return this.app;
    }

    public double getAmountPaid(){
        return this.amountPaid;
    }

    public void setAmountPaid(double amountPaid){
        this.amountPaid = amountPaid;
    }

    public TreatmentType getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return this.type.toString() + " " + "£" + this.amountPaid + " For Appointment: " + this.app.toString();
    }


}
