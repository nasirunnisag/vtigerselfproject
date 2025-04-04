package vtiger.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import vtiger.GenericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage {
@FindBy(name="accountname")
private WebElement ornametb;
@FindBy(id="search_txt")
private WebElement searchtb;
@FindBy(name="search")
private WebElement searchbtn;
@FindBy(xpath="//img[@alt='Select']")
private WebElement ogrmembtn;
@FindBy(name="industry")
private WebElement industridropdown;
@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebtn;
public CreatingNewOrganizationPage(WebDriver d)
{
	PageFactory.initElements(d, this);
}
public void orgnametb(String name)
{
ornametb.sendKeys(name);	
}
public void searchtb(String name)
{
	searchtb.sendKeys(name);
}
public void searchclick(WebDriver d,String orgname)
{
searchbtn.click();
d.findElement(By.xpath("//a[.='"+orgname+"']")).click();
}
public void orgmemselectionlink()
{
ogrmembtn.click();
}
public void save()
{
	savebtn.click();
}
public WebElement getIndustridropdown() {
	return industridropdown;
}
public void createneworg(String orgname,String industrytype)
{
	WebDriverUtility wutil=new WebDriverUtility();
	ornametb.sendKeys(orgname);
	wutil.dropdown(industrytype,industridropdown );
	save();
}

}
