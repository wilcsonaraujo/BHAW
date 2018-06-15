package tis.bhaw.DataAccessObject;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.management.RuntimeErrorException;


 

public class ConnectionFactory {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaw",
	        		"root" , "sa2gr0ad1o8");	
		}catch (Error e) {
			throw new RuntimeErrorException(e);
		}
	}
	
	
}
