package MySQL_Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.sql.rowset.JdbcRowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class Deletion {
		
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
			while(rowset.next())
			{
				int esalary = rowset.getInt(3);
				if(esalary > range)
				{
				
					rowset.deleteRow();
				}
			}
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
