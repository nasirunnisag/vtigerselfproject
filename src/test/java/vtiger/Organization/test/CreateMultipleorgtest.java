package vtiger.Organization.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.Objectrepository.CreatingNewOrganizationPage;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.OrganizationPage;
import vtiger.Objectrepository.OrgnameCreatedPage;

public class CreateMultipleorgtest extends BaseClass {
	//ExcelFileUtility eutil=new ExcelFileUtility();
	@Test(dataProvider="orgData")
	public void createmultipleorgtest(String org,String industry) throws IOException
	{
		String url1 = putil.readDataFrompFile("url");
		String uname = putil.readDataFrompFile("username");
		String pwd = putil.readDataFrompFile("password");
		//String lname = eutil.readDataFromFile("contact", 1, 2)+jutil.getRandomNumber();
		String orgname = org+jutil.getRandomNumber();
		String industryname = eutil.readDataFromFile("Organization", 4, 3);
		wutil.maxwin(d);
		wutil.waitforDOMmodel(d);
		d.get(url1);
		LoginPage lp=new LoginPage(d);
		lp.logintoApp(uname, pwd);
		HomePage hp=new HomePage(d);
		hp.clickonOrganizationlink();
		OrganizationPage op=new OrganizationPage(d);
		op.orglooklink();
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(d);
	    cop.createneworg(orgname, industryname);	
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
	hp.Signoutofapp(d);

	}
	@DataProvider(name="orgData")
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		return eutil.readMultipledatafromxcel("Multipleorg");
	}
}
