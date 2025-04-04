package vtiger.tesng.practise;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Threetestsinsameclass {
	@BeforeSuite
	public void bsconfig()
	{
System.out.println("before suite");
	}
	@BeforeClass
	public void bcconfig()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void bmconfig()
	{
		System.out.println("before method");
	}
	@Test
	public void tc1()
	{
		System.out.println("Test-----> 1");
	}
	@AfterMethod
	public void amconfig()
	{
		System.out.println("after method");
	}
	@BeforeMethod
	public void bmconfig1()
	{
		System.out.println("beforemethod1");
	}
	@Test
	public void tc2()
	{
		System.out.println("Test-----> 2");
	}
	@AfterMethod
	public void amconfig1()
	{
		System.out.println("after method1");
	}
	@BeforeMethod
	public void bmconfig2()
	{
		System.out.println("beforemethod2");
	}
	@Test
	public void tc3()
	{
		Reporter.log("Test-----> 3");
	}
	@AfterMethod
	public void amconfig2()
	{
		Reporter.log("after method2");
	}
}
