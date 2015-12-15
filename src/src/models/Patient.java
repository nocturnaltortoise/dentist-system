package models;

public class Patient {

    HealthcarePlan plan = HealthcarePlan.NONE;
    Name name;
    Date dateOfBirth;
    Address address;
    String phone;
    int patientId;

    //Not sure about inclusion of patientId, so left out of constructor for now

    public Patient(Name name, Date dateOfBirth, String phone, Address address, int id) {
        this(name.getTitle(), name.getFirstName(), name.getSurname(), dateOfBirth, phone, address, id);
    }
    public Patient(Title title, String firstName, String surname, Date dateOfBirth, String phone, Address address) {
        this(title, firstName, surname, dateOfBirth, phone, address, 0);
    }
    public Patient(Title title, String firstName, String surname, Date dateOfBirth, String phone, Address address, int id) {
        this.name = new Name(title, firstName, surname);
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.patientId = id;
    }

    public Patient(Title title, String firstName, String surname, Date dateOfBirth, String phone, Address address, int id, HealthcarePlan plan){
        this(new Name(title, firstName, surname), dateOfBirth, phone, address, id);
        this.plan = plan;
    }


    public int getId() { return patientId; }
    public Name getName() { return name; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public String getPhone() { return phone; }
    public Address getAddress() { return address; }
    public HealthcarePlan getPlan() { return plan; }
    public String toString(){ return this.name + ", " + this.dateOfBirth.toString() + ", " + this.phone; }

    public void setPlan(String plan) { this.plan = HealthcarePlan.getHealthcarePlan(plan); }
}
