package CLOB_Reterival;



import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.Reader;
import java.io.FileWriter;


public class CLOB_Retrieving {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileWriter fw = null;
		Reader r = null;
		FileOutputStream fos = null;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
		pst = con.prepareStatement("select * from webapps where APP_NAME = ?");
		pst.setString(1, "tally");
		rs = pst.executeQuery();
		rs.next();
		System.out.println("Application Name       :"+rs.getString(1));
		
		fw = new FileWriter("C:\\Users\\JAI_Hanuman\\Documents\\Custom Office Templates\\Document.docx");
		r = rs.getCharacterStream(2);
		int value = r.read();
		while(value!= -1 )
		{
			fw.write(value);
			value = r.read();
		
		}
		System.out.println("File Retrived");
	
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				r.close();
				fw.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
