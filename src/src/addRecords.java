import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class addRecords
{

        //This doesn't need to be ran again, it's here to show how we added test data.
        public static void main (String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
        {
                Connection Conn = null;
                Statement stmt = null;
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
                String DB=""; // add url to mysql server here (should look like jdbc:mysql:someserverurl)
                try
                {
                        Conn = DriverManager.getConnection(DB);
                        stmt = Conn.createStatement();
                        String sql;

                        sql = "INSERT INTO Plan " +
                                "VALUES ('NONE', 0, 0, 0, 0)";
                        stmt.executeUpdate(sql);

                        sql = "INSERT INTO Plan " +
                                "VALUES ('NHS Free Plan', 0, 2, 2, 6)";
                        stmt.executeUpdate(sql);

                        sql = "INSERT INTO Plan " +
                                "VALUES ('Maintenance Plan', 15, 2, 2, 0)";
                        stmt.executeUpdate(sql);

                        sql = "INSERT INTO Plan " +
                                "VALUES ('Oral Health Plan', 21, 2, 4, 0)";
                        stmt.executeUpdate(sql);

                        sql = "INSERT INTO Plan " +
                                "VALUES ('Dental Repair Plan', 36, 2, 2, 2)";
                        stmt.executeUpdate(sql);
//
//                        sql = "INSERT INTO Address " +
//                                "VALUES (null, 51, 'Wellington Street', null, 'Sheffield', 'S1 4HL')";
//                        stmt.executeUpdate(sql);
//
//                        sql = "INSERT INTO Address " +
//                                "VALUES (null, 2, 'Untitled Street', 'Meadowhall', 'Sheffield', 'S9 3RE')";
//                        stmt.executeUpdate(sql);
//
//                        sql = "INSERT INTO Patient " +
//                           "VALUES (null, 'Mrs', 'Gloria', 'Ruth', 5/5/1990, '07123456789', 1, 'Maintenance Plan')";
//                        stmt.executeUpdate(sql);
//
//                        sql = "ALTER TABLE Patient " +
//           			 		        "MODIFY COLUMN PlanName VARCHAR(30)";
//           			 	      stmt.executeUpdate(sql);
//
//                        sql = "INSERT INTO Patient " +
//                           "VALUES (null, 'Mr', 'Mojo', 'Risin', 12/8/1943, '07987654321', 2, null)";
//                        stmt.executeUpdate(sql);
                       
                       
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
