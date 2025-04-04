package vtiger.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractise {
@Test(retryAnalyzer=vtiger.GenericUtility.RetryAnalyserImplementation.class)
public void retryPractise()
{
	System.out.println("test 1");
	Assert.fail();
}
}
