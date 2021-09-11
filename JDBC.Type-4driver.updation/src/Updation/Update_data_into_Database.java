package Updation;

import java.io.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Update_data_into_Database {

	public static void main(String[] args) {
		
		//Declaration on the outside of try and catch
		BufferedReader br = null;
		Statement st = null;
		Connection con = null;
		try {
			//Defination part
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("employee City");
				String ecity = br.readLine();
				//perfom sql update query
				// whatever address updated DBE assign to rowCount 
				int rowCount = st.executeUpdate("update employee set eaddress = eaddress +"+ecity+"where eid <  143");
				// rowCount print the no. of updation
				System.out.println("Updation Successfull");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
