package BLOB_Reterival;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Img_Reteriving {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		InputStream is = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			pst = con.prepareStatement("select * from employie where ENO = ?");
			pst.setInt(1, 104);
			rs = pst.executeQuery();
			rs.next();
			System.out.println("Employee Number :"+rs.getInt(1));
			fos = new FileOutputStream("C:\\Users\\JAI_Hanuman\\Documents\\documenr\\doc\\bkartik.jpg");
			is = rs.getBinaryStream(2);
			int value = is.read();
			while(value!= -1 )
			{
				fos.write(value);
				value = is.read();
			
			}
			System.out.println("Image Retrived");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				is.close();
				con.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
