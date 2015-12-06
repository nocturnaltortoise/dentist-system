public class Name {

    private Title title;
    private String firstName;
    private String surname;

    public Name(Title title, String firstName, String surname) {
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Title getTitle() { return title; }
    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getFullName() { return title + ". " + firstName + " " + surname; }
}
