package MetaData;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Connection;

public class Database_MetaData {

	public static void main(String[] args) {
	Connection con = null;
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			DatabaseMetaData md = con.getMetaData(); 
			// using some method find the nature of the metadata
			
			System.out.println("databse name  :    "+md.getDatabaseProductName());
			System.out.println("databse version :    "+md.getDatabaseMajorVersion());
			System.out.println("database  :              "+md.getDatabaseMinorVersion());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				
			} catch (Exception e2) {
				
			}
		}

	}

}
