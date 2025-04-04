package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
@FindBy(linkText="Organizations")
private WebElement organizationlink;
@FindBy(linkText="Contacts")
private WebElement contactslink;
@FindBy(linkText="Opportunities")
private WebElement opputunitieslink;
@FindBy(linkText="Products")
private WebElement productslink;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminimg;
@FindBy(linkText="Sign Out")
private WebElement signoutlink;
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getOrganizationlink() {
	return organizationlink;
}
public WebElement getContactslink() {
	return contactslink;
}
public WebElement getOpputunitieslink() {
	return opputunitieslink;
}
public WebElement getProductslink() {
	return productslink;
}
public WebElement getAdminimg() {
	return adminimg;
}
public WebElement getSignoutlink() {
	return signoutlink;
}

public void clickonOrganizationlink() {
	organizationlink.click();;
}
public void clickonContactslink() {
	contactslink.click();
}
public void clickonOpputunitieslink() {
	opputunitieslink.click();
}
public void clickonProductslink() {
	productslink.click();
}
public void clickonAdminimg() {
	adminimg.click();
}
public void Signoutofapp(WebDriver d) {
	
	mousehover(d, adminimg); 
	signoutlink.click();
}


}
