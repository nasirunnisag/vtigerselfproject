package vtiger.Organization.test;


import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.Objectrepository.CreatingNewOrganizationPage;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.OrganizationPage;
import vtiger.Objectrepository.OrgnameCreatedPage;
@Listeners(vtiger.GenericUtility.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {
@Test
public void tc1() throws EncryptedDocumentException, IOException
{
	

	String orgname = eutil.readDataFromFile("Organization", 4, 2)+jutil.getRandomNumber();
	HomePage hp=new HomePage(d);
	hp.clickonOrganizationlink();
	//click on create organization
	OrganizationPage op=new OrganizationPage(d);
	op.orglooklink();
	//Assert.fail();

	//create organization with mandatory fields
	CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(d);
	cnop.orgnametb(orgname);
	cnop.save();
	OrgnameCreatedPage ocp=new OrgnameCreatedPage(d);
	String orgheader=ocp.getOrgheader();
	System.out.println(orgheader);
	if(orgheader.contains(orgname))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}	
}

}

