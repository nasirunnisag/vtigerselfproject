package vtiger.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCExecuteQuery {
public static void main(String[] args) throws SQLException {
	Driver dref=new Driver();
	//step1:register thedriver
	DriverManager.registerDriver(dref); 
	
	//step2:get the connection
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root"); 
	//step3:create statement
	Statement s = con.createStatement();
	//step 4:executequery
	ResultSet res = s.executeQuery("select * from customerinfo;");
	 
	//step5: close db
	while(res.next())
	{
		System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
	}
	con.close();
}
}
