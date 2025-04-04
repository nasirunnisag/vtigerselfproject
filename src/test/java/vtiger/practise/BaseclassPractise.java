package vtiger.practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseclassPractise {
@BeforeSuite
public void bsconfig()
{
	System.out.println("before suite");
}
@AfterSuite
public void asconfig()
{
	System.out.println("aftersuite");
}
@BeforeClass
public void bcconfig()
{
	System.out.println("beforeclass");
}
@BeforeMethod
public void bmconfig()
{
	System.out.println("before method");
}
@AfterClass
public void acconfig()
{
	System.out.println("ac");
}
@AfterMethod
public void amconfig()
{
	System.out.println("aftermethod");
}
@Test
public void test1()
{
	System.out.println("test-1");
}
}
