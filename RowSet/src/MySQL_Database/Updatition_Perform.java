package MySQL_Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class Updatition_Perform {

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
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Give the Salary Range");
				int range = Integer.parseInt(br.readLine());
				System.out.println("Give the Pnealty Charge");
				int penalty = Integer.parseInt(br.readLine());
				while(rowset.next())
				{
					int esalary = rowset.getInt(3);
					if(esalary > range)
					{
						int newsal = esalary - penalty;
						rowset.updateInt(3, newsal);
						rowset.updateRow();
					}
				}
				System.out.println("Updation Successfull");
				
				
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
