package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.LoginPage;

public class BaseClass {
	public WebDriver d=null;
	public static WebDriver sDriver;
	
		public JavaUtility jutil=new JavaUtility();
		public PropertyFileUtility putil=new PropertyFileUtility();
		public ExcelFileUtility eutil=new ExcelFileUtility();
		public WebDriverUtility wutil=new WebDriverUtility();
		public DatabaseUtility dbutil=new DatabaseUtility();
		@BeforeSuite
		public void bsconfig() throws SQLException
		{
		dbutil.connectdb();	
		Reporter.log("----------db connecton successfull-----------",true);
		}
		//@Parameters("browser1")
		@BeforeTest
			//@BeforeClass
		public void bcconfig(/*String browser1*/) throws IOException
		{
			 
				String browser1=putil.readDataFrompFile("browser");
				String url1 = putil.readDataFrompFile("url");
			
				if(browser1.equalsIgnoreCase("chrome"))
				{
					///WebDriverManager.chromedriver().setup();
					d=new ChromeDriver();
					Reporter.log(browser1+"------browser launched----------",true);
 
				}
				else if(browser1.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					d=new FirefoxDriver();
					Reporter.log(browser1+"------browser launched----------",true);

				}
				else
				{
					System.out.println("invalid browsername");
				}
			
			wutil.maxwin(d);
			wutil.waitforDOMmodel(d);
			d.get(url1);
			sDriver=d;
			Reporter.log("------browser launched----------",true);
		}
		@BeforeMethod
		public void bmconfig() throws IOException
		{
			String uname = putil.readDataFrompFile("username");
			String pwd = putil.readDataFrompFile("password");
			LoginPage lp=new LoginPage(d);
			lp.logintoApp(uname, pwd);
			Reporter.log("---------login successfully",true);
		}
@AfterMethod
	public void amconfig()
	{
	HomePage hp=new HomePage(d);
	hp.Signoutofapp(d);
	Reporter.log("--------logout successfully------",true);
	}
@AfterTest
//@AfterClass
public void acconfig()
{
	d.close();
	Reporter.log("----------browser closed---------",true);
}
@AfterSuite
public void asconfig() throws SQLException
{
	dbutil.closedb();
	Reporter.log("=====db closed=======",true);
}
	
}
