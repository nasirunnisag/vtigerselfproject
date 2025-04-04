package vtiger.Organization.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.Objectrepository.CreatingNewOrganizationPage;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.OrganizationPage;
import vtiger.Objectrepository.OrgnameCreatedPage;

public class CreateorgwithIndustry extends 	BaseClass  
{
@Test
	public void creorgwithIndustry() throws IOException
	{

		//String lname = eutil.readDataFromFile("contact", 1, 2)+jutil.getRandomNumber();
		String orgname = eutil.readDataFromFile("Organization", 4, 2)+jutil.getRandomNumber();
		String industryname = eutil.readDataFromFile("Organization", 4, 3);

		HomePage hp=new HomePage(d);
		hp.clickonOrganizationlink();
		OrganizationPage op=new OrganizationPage(d);
		op.orglooklink();
	//	Assert.fail();
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(d);
		cop.createneworg(orgname, industryname);
		OrgnameCreatedPage ocp=new OrgnameCreatedPage(d);
		String orgheader=ocp.getOrgheader();
		System.out.println(orgheader);
		//Assert.assertEquals(orgheader.contains(orgname), true);
		Assert.assertTrue(orgheader.contains(orgname));
		/*if(orgheader.contains(orgname))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
*/
	}
}
