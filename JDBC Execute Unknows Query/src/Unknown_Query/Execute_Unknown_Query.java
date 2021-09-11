package Unknown_Query;

import java.sql.*;
import java.io.*;

public class Execute_Unknown_Query {

	public static void main(String[] args) {
	


		try(
				//auto close resources in above version 7
				// class.forName is not required in type 4 driver in case of auto closeable resources
				//Class.forName("oracle.jdbc.OracleDriver");
				
				
				Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
				Statement st = con.createStatement();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				)
		{		
			System.out.println("Enter SQL Query");
			 String query = br.readLine();
			 boolean check = st.execute(query);
			 if(check == true)
			 {
				 //given query is select sql query;
				 // now i want to get ResultSet
				 ResultSet rs = st.getResultSet();
				 System.out.println("Eid\t Ename\t Eaddress");
				 System.out.println("----------------------------------");
				 // we want to fetch the data form resultset 
				 while (rs.next()) {
					 System.out.print(rs.getInt(1)+"\t");
					 System.out.print(rs.getString(2)+"\t");
					 System.out.print(rs.getString(3)+"\n");
				 }
			 }
			 else
			 {
				 // given query is non-select query
				 // it means due to given query manipulation will happen so we need rowCount
				 int rowCount = st.getUpdateCount();
				 System.out.println("no. of Row Count updated "+rowCount);
			 }
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			

	}

}
