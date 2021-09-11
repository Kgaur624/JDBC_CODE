package CachedRowSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Deletion {

	public static void main(String[] args) {
		CachedRowSet rowset = null;
		BufferedReader br = null;
		Connection con = null;
		
		try {	// follow same sequence 
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			con.setAutoCommit(false);
			RowSetFactory factory = RowSetProvider.newFactory();
			rowset = factory.createCachedRowSet();
				rowset.setCommand("select * from employie");
				rowset.execute(con); // in that case when we perfomr execute(con) then have to perform con.
				
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Give the Salary Range");
				int range = Integer.parseInt(br.readLine());
				while(rowset.next())
				{
					int esalary = rowset.getInt(3);
					if(esalary < range)
					{
						rowset.deleteRow();
					}
				}
				rowset.moveToCurrentRow();
				rowset.acceptChanges();
				System.out.println("Deletion Successfull");
				
				}
			catch(Exception e)
			{
				e.printStackTrace();
				e.getMessage();
			}
			finally {
				try {
					br.close();
					rowset.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					e.getMessage();
				}
			}

	}

}
