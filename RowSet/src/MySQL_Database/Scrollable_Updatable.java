package MySQL_Database;
/********** Highere version of MySQL is not support set Rowset so use 5 version*****/
import  com.sun.rowset.JdbcRowSetImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sql.rowset.JdbcRowSet;

public class Scrollable_Updatable {

	public static void main(String[] args) {
		
		JdbcRowSet rowset = null;
		BufferedReader br = null;
		
		try {	
				rowset = new JdbcRowSetImpl();
				rowset.setUrl("jdbc:mysql://localhost:3306/employee");
				rowset.setUsername("root");
				rowset.setPassword("root");
				rowset.setCommand("select * from employie");
				rowset.execute();
				
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
				rowset.moveToInsertRow();
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
