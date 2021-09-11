package Oracle_Connection_Establishment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;


public class DataSourceObject {

	public static void main(String[] args) {
		
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			OracleDataSource ds = new OracleDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("system");
			ds.setPassword("akshusuman");
			con = ds.getConnection();
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
