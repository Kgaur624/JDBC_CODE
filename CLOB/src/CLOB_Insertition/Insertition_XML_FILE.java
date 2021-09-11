package CLOB_Insertition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.File;

public class Insertition_XML_FILE {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileReader fir = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			pst = con.prepareStatement("insert into webapps values(?,?)");
			pst.setString(1, "tally");
			File file = new File("C:\\Users\\JAI_Hanuman\\Documents\\Custom Office Templates\\Doc1.docx");
			fir = new FileReader(file);
			pst.setCharacterStream(2, fir,file.length());
			int rowCounts = pst.executeUpdate();
			if(rowCounts == 1)
			{
				System.out.println("Insertition Successfulll");
			}
			else {
				System.out.println("Insertitin fail");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

	}

}
