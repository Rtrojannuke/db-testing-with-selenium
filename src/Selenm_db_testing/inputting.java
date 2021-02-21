package Selenm_db_testing;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class inputting {
	
//This is a code to enter values into the db
	public static void main(String[] args) {
		
//      Setting up the connector/driver
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
			
//			Entering the SQL query which is to be executed on the db
			String sqlquery = "INSERT INTO `street`.`way` (`Name`, `HouseNo`) VALUES ('kozaria', '29');";
			
//			Declaring an instance of the SQL Query executor
			Statement statement = conn.createStatement();
			
//			Executing the SQL Query above in the db 
			statement.executeUpdate(sqlquery);
			
			

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
