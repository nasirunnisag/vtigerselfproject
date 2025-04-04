package vtiger.contactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * @author nasir
 */
public class CreateContactwithorgtest {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=null;
	//create all object utilities
	JavaUtility jutil=new JavaUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
//read all data required for testscript
	String browser1=putil.readDataFrompFile("browser");
	String url1 = putil.readDataFrompFile("url");
	String uname = putil.readDataFrompFile("username");
	String pwd = putil.readDataFrompFile("password");
	String lname = eutil.readDataFromFile("contact", 1, 2)+jutil.getRandomNumber();
	String orgname = eutil.readDataFromFile("Organization", 4, 2)+jutil.getRandomNumber();
	//launch browser
	if(browser1.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser1.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browsername");
	}
	wutil.maxwin(driver);
	wutil.waitforDOMmodel(driver);
	driver.get(url1);
	//login to the app
	driver.findElement(By.name("user_name")).sendKeys(uname);
	driver.findElement(By.name("user_password")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click();
//navigate to organization link
	driver.findElement(By.linkText("Organizations")).click();
	//click on create organization look image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//create oranization with fields and save
	driver.findElement(By.name("accountname")).sendKeys(orgname);

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//validateorg
	String orghead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println(orghead);
	
	if(orghead.contains(orgname))
	{
		System.out.println("orgcreated");
	}
	else
	{
		System.out.println("org not created");
	}
	//navigate to contact
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//click on createcontact
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//create new contact with mandatory information and 
	driver.findElement(By.name("lastname")).sendKeys(lname);
 driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
wutil.switchtowindow(driver, "Accounts");
driver.findElement(By.id("search_txt")).sendKeys(orgname);
driver.findElement(By.name("search")).click();
driver.findElement(By.linkText(orgname)).click();
//switch to parent
wutil.switchtowindow(driver, "Contacts");
//save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//validate contact
	String cheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println(cheader);
	if(cheader.contains(lname))
	{
		System.out.println("contact "+lname+" created");
	}
	else
	{
		System.out.println("contact "+lname+" not created");
	}
	//logout
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wutil.mousehover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();
	Thread.sleep(3000);
	driver.close();
}
}
