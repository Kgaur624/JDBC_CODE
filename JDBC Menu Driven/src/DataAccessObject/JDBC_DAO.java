package DataAccessObject;

import java.io.*;

import DOA.MenuDriven_Methods;
import Methods.Methods;


public class JDBC_DAO {
// FIRST
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MenuDriven_Methods  menuDriven = new MenuDriven_Methods();
	while (true) {
		System.out.println("1:- Add Employee");
		System.out.println("2:- Search Employee");
		System.out.println("3:- Update Employee");
		System.out.println("4:- Delete Employee");
		System.out.println("5:- Exit");
		System.out.println("Choose Your Options");
		
		int option = Integer.parseInt(br.readLine());
		String status ="";
		String eid = "", ename="", eaddress=""; // declaring here so we use multiple times in our program
		Methods obj = null;
		switch(option)
		{
/****************************************************************************************************/
		case 1:
			System.out.println("Enter the Employee Id:-");
			eid = br.readLine();
			System.out.println("Enter the Employee Name:-");
			ename = br.readLine();
			System.out.println("Enter the Employee Address:-");
			eaddress = br.readLine();
			
			// status is used to display the status of the data
			 status = menuDriven.insertition(eid, ename, eaddress);
			// status have three value :- success existed failure
			if(status.equals("success")) {
				System.out.println("Insertition Successfully");
			}
			
			if(status.equals("existed")) {
				System.out.println(" Already Existed");
			}

			if(status.equals("failure")) {
				System.out.println("Insertition Failed");
			}
			System.out.println();
			break;
/*----------------------------------------------------------------------------------------------------------------------------------------------------*/		
		case 2:
				System.out.println("Provide me Employee Id");
				eid = br.readLine();
				//now we have to call SEARCH method present in MenuDriven {provide search method}  so first we created an object of Methods {give access to access the search method} here
				// we create object of Methods class to access getter and setter method
				 obj = menuDriven.search(eid);
				if (obj == null) {
					System.out.println("Employee not Existed");
					}
				else {
					System.out.println("Employee Info:");
					System.out.println("-----------------------");
					System.out.println("Eid\t Ename\t Eaddress");
					System.out.print(obj.getEid()+"\t  "+obj.getEname()+"\t\t"+obj.getEaddress());
				
				}
				System.out.println();
				
				break;
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/				
		case 3:
			System.out.println("Provide me Employee Id");
			eid = br.readLine();
			 obj = menuDriven.search(eid);
				if (obj == null) {
					System.out.println("Employee not Existed");
					}
				else
				{
					// Employee Existed then we want to display old data and take new data from user
					System.out.println("Your old name is :--   "+obj.getEname());
					System.out.println("Enter your  new name");
					String ename_new = br.readLine();
					// In case Employee dose not want to update his data then ,(user can simply enter without entering data ) so user return null or empty_string
					/*********  if dynamic input we get as null value or empty_string then automatically will use the same old data as new data *********/
					if(ename_new == null || ename_new.equals(" ")) {
							ename_new = obj.getEname();
					}
//					else
//					{
//						System.out.println("your new name is :-  "+ename_new);
//					}
					
					System.out.println("Your old address  is :--   "+obj.getEaddress());
					System.out.println("Enter your new address");
					String eaddress_new = br.readLine();
					if(eaddress_new == null || eaddress_new.equals(" ")) {
						eaddress_new = obj.getEaddress();
						
				}
					status = menuDriven.updation(eid, ename_new, eaddress_new);
					
					if(status.equals("success"))
					{
						System.out.println("Updation Successfull");
					}
					else
					{
						System.out.println("Updation faliure");
					}
				
				}
			break;
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/				
		case 4:
			System.out.println("Provide me Employee Id");
			eid = br.readLine();
			 status = menuDriven.deletion(eid);
			 if(status.equals("success")) {
				 System.out.println("Deletion Successfull");
			 }
			 if(status.equals("failure")) {
				 System.out.println("Deletion Failure");
			 }
			 if(status.equals("notexisted")) {
				 System.out.println("Employee Id not Found");
			 }
			break;
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/				

		case 5:
			System.out.println("*******Thank you for Using*******");
			System.exit(0);
			break;
			default:
				System.out.println("Enter your choice from 1 to 5");
				break;
		}
	}
			
	}

}
