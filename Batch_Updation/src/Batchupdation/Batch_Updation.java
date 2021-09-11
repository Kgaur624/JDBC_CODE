package Batchupdation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Batch_Updation {

	public static void main(String[] args) {
		
		
		Statement st = null;
		Connection con = null;
		try {
			//Defination part
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			st = con.createStatement();
			st.addBatch("insert into employie values(484, 'jai', 2000, 'delhi')");
			st.addBatch("update employie set Esalary = Esalary + 5000 where Esalary <19000");
			st.addBatch("delete from employie where Esalary > 19000");
			int[] rowCount = st.executeBatch();
			for(int rowcounts : rowCount)
			{
				System.out.println(rowcounts);
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
