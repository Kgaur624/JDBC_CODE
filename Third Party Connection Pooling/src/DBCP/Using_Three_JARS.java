package DBCP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class Using_Three_JARS {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
	try {
		BasicDataSource  bs = new BasicDataSource(); // 1. create datasource object 
									bs.setDriverClassName("oracle.jdbc.OracleDriver");// 2. set jdbc parameter
									bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
									bs.setUsername("system");
									bs.setPassword("akshusuman");
									con = bs.getConnection();
									st = con.createStatement();
									
									rs = st.executeQuery("select * from employee");
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
