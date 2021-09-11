/***** Before doing a program first either create or replace the procedure into the sqlplus via cmd *******/
/*	STORED PROCEDURE look like:-
 * 	
 * First create table empvalues(ENO and ESAL)then doing further steps

create or replace procedure getSal(no IN number, sal OUT number)
as
BEGIN 
select ESAL into sal from empval where ENO = no;
END getSal;
 / 
 * 
*/
package StrodeProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import java.sql.CallableStatement;


public class IN_OUT {

	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akshusuman");
			// first ? is represent IN & second ? is represent OUT
			 cst = con.prepareCall("{call getSal(?,?)}");
			 cst.setInt(1, 112);
			 cst.registerOutParameter(2, Types.INTEGER);
			 cst.execute();
			 System.out.println("salary is : "+cst.getInt(2));
			
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
