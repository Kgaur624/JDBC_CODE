package Deletion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deletion_Without_Sql_QUERY {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from employie");// first we execute the query
			while(rs.next())
			{
				int Esal = rs.getInt(3); // return the value from resultset object to java program 
				if(Esal <=1000)
				{
					rs.deleteRow();					// update the value into the resultset object without using sql query.
					System.out.println("Employee  salary deleted");
			}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
