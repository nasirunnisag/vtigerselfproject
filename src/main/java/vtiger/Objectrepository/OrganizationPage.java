package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement orglookimg;
public OrganizationPage(WebDriver d)
{
	PageFactory.initElements(d, this);
}
public WebElement getOrglookimg() {
	return orglookimg;
}
public void orglooklink()
{
orglookimg.click();	
}
}
