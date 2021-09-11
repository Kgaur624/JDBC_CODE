package Function;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;


/*
 * 										function variable								
 * 										name		  name	
create or replace function getSUM(salRange IN number) return NUMBER
as
sumRESULT  number;
BEGIN
select sum(ESAL) into sumRESULT from empval where ESAL > salRange;
return sumRESULT;
END getSUM;
/ 
*/
// sum() :- is an aggregate function of SQL
public class Example_Program {

	public static void main(String[] args) {	
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
	/***********************************IMPORTANT-Concept************************************/
			
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akshusuman");
// 												1						   2
			 cst = con.prepareCall("{? = call getSUM(?)}");	
//				first ? is :- returning and OUT type;	   call is an predefine function;		 getSUM(?)--> ? is IN  type 	
// 					1 & 2 are the (index number) of the ?
			 cst.setInt(2, 12000);	// setInt() means set the value inside the given function called getSUM();
// like:- 2 indicate ? that present inside the getSUM(?) it means salRange; & 12000 is the actual value of salRange, we want to put into the salRange;								 
//																										(inside database   )			
			 // if we have OUT type parameter then we have to register the OUT type parameter
			 cst.registerOutParameter(1, Types.INTEGER);
			
			 cst.execute();
			 System.out.println("SUM OF THE  SALARY:- "+cst.getInt(1));
			 //  cst.getInt(1) :- 1 indicate firtst ? , that getSUM function want to return ;

			 		
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
