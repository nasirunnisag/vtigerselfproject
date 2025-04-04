package vtiger.contactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class CreteContactTest {
@Test
	public void tc1() throws IOException
	{
	WebDriver driver=null;
	//create all object utilities
	JavaUtility jutil=new JavaUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	//read necessary data
	String browser1 = putil.readDataFrompFile("browser");
	String uname = putil.readDataFrompFile("username");
	String pwd = putil.readDataFrompFile("password");
	String url1 = putil.readDataFrompFile("url");
	String lname = eutil.readDataFromFile("contact", 1, 2)+jutil.getRandomNumber();
	//launch the browser
	if(browser1.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser1.equalsIgnoreCase("Firefox"))
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
		//login app
	driver.findElement(By.name("user_name")).sendKeys(uname);
	driver.findElement(By.name("user_password")).sendKeys(pwd);
	driver.findElement(By.id("submitButton")).click();
	//navigato contacts
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	//click on createcontact
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//create new contact with mandatory information
	driver.findElement(By.name("lastname")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//logout
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wutil.mousehover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();
}
}
