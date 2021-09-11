package MySQL_Conncection_Establishment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;


public class Conncection_Pool_DataSource {
	public static void main(String[] args) {
				PooledConnection mcon = null;
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				
				try {
					
				MysqlConnectionPoolDataSource mds = new MysqlConnectionPoolDataSource();
					mds.setURL("jdbc:mysql://localhost:3306/employee");
					mds.setUser("root");
					mds.setPassword("root");
					mcon = mds.getPooledConnection();
					con = mds.getConnection();
					st = con.createStatement();
					
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


