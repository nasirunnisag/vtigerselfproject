package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
Driver dref;
Connection con=null;
	public void connectdb() throws SQLException
	{
		dref=new Driver();
		DriverManager.registerDriver(dref);
		con=DriverManager.getConnection(IConstantUtility.dburl,IConstantUtility.dbusername,IConstantUtility.dbpassword);
	}
	public void closedb() throws SQLException
	{
		con.close();
	}
	public String executequeryverifydataandreturn(String query, int colunmindex,String expData) throws SQLException
	{
		boolean flag=false;
		//execute query
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actdata = result.getString(colunmindex);
		
		//verify the exp data with act data from database
			if(actdata.equals(expData))
			{
				flag=true;
				break;
			}
		}
		//return if expdataand acta data is matchign
		if(flag)
		{
			System.out.println("data verified");
			return expData;
		}
		else 
			{
			System.out.println("data not verified");
			return "";
			}
	}
	
}
