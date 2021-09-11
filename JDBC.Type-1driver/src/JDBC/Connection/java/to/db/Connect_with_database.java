package JDBC.Connection.java.to.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect_with_database {

	public static void main(String[] args) throws Exception {
		

// Establish the Connection between java application and Database
																	//data source name  username password
Connection con = DriverManager.getConnection("jdbc:odbc:kartik","system","akshusuman");

// Create Statement
Statement st = con.createStatement();

// Write and Execute SQL query
st.executeUpdate("create table employee ( Eno number(2) primary key, Ename varchar2(10), Esalary float(5), Eaddress varchar2(10))");
System.out.println("employee table created successfull");

// Close the connection
st.close();
con.close();

	}

}

// this program will not execute due to our database configure is 18c and this prog type-1 driver need oracle 11 