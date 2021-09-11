/**************************AUTOMICITY**********************/
package Same_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Both_The_Account {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
/*step1*/ con.setAutoCommit(false);
			st = con.createStatement();
			// first we debit amount from mouna account 
			int rowCount1 = st.executeUpdate("update account set BALANCE = BALANCE - 25000 where ACC_NAME = 'mouna'");
			// second we credit amount into ashwita account
			int rowCount2 = st.executeUpdate("update account set BALANCE = BALANCE + 25000 where ACC_NAME = 'ashwita'");
			if (rowCount1 == 1 && rowCount2 == 1)
			{
				System.out.println("amount transfer successfull");
			}
			else {
				System.out.println("amount transfer failed");
			}
			// if we not write commit() then it will not update data into the table 
/*step2*/			con.commit();
		}
		catch(Exception e)
		{
			try {// rollback() also generate an Exception 
				con.rollback();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			}
		finally {
			try {
				con.close();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();	
				}

		}

	}

}
