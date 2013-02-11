/*
 * Methodoi gia tin diasyndesi me tin vasi dedomenwn
 * 
 */

package engtest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CFatseas, GPanetsos
 */
public class DbConn {

	 public static Connection connect()
	 {
		 Connection connection = null;
		    try {
		        // Load the JDBC driver
		        String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
		        Class.forName(driverName);

		        // Create a connection to the database
                        //?useUnicode=true&characterEncoding=utf8
		        String url = "jdbc:mysql://localhost:3306/Ebuy";
		        String username = "root"; //username toy xristi gia sindensi stin vasi
		        String password = "1212"; //password
		        connection = DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        // Could not find the database driver
                        System.out.println("Driver Error");
		    } catch (SQLException e) {
		        // Could not connect to the database
                        System.out.println("DB Error");
		    }
		    return connection;
	 }


	 public static int disconnect(Connection connection)
	 {
		if (connection !=null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, e);
                    }
		}
                return 1;
	 }

}

