package models;

import java.sql.*;

public class Treatments {

    public static void add(Treatment treatment){

        int appId = treatment.getApp().getAppId();
        String name = treatment.getType().toString();

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
        			"VALUES (" + appId + ", '" + name +"')";
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
