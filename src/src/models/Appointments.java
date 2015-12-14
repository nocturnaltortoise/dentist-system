package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Appointments  {
	
	private static Partner dentist = new Partner(Title.DR, "Jason", "Bourne", PartnerType.DENTIST);
    private static Partner hygienist = new Partner(Title.DR, "Charlotte", "Webb", PartnerType.HYGIENIST);
    
    //designed to be used statically, as in models.Appointments.search(some query)
    //these are all the queries I can think of, but there may be more needed.
    public static ArrayList<Appointment> getAll() {
    	Connection Conn = null;
        Statement stmt = null;
        try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";
        
        ArrayList<Appointment> applist = new ArrayList<Appointment>();
        
        try
        {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();
                       
            ResultSet res = stmt.executeQuery("SELECT  Address.HouseNum, Address.Street, Address.District, " +
            		"Address.City, Address.PostCode, Treatment.TreatmentName, " +
            		"Patient.Title, Patient.First, Patient.Last, Patient.Dob, Patient.Tel, Patient.PatientID, " +
                    "Appointment.StartTime,  Appointment.EndTime, Appointment.Partner, " +
            		"Appointment.Date FROM Appointment INNER JOIN Patient ON Appointment.PatientID = Patient.PatientID " +
                    "INNER JOIN Address ON Patient.AddressID = Address.AddressID " +
                    "INNER JOIN Treatment ON Appointment.AppointmentID = Treatment.AppointmentID");
            while (res.next())
            {
                Address addr = new Address(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                AppointmentType type = null;
                switch(res.getString(6))
                {
                	case "Check-up": type = AppointmentType.CHECK_UP;
                		break;
                	case "Hygiene": type = AppointmentType.HYGIENE;
                		break;
                	case "Silver Amalgam Filling": type = AppointmentType.AMALGAM_FILLING;
                		break;
                	case "White Composite Resin Filling": type = AppointmentType.RESIN_FILLING;
                		break;
                	case "Gold Crown Fitting": type = AppointmentType.GOLD_CROWN;
                		break;               
                }
                Title ttl = null;
                switch(res.getString(7))
                {
                	case "Mr": ttl = Title.MR;
                		break;
                	case "Mrs": ttl = Title.MRS;
            			break;
                	case "Miss": ttl = Title.MISS;
            			break;
                	case "Ms": ttl = Title.MS;
            			break;
                	case "Dr": ttl = Title.DR;
            			break;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Date dob = new Date(LocalDate.parse(res.getString(10), formatter));
            	Patient pat = new Patient(ttl, res.getString(8), res.getString(9), dob, res.getString(11), addr, res.getInt(12));
            	Time start = new Time(res.getString(13).substring(0, 5));
            	Time end = new Time(res.getString(14).substring(0, 5));
            	Partner dr = null;
            	if (res.getString(15).equals("Dentist"))
            		dr = dentist;
            	else
            		dr = hygienist;
            	Date dat = new Date(LocalDate.parse(res.getString(16), formatter));
                
            	//System.out.println(dob.toString() + " " + dat.toString());
            	
            	Appointment app = new Appointment(start, end, pat, dr, type, dat);
            	applist.add(app);
            }     
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
        return applist;
    }

    public static ArrayList<Appointment> getAll(int patientId) {
    	Connection Conn = null;
        Statement stmt = null;
        try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";
        
        ArrayList<Appointment> applist = new ArrayList<Appointment>();
        
        try
        {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();
            Patient pat = null;
            
            ResultSet res = stmt.executeQuery("SELECT  Address.HouseNum, Address.Street, Address.District, " +
            		"Address.City, Address.PostCode, Patient.Title, Patient.First, " +
            		"Patient.Last, Patient.Dob, Patient.Tel, Patient.PatientID FROM Patient INNER JOIN " +
            		"Address ON Patient.AddressID = Address.AddressID WHERE PatientID = " + patientId);
            while (res.next())
            {
            	Address addr = new Address(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            	Title ttl = null;
                switch(res.getString(6))
                {
                	case "Mr": ttl = Title.MR;
                		break;
                	case "Mrs": ttl = Title.MRS;
            			break;
                	case "Miss": ttl = Title.MISS;
            			break;
                	case "Ms": ttl = Title.MS;
            			break;
                	case "Dr": ttl = Title.DR;
            			break;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Date dob = new Date(LocalDate.parse(res.getString(9), formatter));
            	pat = new Patient(ttl, res.getString(7), res.getString(8), dob, res.getString(10), addr, res.getInt(11));
            }
                       
            res = stmt.executeQuery("SELECT  Treatment.TreatmentName, Appointment.StartTime, " +
                    "Appointment.EndTime, Appointment.Partner, Appointment.Date FROM " +
            		"Appointment INNER JOIN Treatment ON Appointment.AppointmentID = Treatment.AppointmentID");
            while (res.next())
            {
            	
                AppointmentType type = null;
                switch(res.getString(1))
                {
                	case "Check-up": type = AppointmentType.CHECK_UP;
                		break;
                	case "Hygiene": type = AppointmentType.HYGIENE;
                		break;
                	case "Silver Amalgam Filling": type = AppointmentType.AMALGAM_FILLING;
                		break;
                	case "White Composite Resin Filling": type = AppointmentType.RESIN_FILLING;
                		break;
                	case "Gold Crown Fitting": type = AppointmentType.GOLD_CROWN;
                		break;               
                }
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            	Time start = new Time(res.getString(2).substring(0, 5));
            	Time end = new Time(res.getString(3).substring(0, 5));
            	Partner dr = null;
            	if (res.getString(4).equals("Dentist"))
            		dr = dentist;
            	else
            		dr = hygienist;
            	Date dat = new Date(LocalDate.parse(res.getString(5), formatter));
            	
            	Appointment app = new Appointment(start, end, pat, dr, type, dat);
            	applist.add(app);
            }     
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
        return applist;
    }
    

    public static void add(Appointment app){
    	String date = app.getDate().toString();
    	String start = app.getStartTime().toString();
    	String end = app.getEndTime().toString();
    	String partner = app.getPartner().getPartnerType().toString();
    	int patientId = app.getPatient().getId();
    	
    	
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
            String sql = "INSERT INTO Appointment " +
            			"VALUES (null, " + date + ", " + start + ", "+ end + ", " + partner + ", " + patientId + ")";
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

    public static void addEmpty(Date appDate, Time startTime, Time endTime, Partner appPartner){
    	String date = appDate.toString();
    	String start = startTime.toString();
    	String end = endTime.toString();
    	String partner = appPartner.getPartnerType().toString();
    	
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
            String sql = "INSERT INTO Appointment " +
            			"VALUES (null, " + date + ", " + start + ", "+ end + ", " + partner + ", null)";
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
    
    public static void delete(Appointment app){
    	
    	String date = app.getDate().toString();
    	String time = app.getStartTime().toString();
    	String partner = app.getPartner().getPartnerType().toString();
    	//An appointment is uniquely identified by date, time and partner
    	
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
            String sql = "DELETE FROM Appointment" +
            			" WHERE Date = " + date + " AND StartTime = " + time +
            			" AND Partner = " + partner;
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
