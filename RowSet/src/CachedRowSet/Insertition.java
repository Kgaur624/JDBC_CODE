package CachedRowSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Insertition {

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
				
				System.out.println("Eno,\tEname\tEsalary");
				System.out.println("------------------------");
				while(rowset.next())
				{
					System.out.print(rowset.getInt(1)+"\t");
					System.out.print(rowset.getString(2)+"\t");
					System.out.print(rowset.getInt(3)+"\t");
					System.out.println();
				}
				
				
				br = new BufferedReader(new InputStreamReader(System.in));
				rowset.moveToInsertRow(); // cursor will come to the last then insert the data
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				while(true)
				{
					System.out.println("Employee Number");
					int Eno = Integer.parseInt(br.readLine());
					System.out.println("Employee Name");
					String Ename = br.readLine();
					System.out.println("Employee Salary");
					int Esalary = Integer.parseInt(br.readLine());
					System.out.println("Employee Address");
					String Eaddrss = br.readLine();
					
					rowset.updateInt(1, Eno);
					rowset.updateString(2, Ename);
					rowset.updateInt(3, Esalary);
					rowset.updateString(4, Eaddrss);
					rowset.insertRow();
					System.out.print("add column [yes/no]");
					String addColumn = br.readLine();

					if (addColumn.equalsIgnoreCase("yes")) {
						continue;
					} else {
						break;
					}
				}
				// since app execute successfully but data not insert into db table so that
				// what are the changes we perform on db table we have to accept them.
				rowset.moveToCurrentRow();
				rowset.acceptChanges();
				System.out.println("Insertition Success");
			
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
