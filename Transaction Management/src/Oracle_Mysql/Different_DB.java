/**************************AUTOMICITY**********************/
package Oracle_Mysql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Different_DB {

	public static void main(String[] args) {
		// every thing we need Double
		
		Connection oracleCon = null;
		Connection mysqlCon = null;
		
		PreparedStatement oracleSt = null;
		PreparedStatement mysqlSt = null;
		
		BufferedReader br = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			
			oracleCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			mysqlCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			
			oracleCon.setAutoCommit(false);
			mysqlCon.setAutoCommit(false);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Debite Account Holder Name");
			String fromacc = br.readLine();
			System.out.println("Credit Account Holder Name");
			String toacc = br.readLine();
			System.out.println("Transfer Amount");
			int transferamount = Integer.parseInt(br.readLine());
			
// REMEMBER:- using preparedstatement we have to write ? rather then provide dire value 
			oracleSt = oracleCon.prepareStatement("update account set BALANCE = BALANCE - ? where ACC_NAME = ?");				
			oracleSt.setInt(1, transferamount);
			oracleSt.setString(2, fromacc);
			int rowCount1 = oracleSt.executeUpdate();
			
			mysqlSt = mysqlCon.prepareStatement("update account set BALANCE = BALANCE + ? where ACC_NAME = ?");				
			mysqlSt.setInt(1, transferamount);
			mysqlSt.setString(2, toacc);
			int rowCount2 = mysqlSt.executeUpdate();
			if(rowCount1 == 1 && rowCount2 == 1) {
				oracleCon.commit();
				mysqlCon.commit();
				System.out.println("Transaction Successfull");
			}
			else
			{
				oracleCon.rollback();
				mysqlCon.rollback();
				System.out.println("Transaction Failure");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
			oracleCon.close();
			mysqlCon.close();
			}catch(Exception e)
			{e.printStackTrace();
				
			}
		}
		

	}

}
