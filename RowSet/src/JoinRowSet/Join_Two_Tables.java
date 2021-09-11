package JoinRowSet;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Join_Two_Tables {

	public static void main(String[] args) {
		
		CachedRowSet rowset1 = null;
		CachedRowSet rowset2 = null;
		Connection con = null;
		JoinRowSet rowset  = null;
		
		try {	// follow same sequence 
			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			con.setAutoCommit(false);
			RowSetFactory factory = RowSetProvider.newFactory();
			rowset1 = factory.createCachedRowSet();
				rowset1.setCommand("select * from student");
				rowset1.execute(con); 
				
				rowset2 = factory.createCachedRowSet();
				rowset2.setCommand("select * from course");
				rowset2.execute(con);
				
				 rowset = factory.createJoinRowSet();
				rowset.addRowSet(rowset1, "cid");
				rowset.addRowSet(rowset2, "cid");
				
				System.out.println("Sno \t Sname \t Cid \t Cname");
				System.out.println("------------------------");
				while(rowset.next())
				{
					System.out.print(rowset.getString(1)+"\t ");
					System.out.print(rowset.getString(2)+"\t\t ");
					System.out.print(rowset.getString(3)+"\t\t ");
					System.out.print(rowset.getString(4)+"\t ");
					System.out.println();
				}	
						
			}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		finally {
			try {
				
				rowset1.close();
				rowset2.close();
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
