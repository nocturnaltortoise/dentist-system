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

            ResultSet res = stmt.executeQuery("SELECT Appointment.Type, " +
                    "Appointment.AppointmentID, Appointment.StartTime,  Appointment.EndTime, Appointment.Partner, " +
                    "Appointment.Date FROM Appointment WHERE Appointment.Type = 'Holiday'");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Appointment app;
            AppointmentType type;
            int appId;
            Time start;
            Time end;
            Partner dr = null;
            Date dat;

            while (res.next())
            {

                type = AppointmentType.getAppointmentType(res.getString(1));
                appId = Integer.valueOf(res.getString(2));
                if (res.getString(5).equals("Dentist"))
                    dr = dentist;
                else
                    dr = hygienist;
                dat = new Date(LocalDate.parse(res.getString(6), formatter));
                app = new Appointment(dr, type, dat, appId);
                applist.add(app);
            }

            res = stmt.executeQuery("SELECT Appointment.Type, " +
                    "Appointment.AppointmentID, Appointment.StartTime,  Appointment.EndTime, Appointment.Partner, " +
                    "Appointment.Date, " +
                    "Patient.Title, Patient.First, Patient.Last, Patient.Dob, Patient.Tel, Patient.PatientID, " +
                    "Address.HouseNum, Address.Street, Address.District, Address.City, Address.PostCode " +
                    "FROM Appointment " +
                    "INNER JOIN Patient ON Appointment.PatientID = Patient.PatientID " +
                    "INNER JOIN Address ON Patient.AddressID = Address.AddressID WHERE Appointment.Type <> 'Holiday'" );
            // "INNER JOIN Treatment ON Appointment.AppointmentID = Treatment.AppointmentID
            //Treatment.TreatmentName,
            while (res.next())
            {
                type = AppointmentType.getAppointmentType(res.getString(1));
                appId = Integer.valueOf(res.getString(2));
                start = new Time(res.getString(3).substring(0, 5));
                end = new Time(res.getString(4).substring(0, 5));
                if (res.getString(5).equals("Dentist"))
                    dr = dentist;
                else
                    dr = hygienist;
                dat = new Date(LocalDate.parse(res.getString(6), formatter));
                Address addr = new Address(res.getInt(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17));
                Date dob = new Date(LocalDate.parse(res.getString(10), formatter));
                Title ttl = null;
                switch(res.getString(7)) {
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
                Patient pat = new Patient(ttl, res.getString(8), res.getString(9), dob, res.getString(11), addr, res.getInt(12));
                app = new Appointment(start, end, pat, dr, type, dat, appId);
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
            		"Address ON Patient.AddressID = Address.AddressID WHERE Patient.PatientID = " + patientId);
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
                       
            res = stmt.executeQuery("SELECT Appointment.AppointmentID, Appointment.Type, Appointment.StartTime, " +
                    "Appointment.EndTime, Appointment.Partner, Appointment.Date FROM " +
            		"Appointment " +
            		" WHERE Appointment.PatientID = " + patientId);
            //Treatment.TreatmentName,
            //INNER JOIN Treatment ON Appointment.AppointmentID = Treatment.AppointmentID

            while (res.next())
            {
                int appId = Integer.valueOf(res.getString(1));
                AppointmentType type = AppointmentType.getAppointmentType(res.getString(2));
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            	Time start = new Time(res.getString(3).substring(0, 5));
            	Time end = new Time(res.getString(4).substring(0, 5));
            	Partner dr = null;
            	if (res.getString(5).equals("Dentist"))
            		dr = dentist;
            	else
            		dr = hygienist;
            	Date dat = new Date(LocalDate.parse(res.getString(6), formatter));
            	
            	Appointment app = new Appointment(start, end, pat, dr, type, dat, appId);
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
    	String partner = app.getPartner().getPartnerType().toString();
    	String type = app.getType().toString();
        String start = null;
        String end = null;
        int patientId = 0;

        if(app.getStartTime() != null) {
            start = app.getStartTime().toString();
            end = app.getEndTime().toString();
            patientId = app.getPatient().getId();
        }
    	
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
            String sql;
            if(app.getStartTime() != null) {
                sql = "INSERT INTO Appointment " +
                        "VALUES (null, '" + date + "', '" + start + "', '" + end + "', '" + partner + "', '" + patientId + "', '" + type + "')";
            } else {
                sql = "INSERT INTO Appointment (Date, Partner, Type) " +
                        "VALUES ('" + date + "', '" + partner + "', '" + type + "')";
            }
            stmt.executeUpdate(sql);
            
            int appId = 0;
            ResultSet res = stmt.executeQuery("SELECT * FROM Appointment " +
            			"ORDER BY AppointmentID DESC LIMIT 1");
            while(res.next())
            {
            	appId = res.getInt(1);
            }
            
//            sql = "INSERT INTO Treatment " +
//        			"VALUES (" + appId + ", '" + type +"')";
//            stmt.executeUpdate(sql);
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
            		"VALUES (null, '" + date + "', '" + start + "', '"+ end + "', '" + partner + "', null)";
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
            String sql = "SET FOREIGN_KEY_CHECKS = 0";
            stmt.executeUpdate(sql);
            
            sql = "DELETE FROM Appointment" +
            			" WHERE Date = '" + date + "' AND StartTime = '" + time + "'" +
            			" AND Partner = '" + partner +"'";
            stmt.executeUpdate(sql);
            
            int appId = 0;
            ResultSet res = stmt.executeQuery("SELECT * FROM Appointment " +
            			" WHERE Date = '" + date + "' AND StartTime = '" + time + "'" +
            			" AND Partner = '" + partner +"'");
            while(res.next())
            {
            	appId = res.getInt(1);
            }
            
            sql = "DELETE FROM Treatment" +
        			" WHERE AppointmentID = " + appId;
            stmt.executeUpdate(sql);
            
            sql = "SET FOREIGN_KEY_CHECKS = 1";
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

    public static int getMaxAppId() {
        Connection Conn = null;
        Statement stmt = null;
        int maxId = 0;
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String DB = "jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";

        try {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();

            String sql = "SELECT MAX(Appointment.AppointmentID) FROM Appointment";
//            stmt.executeUpdate(sql);

            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()){
                maxId = resultSet.getInt(1);
            }
            return maxId;


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
        return maxId;
    }

}
