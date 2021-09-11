package MySQL_Conncection_Establishment;
			 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DataSourceObject {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			/*****/ /* this datasource is able to manage conncetion object or pool object */ 
			// we are not going to create and close the connection every time 
			// we just create some fixed number of connection into pool object as we need.
			// we just call and use them.
			MysqlDataSource mds = new MysqlDataSource();
			mds.setURL("jdbc:mysql://localhost:3306/employee");
			mds.setUser("root");
			mds.setPassword("root");
			con = mds.getConnection();
			st = con.createStatement();
			/********/
			rs = st.executeQuery("select * from employie");
			System.out.println("Eno \t Ename \t Esalary \t  Eaddress");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t\t");
				System.out.print(rs.getString(4)+"\t");
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
