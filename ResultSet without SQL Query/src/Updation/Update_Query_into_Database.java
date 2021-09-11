package Updation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Query_into_Database {

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
				if(Esal > 5000)
				{
					Esal = Esal +5000;
					rs.updateInt(3, Esal);
					rs.updateRow();
					// update the value into the resultset object without using sql query.
					System.out.println("Employee "+rs.getInt(1)+"   salary updated");
			}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			con.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
