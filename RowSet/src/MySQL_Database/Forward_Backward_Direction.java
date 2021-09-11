package MySQL_Database;

// here we have to explicitly put the com.sun.rowset jar file 
import  com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;

public class Forward_Backward_Direction {

	public static void main(String[] args) {
		
		JdbcRowSet rowset = null;
			
		try {	
				rowset = new JdbcRowSetImpl();
				rowset.setUrl("jdbc:mysql://localhost:3306/employee");
				rowset.setUsername("root");
				rowset.setPassword("root");
				rowset.setCommand("select * from employie");
				rowset.execute();
				
				System.out.println("display in the forward direction ");
				System.out.println("Eno,\tEname\tEsalary");
				System.out.println("------------------------");
				while(rowset.next())
				{
					System.out.print(rowset.getInt(1)+"\t");
					System.out.print(rowset.getString(2)+"\t");
					System.out.print(rowset.getInt(3)+"\t");
					System.out.println();
				}
				
				
				System.out.println("display in the backward direction ");
				System.out.println("Eno,\tEname\tEsalary");
				System.out.println("------------------------");
				while(rowset.previous())
				{
					System.out.print(rowset.getInt(1)+"\t");
					System.out.print(rowset.getString(2)+"\t");
					System.out.print(rowset.getInt(3)+"\t");
					System.out.println();
				}
				
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
