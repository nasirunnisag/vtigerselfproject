package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer  {
int count=0;
		int retrycount=3;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}

}
