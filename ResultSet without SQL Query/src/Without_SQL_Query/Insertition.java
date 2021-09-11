package Without_SQL_Query;

import java.sql.ResultSet; // interface
import java.sql.Statement; // interface
import java.sql.Connection; // interface
import java.sql.DriverManager; //class
import java.io.*;


public class Insertition {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from employie");// first we execute the query
			rs.moveToInsertRow();// second move cursor to the at the end  then, insert the value
			br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Insert the Employee Info");
			System.out.print("Enter Employee Number");
			int eno = Integer.parseInt(br.readLine());
			System.out.print("Enter Employee Name");
			String ename = br.readLine();
			System.out.print("Enter Employee Salary");
			int esalary = Integer.parseInt(br.readLine());
			System.out.print("Enter Employee Address");
			String eaddress = br.readLine();
			
			// insert the value into the resultset object without using sql query.
			rs.updateInt(1,eno);
			rs.updateString(2, ename);
			rs.updateInt(3, esalary);
			rs.updateString(4, eaddress);
			
			rs.insertRow();
			System.out.println("Insertition Successfully");
			
			System.out.println("do you want to insert more column [yes/no]");
			String option = br.readLine();
			if(option.equals("yes")) {
				continue;
			}else	
			{
				break;
			}
		
		}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
