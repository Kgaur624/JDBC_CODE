package WebPage;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.*;


public class JDBC_HTML {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null; // it use convert string data (coming from java) to byteArray
		
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			
			// now i want to prepare HTML Code along with embed the ResultSet data
			String data = ""; // now, declartion of data, later it will store ResultSeultSet value
			data = data + "<html><body><caption align='center'>Friends Info </captions><table align='center' border='1'>";
			data = data + "<tr><th>Eid</th><th>Ename</th><th>Eaddress</th></tr>"; // first row
			// now i want to display the Resultset so we use loop till rs.next()
			while(rs.next())
			{
			//data get from ResultSet Object (+) and append with html code and(=) store in the data variable.
				
				data = data +"<tr>"; // number of rows till read.next()
				data = data +"<td>"+rs.getInt("eid")+"</td>";
				data = data +"<td>"+rs.getString("ename")+"</td>";
				data = data +"<td>"+rs.getString("eaddress")+"</td>";
				data = data +"</tr>";
			}
			// now we close all the html tags.
			data = data+"</table><body></html>";
			
			/* if we want to send data from java file to particular target file (java ----> html)
				we have to use Stream called Output Stream
			*/
			fos = new FileOutputStream("C:/database/18c/friends.html");
			byte[]  b = data.getBytes();
			fos.write(b);    		// it will write the data on the screen 
			
			System.out.print("Transfered");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			fos.close();
			con.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
		

	}

}
