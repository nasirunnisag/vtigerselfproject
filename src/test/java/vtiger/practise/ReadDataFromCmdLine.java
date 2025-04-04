package vtiger.practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
@Test
public void readdata()
{
	String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("urlL");
	String UNAME = System.getProperty("username");
	String PWD = System.getProperty("pwd");
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(UNAME);
	System.out.println(PWD);
}
}
