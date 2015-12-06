public class Patient {

    Name name;
    Date dateOfBirth;
    Address address;
    int patientId;

    //Not sure about inclusion of patientId, so left out of constructor for now

    public Patient(Name name, Date dateOfBirth, Address address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }
    public Patient(Title title, String firstName, String surname, Date dateOfBirth, Address address) {
        this.name = new Name(title, firstName, surname);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Name getName() { return name; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public Address getAddress() { return address; }
}
