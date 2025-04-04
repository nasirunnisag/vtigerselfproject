package vtiger.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCUpdatequery {
public static void main(String[] args) throws SQLException {
	Driver dref=new Driver();
	DriverManager.registerDriver(dref);
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
	Statement stmt = con.createStatement();
	String query = "insert into customerinfo(name,id,address) values ('guru',13,'atp')";
	int result = stmt.executeUpdate(query);
	if(result==1)
	{
		System.out.println("data is inserted");
	}
	else
	{
		System.out.println("data is not inserted");
	}
	ResultSet res = stmt.executeQuery("select * from customerinfo;");
	while(res.next())
	{
		System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
	}
	con.close();
}
}
