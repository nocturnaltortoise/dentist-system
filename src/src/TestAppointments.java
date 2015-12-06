import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by George Baron on 06/12/2015.
 */
public class TestAppointments {

    private static Date dob1 = new Date("13.02.1996");
    private static Date dob2 = new Date("20.05.1992");
    private static Date dob3 = new Date("11.11.1973");

    private static Address add1 = new Address(4, "Test Street 1", "City 1", "District 1", "P0S TC01");
    private static Address add2 = new Address(4, "Test Street 2", "City 2", "District 2", "P0S TC02");
    private static Address add3 = new Address(4, "Test Street 3", "City 3", "District 3", "P0S TC03");

    private static Patient pat1 = new Patient(Title.MR, "John", "Doe", dob1, add1);
    private static Patient pat2 = new Patient(Title.MISS, "Jane", "Doe", dob2, add2);
    private static Patient pat3 = new Patient(Title.SWING_MASTER, "George", "Baron", dob3, add3);

    private static Partner dentist = new Partner(Title.DR, "Jason", "Bourne", PartnerType.DENTIST);
    private static Partner hygienist = new Partner(Title.DR, "Charlotte", "Webb", PartnerType.HYGIENIST);

    public static Appointment[] appointments = {
            new Appointment(new Time("11:00"), new Time("12:00"), pat1, dentist, AppointmentType.CHECK_UP, new Date(LocalDate.now().plusDays(1))),
            new Appointment(new Time("14:20"), new Time("15:00"), pat2, hygienist, AppointmentType.HYGIENE, new Date(LocalDate.now().plusDays(3))),
            new Appointment(new Time("17:00"), new Time("18:00"), pat3, dentist, AppointmentType.AMALGAM_FILLING, new Date(LocalDate.now().plusDays(4)))};

}
