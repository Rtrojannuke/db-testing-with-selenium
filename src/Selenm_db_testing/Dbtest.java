package Selenm_db_testing;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class Dbtest {
	public static void main(String[] args) {
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		
		String dbname = "street";
		
		String username = "root";
		
		String pwrd = "kamaksoftwarelab01#";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+dbname, username, pwrd);
			
			String sqlquery = "Select * from way";
			Statement statement = conn.createStatement();
			ResultSet rslt = statement.executeQuery(sqlquery);
			
		while(rslt.next()) {
			System.out.println(rslt.getString("Name"));
			System.out.println(rslt.getString("HouseNo"));
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
