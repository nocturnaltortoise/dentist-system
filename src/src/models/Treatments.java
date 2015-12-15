package models;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Treatments {

    public static ArrayList<Treatment> getAll(Appointment app){

        ArrayList<Treatment> treatmentList = new ArrayList<>();
        Connection Conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        try {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();

            ResultSet res = stmt.executeQuery("SELECT Treatment.AppointmentID, Treatment.TreatmentName, Treatment.AmountPaid " +
                                            "FROM Treatment WHERE Treatment.AppointmentID = " + app.getAppId());

            while(res.next()){
                String name = res.getString(2);
                double owed = res.getDouble(3);

                Treatment treatment = new Treatment(TreatmentType.getTreatmentType(name), app, owed);
                treatmentList.add(treatment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (Conn != null)
                try {
                    Conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return treatmentList;
    }

    public static void add(Treatment treatment){

        int appId = treatment.getApp().getAppId();
        String name = treatment.getType().toString();
        double amountOwed = treatment.getType().getCost();

        Connection Conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        try
        {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();

            String sql = "INSERT INTO Treatment " +
        			"VALUES ('" + appId + "', '" + name + "', '" + amountOwed + "')";
            stmt.executeUpdate(sql);
        }
        catch (SQLException e)
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
