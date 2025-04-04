package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(name="user_name")
private WebElement unametb;
@FindBy(name="user_password")
private WebElement pwdtb;
@FindBy(id="submitButton")
private WebElement loginbtn;
public LoginPage(WebDriver d)
{
	PageFactory.initElements(d, this);
}
public WebElement getUnametb() {
	return unametb;
}
public WebElement getPwdtb() {
	return pwdtb;
}
public WebElement getLoginbtn() {
	return loginbtn;
}
public void logintoApp(String username,String pwd)
{
	unametb.sendKeys(username);
	pwdtb.sendKeys(pwd);
	loginbtn.click();
}
}
