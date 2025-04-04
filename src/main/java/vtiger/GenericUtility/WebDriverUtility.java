package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
public void maxwin(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void waitforDOMmodel(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
public void waitForElementTobeVisible(WebDriver driver,WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(ele));
}
public void waitForElementTobeclickable(WebDriver driver,WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}
public void waitandclickelelement(WebElement ele) throws InterruptedException
{
int count=0;
while(count<10)
{
	try {
		ele.click();
		break;
		}
	catch(Exception e)
	{
		Thread.sleep(1000);
		count++; 
	}
}
}
public void dropdown(WebElement ele,int index)
{
	Select s=new Select(ele);
	s.selectByIndex(index);
}
public void dropdown(WebElement ele,String visibleText)
{
	Select s=new Select(ele);
	s.selectByVisibleText(visibleText);
}
public void dropdown(String value,WebElement ele)
{
	Select s=new Select(ele);
	s.selectByValue(value);
}
public void mousehover(WebDriver driver,WebElement ele)
{
Actions a=new Actions(driver);
a.moveToElement(ele).perform();
}
public void doubleclickon(WebDriver driver,WebElement ele)
{
Actions a=new Actions(driver);
a.doubleClick(ele).perform();
}
public void doubleclickon(WebDriver driver)
{
Actions a=new Actions(driver);
a.doubleClick().perform();
}
public void rightclickon(WebDriver driver,WebElement ele)
{
Actions a=new Actions(driver);
a.contextClick(ele).perform();
}
/**
 * to perform right click on page
 * @param driver
 */
public void rightclickon(WebDriver driver)
{
Actions a=new Actions(driver);
a.contextClick().perform();
}
public void draganddownOn(WebDriver driver,WebElement srcele,WebElement destele)
{
Actions a=new Actions(driver);
a.dragAndDrop(srcele, destele).perform();
}
public void pressEner() throws AWTException
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}
public void acceptalert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void dismisalert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public String gettextofalert(WebDriver driver)
{
	String text = driver.switchTo().alert().getText();
	return text;
}
public void handleframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
	
}
public void handleframe(WebDriver driver,String nameorId)
{
	driver.switchTo().frame(nameorId);
}
public void handleframe(WebDriver driver,WebElement ele)
{
	driver.switchTo().frame(ele);
	
}
public void toparentframe(WebDriver driver)
{
	driver.switchTo().parentFrame();
	
}
public void defaultwindow(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
public void switchtowindow(WebDriver driver,String partialtitle)
{
	//get all window ids
	Set<String> windoeids = driver.getWindowHandles();
	
	//iterate thru all window ids
	Iterator<String> it = windoeids.iterator();
	//naviate to each and check the title
	while(it.hasNext())
	{
	//.driver.capture the individule id
		String winid = it.next();
		String currenttitle = driver.switchTo().window(winid).getTitle();
		if(currenttitle.contains(partialtitle))
		{
			break;
		}
}
}
public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	
   	File dst = new File(IConstantUtility.screenpath+screenshotname+".png");
   	FileUtils.copyFile(src, dst);
   	return dst.getAbsolutePath();
}
public void scrollAction(WebDriver driver)
{
	 JavascriptExecutor js=(JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,500)", "");
}
public void scrollAction(WebDriver driver,WebElement ele)
{
	 JavascriptExecutor js=(JavascriptExecutor) driver; 
	 js.executeScript("argument[0].scrollIntoView()", ele);
	 int y=ele.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",ele);
}

}