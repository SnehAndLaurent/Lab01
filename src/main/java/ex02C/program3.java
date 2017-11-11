package ex02C;

import java.sql.*;
import org.apache.log4j.*;

public class program3 {
	// JDBC driver name and URL
	protected static Logger log = Logger.getLogger(program3.class);
	public static void main(String args[]) throws Exception {
		Connection con = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(args[1]);
			// STEP 2: Open a connection
			System.out.println("Connection Established");
			con = DriverManager.getConnection(args[0], args[2], args[3]);
			// STEP 3: Execute a query
			System.out.println("Creating statement");
			stmt = con.createStatement();
			String sql;
			sql = args[4];
			boolean isResultSet = stmt.execute(sql);
			while (true) {
			    if (isResultSet) {
			    	try {
			    		System.out.println("Query is a Select statement");
			    		ResultSet resultat= stmt.getResultSet();
			            // Process result set
			    		ResultSetMetaData rsmd = resultat.getMetaData();
						int numberOfColumns = rsmd.getColumnCount();
						for (int i = 1; i <= numberOfColumns; i++) {
							String label = rsmd.getColumnName(i) + " | ";
							System.out.print(label);
						}
						System.out.println();
						while (resultat.next()) {
							String row = "";
							for (int i = 1; i <= numberOfColumns; i++) {
								row += resultat.getString(i) + " | ";
							}
							System.out.print(row);
							System.out.println();
						}
					} catch (SQLException e) {
						System.out.println(e.getMessage());

					}
			    } else {
			    	System.out.println("Query is other than a Select statement");
			    	int rowCount=0;
			    	rowCount = stmt.getUpdateCount();
			    	if (rowCount == 0) {
			            // No more results, exit while loop
			    		System.out.println("No row affected.");
			            break;
			        }else{
			        	System.out.println("Number of rows affected are "+rowCount);
			        	break;
			        }
			    }
				break;
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
}
