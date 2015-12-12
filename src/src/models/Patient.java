package models;

public class Patient {

    Name name;
    Date dateOfBirth;
    Address address;
    String phone;
    int patientId;

    //Not sure about inclusion of patientId, so left out of constructor for now

    public Patient(Name name, Date dateOfBirth, String phone, Address address) {
        this(name.getTitle(), name.getFirstName(), name.getSurname(), dateOfBirth, phone, address);
    }
    public Patient(Title title, String firstName, String surname, Date dateOfBirth, String phone, Address address) {
        this.name = new Name(title, firstName, surname);
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
    }

    public Name getName() { return name; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public String getPhone() { return phone; }
    public Address getAddress() { return address; }
}
