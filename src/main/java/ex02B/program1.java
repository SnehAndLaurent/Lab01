package ex02B;
import org.apache.log4j.*;
import java.sql.*;

public class program1 {
	protected static Logger log = Logger.getLogger(program1.class);
	// JDBC driver name and URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Database Credentials
	static final String user = "root";
	static final String pass = "root";

	public static void main(String args[]) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 2: Open a connection
			System.out.println("Connection Established");
			con = DriverManager.getConnection(DB_URL, user, pass);
			// STEP 3: Execute a query
			System.out.println("Creating statement");
			stmt = con.createStatement();
			String sql;
			sql = "SELECT last_name from actor";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String lastname = rs.getString("last_name");
				// Display values
				System.out.println(" LastName: " + lastname);
			}
			// STEP 5: Clean-up environment
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			// Handle errors for JDBC
			ex.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if ((stmt != null) && (con != null)) {
					stmt.close();
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
