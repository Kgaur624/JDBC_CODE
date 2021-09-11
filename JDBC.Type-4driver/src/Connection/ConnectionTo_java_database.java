package Connection;

import java.lang.Class;
import java.sql.Statement;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTo_java_database {
	// write throws Exception
	public static void main(String[] args) throws Exception {

		// Load and Register Driver name
		Class.forName("oracle.jdbc.OracleDriver");

		// Establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akshusuman");

		// Create the Statement
		Statement st = con.createStatement();

		// we want to take dynamic input so we use BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the table name");
		String tablename = br.readLine();

		try {
		// create a table in the database and write a query
		// query = create table employee (
		String query = "create table " + tablename + "("; // ( is becoz we take column name at run time
		// eg1:- create table table_name (column1 data_type(size),column2
		// data_type(size),columnN data_type(size), primary
		// key(column1));----------->primaryKeyCount=0
		// eg2:- create table table_name (column1 data_type(size),column2
		// data_type(size),columnN data_type(size), primary
		// key(column1,columnN));---------->else part

		// primaryKeyColumn take is it primary key or not so for remember that a column
		// is primary key or not
		// at the end of the query i need to attach the primaryKey column at the end of
		// the query for that purpose we create an string variable

		String primaryKeyColumns = "";

		// we have count how many columns are consider as a primary key
		int primaryKeyCount = 0;

		/*
		 * we don't know how many column we require till now so we use infinite loop
		 * when user say yes then go tho next step otherwise break the loop
		 */
		while (true) {
			System.out.print("Column Name");
			String colName = br.readLine();

			System.out.print("Column Data type");
			String colDataType = br.readLine();

			// column size is int type and readLine() give data in form of String so we have
			// to do Conversion

			System.out.print("Column Size");
			int colSize = Integer.parseInt(br.readLine());

			System.out.print("Is Primary key [yes/no]");
			String primaryKeyOption = br.readLine();

			// In case provided column is primary key then we have to add primary key with
			// the column like first column in most of the case
			// if it is not first column then we have to add the column and
			if (primaryKeyOption.equalsIgnoreCase("yes")) {
				if (primaryKeyCount == 0) {
					// if first column is primary key then simply add this
					primaryKeyColumns = primaryKeyColumns + colName;
					primaryKeyCount = primaryKeyCount + 1;
				} else {
					// if second column or any other column is primary key then between first or
					// second column put ","
					primaryKeyColumns = primaryKeyColumns + "," + colName;
				}
			}

			// above query paranthesis is already open
			// +column-name datatype(size));
			query = query + colName + " " + colDataType + "(" + colSize + "),"; // in case we add new column after some
																				// time so we not close this ) here

			// user want to add column in database
			System.out.print("add column [yes/no]");
			String addColumn = br.readLine();

			if (addColumn.equalsIgnoreCase("yes")) {
				continue;
			} else {
				query = query + "primary key(" + primaryKeyColumns + "))";
				break;
			}
		}
		
		System.out.println("Table Created Successfully ");
		st.executeUpdate(query);
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		// we have to close the connection br & con
		
	}
}

/*
 * This error always means that Oracle is expecting another column and or
 * table... it's usually caused by unneeded trailing commas as in your case or
 * by unbalanced parenthesis.
 */
