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
                       
            ResultSet res = stmt.executeQuery("SELECT models.Patient.PatientID as 'ID', models.Patient.models.Title, " +
            	  "models.Patient.First as 'First models.Name', models.Patient.Last as 'Surname', " +
                "models.Patient.Dob as 'models.Date of Birth', models.Patient.Tel as 'Telephone Number', " +
                "models.Address.HouseNum as 'House Number', models.Address.Street, models.Address.District, models.Address.City, " +
                "models.Address.PostCode, models.Patient.PlanName as 'Plan models.Name', " +
                "Plan.MonthlyP as 'Monthly Payment', Plan.Level as 'Service Level' FROM " + 
                "models.Patient INNER JOIN models.Address ON models.Patient.AddressID = models.Address.AddressID " +
                "LEFT JOIN Plan ON models.Patient.PlanName = Plan.models.Name");
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
