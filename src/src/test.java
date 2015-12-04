import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
public class test
{
    public static void main (String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
	      Connection Conn = null;
        Statement stmt = null;
        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team001?user=team001&password=55e68e81";
        try
        {
            Conn = DriverManager.getConnection(DB);
            stmt = Conn.createStatement();
                       
            ResultSet res = stmt.executeQuery("SELECT Patient.PatientID as 'ID', Patient.Title, " + 
            	  "Patient.First as 'First Name', Patient.Last as 'Surname', " + 
                "Patient.Dob as 'Date of Birth', Patient.Tel as 'Telephone Number', " + 
                "Address.HouseNum as 'House Number', Address.Street, Address.District, Address.City, " + 
                "Address.PostCode, Patient.PlanName as 'Plan Name', " + 
                "Plan.MonthlyP as 'Monthly Payment', Plan.Level as 'Service Level' FROM " + 
                "Patient INNER JOIN Address ON Patient.AddressID = Address.AddressID " + 
                "LEFT JOIN Plan ON Patient.PlanName = Plan.Name");
            ResultSetMetaData rsmd = res.getMetaData();
            
            while (res.next())
            {
                for (int i = 1; i<=14; i++)
                {
                    String field = res.getString(i);
                    System.out.println(rsmd.getColumnLabel(i) + ": " + field);
                }
                System.out.println();
            }     
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
