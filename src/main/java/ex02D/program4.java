package ex02D;
import java.sql.*;
import java.lang.String.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.*;
 
public class program4 {
	protected static Logger log = Logger.getLogger(program4.class);
	private static final String url = "jdbc:mysql://localhost:3306/sakila";
	private static final String user = "root";
	private static final String pass = "root";

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		/* 1. Load JDBC Driver. */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* 2. Connect to bdd */
		try {
			/* 
			 *2.1 Connect to database through getConnection a static method of Driver Manager 
			 */
			dbConnection = DriverManager.getConnection(url, user, pass);
			/* Requests to bdd will be here */
			System.out.println();
			System.out.println("Database Connection Established");
			return dbConnection;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dbConnection;
	}
	
	public static void main(String[] args)throws Exception {
		try {
			/*
			* Calling function
			*/
			displayTable(getDBConnection());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
 
	public static void displayTable(Connection dbConnection)throws SQLException {
		try {
			DatabaseMetaData dbMetaData = dbConnection.getMetaData();
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String[] types = null;
			String schema = null;
			String columnNamePattern = null;
			/*
			*Method for deleting script file
			*/
			deleteFile();
			
			/*
			*Fetching all information regarding tables
			*/
			ResultSet rs = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types );
			String tableName ="";
			System.out.println("List all the tables in database with it's information");
			while(rs.next()) {
				
				String tableType = rs.getString("TABLE_TYPE");
				tableName = rs.getString(3);
				System.out.println("-------------------------------------");
				/*
				* instruction checks type whether it's a view or table
				*/
				String sqlInstructions = (tableType.equals("VIEW")) ? "CREATE VIEW "+tableName+"\n"+ "As \n" : "CREATE TABLE "+tableName+" ( \n";
				ResultSet result = dbMetaData.getColumns(catalog, schemaPattern,  tableName, columnNamePattern);
				if (tableType.equals("VIEW")) { 
					/*
					* Displaying the views
					*/
					sqlInstructions += "SELECT ";
					int i = 0;
					while(result.next()){
						String ColumnName = result.getString(4);
						sqlInstructions += (i == 0)? ColumnName : ", " + ColumnName ;
						i++;
					}
					//System.out.println(sqlInstructions);
					sqlInstructions += "\n";
				}else {
					/*
					* Displaying the table structure containing columnName,Datatype,Nullvalue
					*/
					while(result.next()){
						String columnName = result.getString(4);
						String datatype = result.getString("DATA_TYPE");
						String typeName = result.getString("TYPE_NAME");
						String columnsize = result.getString("COLUMN_SIZE");
						String typeNameNumbers = (columnsize != null)? "(" + columnsize + ")" : "";
						String isNullable = result.getString("IS_NULLABLE");
						String isNullableBool = (isNullable == "YES") ? "NULL" : "NOT NULL";
						sqlInstructions += columnName + " " + typeName + typeNameNumbers + " " + isNullableBool + ", \n";
					}
					/*
					* Create resultset for primary, foreign and unique key
					*/
					ResultSet PK = dbMetaData.getPrimaryKeys(catalog, schema, tableName);
					ResultSet FK = dbMetaData.getImportedKeys(catalog, schema, tableName);
					ResultSet UK = dbMetaData.getIndexInfo(catalog, schema,tableName, true, true);
					
					/*
					* Fetching primary key
					*/
					int i = 0; 
					sqlInstructions += "PRIMARY KEY (";
					while(PK.next()){
						String ColumnName = PK.getString(4);
						sqlInstructions += (i == 0)? ColumnName : ", " + ColumnName;
						i++;
					}					
					sqlInstructions += "), \n";
					
					/*
					* Fetching Unique Key
					*/
					int j = 0; 
					sqlInstructions += "UNIQUE (";
					
					while(UK.next()){
						String ColumnName = UK.getString("COLUMN_NAME");
						sqlInstructions += (j == 0)? ColumnName : ", " + ColumnName;
						j++;
					}
					sqlInstructions += "), \n";
					
					/*
					* Fetching Foreign Key
					*/
					int k = 0; 
					while(FK.next()){
						String ColumnName = "FOREIGN KEY ("+ FK.getString("FKCOLUMN_NAME") + ") REFERENCES " + FK.getString("PKTABLE_NAME") + "(" + FK.getString("PKCOLUMN_NAME") + ")";
					    sqlInstructions += (k == 0)? ColumnName : ", \n" + ColumnName;
						k++;
					}
					sqlInstructions += "\n); \n";
				}
				writeFile(sqlInstructions);
				System.out.println(sqlInstructions);
				System.out.println();
			}
					/*while(PK.next()){
						String columnNamep = resultset.getString(4);
						System.out.println();
						System.out.println("PRIMARY KEY present in "+tableName+" is "+columnNamep);
						ResultSet FK = dbMetaData.getImportedKeys(catalog, schema, tableName);
						System.out.println();
						System.out.println("FOREIGN KEYS present in "+tableName+" are:");
						while(FK.next()){
							System.out.println(FK.getString("FKCOLUMN_NAME"));
						}
						ResultSet UK = dbMetaData.getIndexInfo(catalog, schema,tableName, true, true);
						System.out.println();
						System.out.println("UNIQUE KEYS present in " + tableName+ " are:");
						while (UK.next()) {
							System.out.println(UK.getString("COLUMN_NAME"));
						}
					}*/
					//System.out.println("-------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
 
	}
	/*
	* Method to write in a file
	*/
	public static void writeFile(String sqlInstructions)
    {
        try
        {
            File archive = new File("SQLscript.sql");
            FileWriter fw = new FileWriter(archive.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(sqlInstructions);
            
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
	/*
	* Method to delete a file
	*/
	public static void deleteFile()
    {
		try {
        File file = new File("SQLscript.sql");
		if (file.exists()) {
		    file.delete();
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}