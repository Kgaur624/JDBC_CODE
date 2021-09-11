package Get_Column_Dynamically;

import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Dynamic_Columns {

	public static void main(String[] args) {
		// here we want to display columns dynamically along with data

		try (
				//auto close resources in above version 7
				// class.forName is not required in type 4 driver in case of auto closeable resources
				//Class.forName("oracle.jdbc.OracleDriver");
				
				Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
				Statement st = con.createStatement()	;
			
				){
			ResultSet rs = st.executeQuery("select * from employee");
			ResultSetMetaData rd = rs.getMetaData();
			
			// we want to display the column dynamically
			int columnCount = rd.getColumnCount();
			for(int i=1; i<= columnCount; i++)
			{
				String store = rd.getColumnName(i);
				System.out.print(store+"\t");
			}
			System.out.println();
			System.out.println("--------------------------------");
			
			// we want to display the value dynamically
			while(rs.next()) { // read data from resultset object
			for(int i = 1; i<=columnCount; i++)
			{
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
