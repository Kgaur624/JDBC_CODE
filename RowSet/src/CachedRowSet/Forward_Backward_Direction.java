package CachedRowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.JdbcRowSetImpl;

public class Forward_Backward_Direction {

	public static void main(String[] args) {
		
		CachedRowSet rowset = null;
		
		try {	
			RowSetFactory factory = RowSetProvider.newFactory();
			rowset = factory.createCachedRowSet();
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
