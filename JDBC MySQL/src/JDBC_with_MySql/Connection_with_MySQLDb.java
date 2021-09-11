package JDBC_with_MySql;

import java.sql.ResultSet; // interface
import java.sql.Statement; // interface
import java.sql.Connection; // interface
import java.sql.DriverManager; //class

public class Connection_with_MySQLDb {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		// refrence class          	method 		 	main-p	sub-p	server	port.no	Db_name	system 	password
		st = con.createStatement();
		rs = st.executeQuery("select * from employie");
		System.out.println("Eno,\tEname\tEsalary");
		System.out.println("------------------------");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.println();
		}
		
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				rs.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
