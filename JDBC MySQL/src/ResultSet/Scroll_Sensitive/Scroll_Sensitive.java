package ResultSet.Scroll_Sensitive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class Scroll_Sensitive {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
		/*	Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
		// refrence class          	method 		 	main-p	sub-p	server	port.no	Db_name	system 	password
		
	*/		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			// refrence class          	method 		 	main-p	sub-p	server	port.no	Db_name	system 	password
					
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = st.executeQuery("select * from employie");
		System.out.println("display in the before updation ");
		System.out.println("Eid\tEsalary");
		System.out.println("------------------------");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println();
		}
	/*	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter SQL Query");
		 String query = br.readLine();
		 st.executeUpdate(query);
		 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter SQL Query");
			 String query1 = br1.readLine();
			 st.executeUpdate(query1);
			 
			 
*************** when we perform update and commit query dynamically then , it will show the exception (operation does not allowed after resultset closed)***********
	*/		 
	
		/* when we pause the program so we have to perfrom update query using mysql command line 5.7 clinet and then click on enter  */ 
		System.out.println("Perfrom Updation");
		System.in.read();
		rs.beforeFirst();
		
		System.out.println("display in the after updation ");
		System.out.println("Eid\tEsalary");
		System.out.println("------------------------");
		
		while(rs.next())
		{
			rs.refreshRow();
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println();
		}
			}catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {
					try {
						
						con.close();
						
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			} 
		
		}


