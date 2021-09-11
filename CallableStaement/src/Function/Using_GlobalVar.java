/***** Before doing a program first either create or replace the procedure into the sqlplus via cmd *******/
/*	STORED FUNCTION look like:-
 * 	
 * First create table empvalues(ENO and ESAL)then doing further steps

create or replace function getAVG(no1 IN number, no2 IN number, no3 IN number, no4 IN number, no5 IN number) return INTEGER
as
row1 number;
row2 number;
row3 number;
row4 number;
row5 number;
BEGIN 
select ESAL into row1 from empval where ENO = no1;
select ESAL into row2 from empval where ENO = no2;
select ESAL into row3 from empval where ENO = no3;
select ESAL into row4 from empval where ENO = no4;
select ESAL into row5 from empval where ENO = no5;
return (row1+row2+row3+row4+row5)/5;
END getAVG;
 / 
 * 
*/
package Function;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Types;


public class Using_GlobalVar {

	public static void main(String[] args) {
	
		Connection con = null;
		CallableStatement cst = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "akshusuman");
			//	first ? is :- returning and OUT type, 	   call is an predefine function, getAVG(?,?)--> IN  type 
			 cst = con.prepareCall("{? = call getAVG(?,?,?,?,?)}");	
			 cst.setInt(2, 113);
			 cst.setInt(3, 111); // 2 & 3 is the number of row in database table 
			 cst.setInt(4, 114);
			 cst.setInt(5, 101);
			 cst.setInt(6, 112);
			 // if we have OUT type parameter then we have to register the OUT type parameter
			 cst.registerOutParameter(1, Types.INTEGER);
			 cst.execute();
			 System.out.println("AVERAGE SALARY:- "+cst.getInt(1));

			 			 
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

/***********************************IMPORTANT************************************/

/*
 * IF():-
 * in case n number of parameter as an IN type then
 * we need to understand as we have the developer,
 * (we know how many parameter are availabe) & which paramter are which type
 * ELSE:-
 * if the function are provided by Database Vendors , that mannual is available
 * ( what is the function and which paramter is coming like which is IN type or OUT type )
 * everything is in mannual if we get the mannual then ,
 *see that, and provide the  implementation part 
  */


























