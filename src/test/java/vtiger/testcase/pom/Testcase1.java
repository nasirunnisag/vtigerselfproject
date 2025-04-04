package vtiger.testcase.pom;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.Objectrepository.CreatingNewOrganizationPage;
import vtiger.Objectrepository.HomePage;
import vtiger.Objectrepository.LoginPage;
import vtiger.Objectrepository.OrganizationPage;
import vtiger.Objectrepository.OrgnameCreatedPage;

public class Testcase1 extends BaseClass{
@Test
public void tc1() throws IOException{
	//WebDriver d=null;
	String url1 = putil.readDataFrompFile("url");
	String uname = putil.readDataFrompFile("username");
	String pwd = putil.readDataFrompFile("password");
	String orgname = eutil.readDataFromFile("Organization", 4, 2)+jutil.getRandomNumber();
	//BaseClass bs=new BaseClass();
//openApp();
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
    cop.orgnametb(orgname);
    /*cop.orgmemselectionlink();
    wutil.switchtowindow(d, "specific_account_address");
    cop.searchtb(orgname);
    cop.searchclick(d,orgname);
    wutil.switchtowindow(d, "Accounts");
    */
    cop.save();
    OrgnameCreatedPage ocp=new OrgnameCreatedPage(d);
    String oheader = ocp.getOrnameheader().getText();
    if(oheader.contains(orgname))
	{
		System.out.println("org "+orgname+" created");
	}
	else
	{
		System.out.println("org "+orgname+" not created");

	}
    //HomePage hp=new HomePage(d);
    WebElement ele = hp.getAdminimg();
    wutil.mousehover(d, ele);
    hp.Signoutofapp(d);
}
}
