package Selenm_db_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class rtest {
// This is a Script to query db to check correctness of values
	
	public static void main(String[] args) {

		//Setting up the connector/driver
		Connection conn = null;
		
//		Declaring variables that will be needed in the script
		
//      Declaring Databse url
		String url = "jdbc:mysql://localhost:3306/";
		
//		Entering database under test name(dbname)
		String dbname = "street";
		
//		Entering user's username to access the db
		String username = "root";
		
//		Password to the user which will be used to access the db
		String pwrd = "kamaksoftwarelab01#";
		
//		Surrounding with try and catch block because of Exception or errors
		try {
//			Initializing the driver connector
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Adding already intialized variable to driver/connector 
//          NB: Not compulsory that all variables to be used in connection() must be declared before
			conn = DriverManager.getConnection(url+dbname, username, pwrd);
			
//			Declaring variable that is to be checked with value from the db
			String name = "kokozaria";
			
//			Entering the SQL query which is to be executed on the db
			String sqlquery = "SELECT * FROM street.way where Name = 'Kokozaria';";
			
//			Declaring an instance of the SQL Query executor
			Statement statement = conn.createStatement();
			
//			Executing the SQL Query above in the db
			ResultSet rslt = statement.executeQuery(sqlquery);
			
//			Printing out values on the db table	
			rslt.next();
			System.out.println(rslt.getString("Name"));
			System.out.println(rslt.getString("HouseNo"));
			
//			Confirming known details with values on the db table	
			if(rslt.getString("Name").equals(name)) {
				System.out.println("DETAILS ARE WELL PLACED");
			}else if(!rslt.getString("Name").equals(name)) {
				System.out.println("DETAILS PLACED WRONGLY");
				
			}
			

		}catch(Exception e){
//			 printing out errors if any
			System.out.println(e);
			
		}
		finally {
//			Closing the conection to the db
			if(conn != null) {
				conn = null;
			}
			
		}
	}

}
