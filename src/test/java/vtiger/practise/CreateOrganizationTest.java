package vtiger.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
public static void main(String[] args) {
	
	//open browser
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	d.get("http://localhost:8888/");
	//login to app
	d.findElement(By.name("user_name")).sendKeys("admin");
	d.findElement(By.name("user_password")).sendKeys("manager");
	d.findElement(By.id("submitButton")).click();
	// navigate to organization
	d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	//click on create organization lookupimg
	d.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//create organization mandatory field
	d.findElement(By.name("accountname")).sendKeys("wipro");
	//save and logout
	d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	System.out.println("orgcreated");
	d.close();
}
}
