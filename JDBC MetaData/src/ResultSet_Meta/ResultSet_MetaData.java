package ResultSet_Meta;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ResultSet_MetaData {

	public static void main(String[] args) {
	
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			
			
			
			ResultSetMetaData rd = rs.getMetaData();
			int count = rd.getColumnCount();
			for(int i = 1;i<= count;i++)
			{
			System.out.print("size of column :    "+rd.getColumnDisplaySize(i));
			System.out.print("name of column :  "+rd.getColumnName(i));
			System.out.print("type of column :     "+ rd.getColumnType(i));
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
