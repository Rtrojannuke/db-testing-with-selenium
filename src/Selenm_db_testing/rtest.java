package Selenm_db_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class rtest {
// This is a Script to query db to check correctness of values
	
	public static void main(String[] args) {

		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "street";
		String username = "root";
		String pwrd = "kamaksoftwarelab01#";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+dbname, username, pwrd);
			String name = "kokozaria";
			String sqlquery = "SELECT * FROM street.way where Name = 'Kokozaria';";
			Statement statement = conn.createStatement();
			ResultSet rslt = statement.executeQuery(sqlquery);
			
			rslt.next();
			System.out.println(rslt.getString("Name"));
			System.out.println(rslt.getString("HouseNo"));
			
			if(rslt.getString("Name").equals(name)) {
				System.out.println("DETAILS ARE WELL PLACED");
			}else if(!rslt.getString("Name").equals(name)) {
				System.out.println("DETAILS PLACED WRONGLY");
				
			}
			

		}catch(Exception e){
			System.out.println(e);
			
		}
		finally {
			if(conn != null) {
				conn = null;
			}
			
		}
	}

}
