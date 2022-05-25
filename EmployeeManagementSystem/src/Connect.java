import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
	
//	DATABASE CONNECTION 
	Connection con;
	PreparedStatement pstmt;
	ResultSet res;
	
	public Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "123123");
		} catch(ClassNotFoundException ex) {
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("not connected");
		} catch(SQLException ex) {
			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}