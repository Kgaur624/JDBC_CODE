package Use_of_ResultSet;


import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Resultseet {

	public static void main(String[] args) {
			
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				
				
				try
				{
				Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
					st = con.createStatement();
					rs =  st.executeQuery("select * from employee");
					System.out.println("Eid\tEname\tEaddress");
					System.out.println("--------------------------------------");
					// when pointer reach till end postion , loop will execute
					while (rs.next())
					{
						System.out.print( rs.getInt/*eid*/(1/*index number*/)+"\t");
						System.out.print(rs.getString/*ename*/(2/*index number*/)+"\t");
						System.out.print(rs.getString/*eaddress*/(3/*index number*/)+"\n");
					}
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						rs.close();
						con.close();
						
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
				
			}


		}

		
		
		
		
		
		