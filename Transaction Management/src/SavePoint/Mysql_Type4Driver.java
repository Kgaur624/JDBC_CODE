package SavePoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class Mysql_Type4Driver {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			con.setAutoCommit(false);
			st = con.createStatement();
			st.executeUpdate("insert into employie values(196, 'janu', 82000, 'delhi')");
			//Savepoint mark
			Savepoint stt = con.setSavepoint();
			st.executeUpdate("insert into employie values(197, 'jan', 82000, 'delhi')");
			//rollback() when we use rollback() then we comment the releasesavepoint() and vice versa;
			// con.rollback(stt);
			con.releaseSavepoint(stt);
			st.executeUpdate("insert into employie values(198, 'jao', 82000, 'delhi')");
			con.commit();
			System.out.println("Transaction Success");
		}catch(Exception e)
		{
			e.printStackTrace();
			}
		finally {
			try {
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
				}
			
		}
	}

}
