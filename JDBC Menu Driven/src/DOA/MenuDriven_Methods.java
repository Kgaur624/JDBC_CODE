 package DOA;
// let we assume MenuDrive_Methods to EmployeeMethods
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.sql.Connection;
import java.sql.DriverManager;

import Methods.Methods;
// SECOND
public class MenuDriven_Methods {
	// here we just declare a method
	Connection con ;
	Statement st;
	ResultSet rs;
	String status ="";
	Methods obj;
	
	
	public MenuDriven_Methods () // JDBC setup code
	{
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshusuman");
		st = con.createStatement();
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	// for re-usability method we use search method in insertition updation deletion.
	// so first we implement search method
	
	public String insertition(String eid, String ename, String eaddress)
	{
		try {
			
		Methods obj = search(eid); 
		
		if(obj == null)
		{// employee not existed then we insert the value
			int rowCount = st.executeUpdate("insert into employee values('"+eid+"','"+ename+"','"+eaddress+"')");
			if(rowCount == 1)// means one row will be inserted
			{
				status = "success";
			}
			else
			{
				status = "failure";	
			}
		
		}
		else
		{
			status = "existed";
		}
		}catch (Exception e)
		{
			// during insertition any exception might occur so i am showing 
			status ="failure";
			e.printStackTrace();
		}
		return status;
	}

	public  Methods search(String eid) // search method is always user-defined class type
	{// 1:- we will check employee is existed or not then we perform insertition 
		
		try {
			rs = st.executeQuery("select * from employee where eid = '"+eid+"'"); // eid is an varchar data 
			boolean check = rs.next(); // used to check data is available in resultSet or not.	
			
			// here we perform search operation 
			if(check == true)
			{
				obj = new Methods();
				// if employee is available then  store data  from ResultSet to Methods object
				obj.setEid(rs.getString("eid"));
				obj.setEname(rs.getString("ename"));
				obj.setEaddress(rs.getString("eaddress"));
				
			}
			else
			{
				// employee is un-available the send null value
				obj = null;
			}
			
			
			}catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj ; //retrun the Method class object
	}
	
	public String updation(String eid , String ename , String eaddress) // eg:- ename = ename_new
	{
		try {
			int rowCount = st.executeUpdate("update employee set ename = '"+ename+"', eaddress = '"+eaddress+"' where eid = '"+eid+"'");	
			// above query only one row can be updated
			
			if(rowCount == 1) {
				status = "success";
			}
			else
			{
				status = "failure";
			}
			
		}catch(Exception e)
		{
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}
	public String deletion(String eid)
	{
		try {
			obj = search(eid);
			if(obj == null)
			{
				System.out.println("Employee not existed");
			}
			else
			{
				int rowCount = st.executeUpdate("delete from employee where eid = '"+eid+"'");
				if(rowCount == 1) {
					status = "success";
				}
			
				else {
					status = "failure";
				}
			}
			
		}catch(Exception e)
		{
			status = "failure";
			e.printStackTrace();
		}
	return status;	
	}
}
