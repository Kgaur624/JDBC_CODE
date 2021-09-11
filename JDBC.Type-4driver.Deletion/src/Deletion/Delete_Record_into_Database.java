package Deletion;

import java.io.*;
import java.sql.*;
public class Delete_Record_into_Database {

	public static void main(String[] args) {
		
	BufferedReader br = null;
	Connection con = null;
	Statement st = null;
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
		st = con.createStatement();
		br = new BufferedReader (new InputStreamReader(System.in));
		 // user provide the range between he wants to perform deletion
		System.out.print("Enter the range user want to delete");
		int eIdRange = Integer.parseInt(br.readLine());
		
		// to count how many records are delete so we use rowCount
		int rowCount = st.executeUpdate("delete from employee where eid < "+eIdRange);
		System.out.println("deletion perform successffull till : "+rowCount);
		
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
