import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class CreateTables
{

        //This doesn't need to be ran again - it has already created the databas tables. It's here just to show what we did.
        public static void main (String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
        {
                Connection Conn = null;
                Statement stmt;
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
                String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";
                try
                {
                        Conn = DriverManager.getConnection(DB);
                        stmt = Conn.createStatement();

                        String sql = "CREATE TABLE Address " +
                        	"(AddressID INTEGER AUTO_INCREMENT, " +
                        	" HouseNum INTEGER NOT NULL, " +
                        	" Street VARCHAR(50) NOT NULL, " +
                        	" District VARCHAR(50), " +
                        	" City VARCHAR(50) NOT NULL, " +
                        	" Postcode VARCHAR(15) NOT NULL, " +
                        	" PRIMARY KEY ( AddressID ))";

                        stmt.executeUpdate(sql);


                        sql = "CREATE TABLE Plan " +
                        	"(Name VARCHAR(30) UNIQUE NOT NULL, " +
                            " MonthlyP INTEGER NOT NULL, " +
                            " Level VARCHAR(100) NOT NULL, " +
                            " PRIMARY KEY ( Name ))";

                        sql = "CREATE TABLE Plan " +
                        	"(Name VARCHAR(30) UNIQUE NOT NULL, " +
                            " MonthlyPayment INTEGER NOT NULL, " +
                            " CheckUps INTEGER NOT NULL, " +
                                "Hygiene INTEGER NOT NULL, "+
                                "Repairs INTEGER NOT NULL, " +
                            " PRIMARY KEY ( Name ))";
//
                        stmt.executeUpdate(sql);


                        sql = "CREATE TABLE Patient " +
                        	"(PatientID INTEGER AUTO_INCREMENT, " +
                            " Title VARCHAR(10), " +
                            " First VARCHAR(50) NOT NULL, " +
                            " Last VARCHAR(50) NOT NULL, " +
                            " Dob DATE, " +
                            " Tel VARCHAR(20), " +
                            " AddressID INTEGER NOT NULL, " +
                            " PlanName VARCHAR(30), " +
                            " PRIMARY KEY ( PatientID ), " +
                            " FOREIGN KEY (AddressID) REFERENCES Address(AddressID), " +
                            " FOREIGN KEY (PlanName) REFERENCES Plan(Name))";

                        stmt.executeUpdate(sql);

                        sql = "CREATE TABLE Appointment " +
                            "(AppointmentID INTEGER AUTO_INCREMENT, " +
                            " Date DATE NOT NULL, " +
                            " StartTime TIME, " +
                            " EndTime TIME, " +
                            " Partner VARCHAR(10) NOT NULL, " +
                            " PatientID INTEGER, " +
                            " Type VARCHAR(30) NOT NULL," +
                            " PRIMARY KEY ( AppointmentID ), " +
                            " FOREIGN KEY (PatientID) REFERENCES Patient(PatientID))";

                        stmt.executeUpdate(sql);
//
                        sql = "CREATE TABLE Treatment " +
                            "(AppointmentID INTEGER NOT NULL, " +
                            " TreatmentName VARCHAR(30) NOT NULL, " +
                            " AmountPaid DOUBLE NOT NULL, " +
                            " PRIMARY KEY ( AppointmentID, TreatmentName ), " +
                            " FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID))";

                        stmt.executeUpdate(sql);
                }
                catch (SQLException e)
                {
                        e.printStackTrace();
                }
                finally
                {
                        if (Conn != null) Conn.close();
                }
        }
}
