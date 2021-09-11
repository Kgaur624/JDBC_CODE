package Proxool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.logicalcobwebs.proxool.ProxoolDataSource;



public class Connection_Pooling {

	public static void main(String[] args) {
	
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
try {
		ProxoolDataSource   bs = new ProxoolDataSource(); // 1. create datasource object 
										bs.setDriver("oracle.jdbc.OracleDriver");// 2. set connection properties
										bs.setDriverUrl("jdbc:oracle:thin:@localhost:1521:xe");
										bs.setUser("system");
										bs.setPassword("akshusuman");
										bs.setMinimumConnectionCount(5);
										bs.setMaximumConnectionCount(10);
										con = bs.getConnection();// get connection
										st = con.createStatement();// get statement
										
										rs = st.executeQuery("select * from employee");// get resultset
										System.out.println("Eno \t Ename \t Eaddress");
										while(rs.next())
										{
											System.out.print(rs.getInt(1)+"\t\t");
											System.out.print(rs.getString(2)+"\t");
											System.out.print(rs.getString(3)+"\t");
											System.out.println();
										}
									}catch(Exception e)
									{
										e.printStackTrace();
									}
		finally {
			try
			{	
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
