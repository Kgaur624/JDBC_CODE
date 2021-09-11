package WebRowSet;

import java.io.FileOutputStream;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class Database_To_XMLfile {

	public static void main(String[] args) {
		
		WebRowSet rowset = null;
		FileOutputStream fos = null;
		try
		{RowSetFactory factory = RowSetProvider.newFactory();
		rowset = factory.createWebRowSet();
		rowset.setUrl("jdbc:mysql://localhost:3306/employee");
		rowset.setUsername("root");
		rowset.setPassword("root");
		rowset.setCommand("select * from employie");
		rowset.execute();
			
		fos = new FileOutputStream("C:\\database\\rowset\\webrowset.xml");
		rowset.writeXml(fos);
		System.out.println("Data Retrived from database to Xml file");
		}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		try {
			rowset.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		
	}

}
