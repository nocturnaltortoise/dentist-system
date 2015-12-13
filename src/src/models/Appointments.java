package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Appointments {

    //designed to be used statically, as in models.Appointments.search(some query)
    //these are all the queries I can think of, but there may be more needed.
    public static ArrayList<Appointment> getAll(){
        return null;
    }

    //SQL query for this should return appointments specifically linked to the patient id
    public static ArrayList<Appointment> getAll(int patientId) {
        //TEMPORARY
        return new ArrayList<Appointment>(Arrays.asList(TestAppointments.appointments));
    }

    public static ArrayList<Appointment> search(String query){
        return null;
    }

    public static void add(Appointment app){
    }

    public static void delete(Appointment app){
    }
}
