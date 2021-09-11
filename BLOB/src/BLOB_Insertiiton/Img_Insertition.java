package BLOB_Insertiiton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;

public class Img_Insertition {

	public static void main(String[] args) {
		
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileInputStream fis = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			pst = con.prepareStatement("insert into employie values(?,?)");
			pst.setInt(1, 104);
			File file = new File("C:\\Users\\JAI_Hanuman\\Documents\\documenr\\doc\\kartik.jpg");
			fis = new FileInputStream(file);
			pst.setBinaryStream(2, fis, file.length());
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				System.out.println("Insertition Successfull");
			}
			else {
				System.out.println("Insertition Failure");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				con.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
	}

}
