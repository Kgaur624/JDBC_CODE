package Oracle_Connection_Establishment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class Conncection_Pool_DataSource {

	public static void main(String[] args) {
		PooledConnection pcon = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
		OracleConnectionPoolDataSource dsp = new OracleConnectionPoolDataSource();
			dsp.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			dsp.setUser("system");
			dsp.setPassword("akshusuman");
			pcon = dsp.getPooledConnection();
			con = pcon.getConnection();
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
			try {
				rs.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		

	}

}
