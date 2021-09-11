package WebRowSet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class XML_To_Database {

	public static void main(String[] args) {
		
		WebRowSet rowset = null;
		FileReader fis = null;
		Connection con = null;
		try
		{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				con.setAutoCommit(false);
				RowSetFactory factory = RowSetProvider.newFactory();
				rowset = factory.createWebRowSet();
				rowset.setCommand("select * from employie");
				rowset.execute(con);
				// here we read the data into file.
				fis = new FileReader("C:\\database\\rowset\\webrowset.xml");
				rowset.readXml(fis);
				rowset.moveToCurrentRow();
				rowset.acceptChanges();
				System.out.println("Data Inserted into database from  Xml file");
		}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		try {
			fis.close();
			rowset.close();
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
		}
	}

		
	}

}
