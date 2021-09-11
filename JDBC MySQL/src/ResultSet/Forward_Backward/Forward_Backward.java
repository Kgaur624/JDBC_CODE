package ResultSet.Forward_Backward;


import java.sql.ResultSet; // interface
import java.sql.Statement; // interface
import java.sql.Connection; // interface
import java.sql.DriverManager; //class


public class Forward_Backward {

	public static void main(String[] args) {
	
		
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				// refrence class          	method 		 	main-p	sub-p	server	port.no	Db_name	system 	password
			
					
/*******************FORWARD_ResultSet************/
					
					st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery("select * from employie");
				System.out.println("display in the forward direction ");
				System.out.println("Eno,\tEname\tEsalary");
				System.out.println("------------------------");
				while(rs.next())
				{
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getInt(3)+"\t");
					System.out.println();
				}
				
				
				
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				
				
/**************BACKWARD_ResultSet*************/
				
				
				System.out.println("display in the backward direction ");
				System.out.println("Eno,\tEname\tEsalary");
				System.out.println("------------------------");
				while(rs.previous())
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

