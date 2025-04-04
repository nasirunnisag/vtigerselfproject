package vtiger.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnameCreatedPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement ornameheader;
public OrgnameCreatedPage(WebDriver d)
{
	PageFactory.initElements(d, this);
}
public WebElement getOrnameheader() {
	return ornameheader;
}
public String getOrgheader()
{
	return ornameheader.getText();
}
}
