package Selenm_db_testing;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class inputting {
	public static void main(String[] args) {
		
		
//		String name = "Kokozaria";
//		int Houseno = 23;
		
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "street";
		String username = "root";
		String pwrd = "kamaksoftwarelab01#";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+dbname, username, pwrd);
			
			String sqlquery = "INSERT INTO `street`.`way` (`Name`, `HouseNo`) VALUES ('kokozaria', '21');";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlquery);
			String sqlquery1 = "Select * from way Where Name ";
			ResultSet rslt = statement.executeQuery(sqlquery1);
			
			rslt.next();
			System.out.println(rslt.getString("Name"));
			System.out.println(rslt.getString("HouseNo"));
			

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
