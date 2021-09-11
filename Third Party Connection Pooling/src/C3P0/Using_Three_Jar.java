package C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Using_Three_Jar {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
try {
			ComboPooledDataSource  bs = new ComboPooledDataSource(); 
													bs.setDriverClass("oracle.jdbc.OracleDriver");// 2. set jdbc parameter
													bs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
													bs.setUser("system");
													bs.setPassword("akshusuman");
													bs.setMinPoolSize(5);
													bs.setMaxPoolSize(10);
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
