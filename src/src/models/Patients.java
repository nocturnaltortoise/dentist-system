package models;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Patients {

    public static Patient getAll(int patientId){

        Connection Conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        Patient pat = null;

        try {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();

            ResultSet res = stmt.executeQuery("SELECT  Address.HouseNum, Address.Street, Address.District, " +
                    "Address.City, Address.PostCode, Patient.Title, Patient.First, " +
                    "Patient.Last, Patient.Dob, Patient.Tel, Patient.PatientID, Patient.PlanName FROM Patient INNER JOIN " +
                    "Address ON Patient.AddressID = Address.AddressID WHERE PatientID = " + patientId);
            while (res.next()) {
                Address addr = new Address(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                Title ttl = null;
                switch (res.getString(6)) {
                    case "Mr":
                        ttl = Title.MR;
                        break;
                    case "Mrs":
                        ttl = Title.MRS;
                        break;
                    case "Miss":
                        ttl = Title.MISS;
                        break;
                    case "Ms":
                        ttl = Title.MS;
                        break;
                    case "Dr":
                        ttl = Title.DR;
                        break;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Date dob = new Date(LocalDate.parse(res.getString(9), formatter));
                System.out.println("Here: " + res.getString(12));
                pat = new Patient(ttl, res.getString(7), res.getString(8), dob, res.getString(10), addr, res.getInt(11), HealthcarePlan.getHealthcarePlan(res.getString(12)));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (Conn != null)
                try {
                    Conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return pat;
    }

    public static void add(Patient patient){
        Connection Conn = null;
        Statement stmt;

        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        try{
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();

            String title = patient.getName().getTitle().toString();
            String firstName = patient.getName().getFirstName();
            String surname = patient.getName().getSurname();
            String dateOfBirth = patient.getDateOfBirth().toString();
            String phone = patient.getPhone();
            String houseNumber = "" + patient.getAddress().houseNumber;
            String street = patient.getAddress().streetName;
            String district = patient.getAddress().districtName;
            String city = patient.getAddress().cityName;
            String postcode = patient.getAddress().postCode;
            String plan = HealthcarePlan.NONE.toString();

            String sql = "INSERT INTO Address VALUES(null, '" + houseNumber + "','" + street + "','" + district + "','" + city + "','" + postcode + "'" + ")";

            stmt.executeUpdate(sql);

            ResultSet res = stmt.executeQuery("SELECT MAX(Address.AddressID) FROM Address ");

            int addressId = 0;
            while(res.next()){
                addressId = res.getInt(1);
                System.out.println(addressId);
            }


            sql = "INSERT INTO Patient VALUES(null, '" + title
            + "','" + firstName + "' , '" + surname + "','" + dateOfBirth + "','" + phone + "','" + addressId + "','" + plan + "'" +  ")";

            stmt.executeUpdate(sql);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (Conn != null)
                try {
                    Conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void changePlan(Patient patient, String plan){
        Connection Conn = null;
        Statement stmt;

        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        try{
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();
            String sql = "UPDATE Patient SET PlanName = '" + plan + "' WHERE PatientID = " + patient.getId();
            stmt.executeUpdate(sql);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (Conn != null)
                try {
                    Conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

}
