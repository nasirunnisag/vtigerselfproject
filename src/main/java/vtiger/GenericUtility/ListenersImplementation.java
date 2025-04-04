package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author nasir
 */
public class ListenersImplementation implements ITestListener{
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		//Reporter.log(methodname+"----->test execution started",true);
			test=reports.createTest(methodname);
			test.log(Status.INFO, "test script execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		//Reporter.log(methodname+"----->test execution passed",true);
		test.log(Status.PASS, methodname+"test script execution passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		
		String methodname=result.getMethod().getMethodName();
		String screenshotname=methodname+jutil.getSystemDateInFormat();
		try {
			String path = wutil.takeScreenShot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Reporter.log(methodname+"----->test execution fafiled",true);
		//Reporter.log(result.getThrowable().toString()+"-> reason for failure",true);
		test.log(Status.FAIL, methodname+" is failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		//Reporter.log(methodname+"----->test execution skipped",true);
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(result.getThrowable().toString()+"-> reason for skip",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("execution started",true);
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReporter/Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle(" execution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("vtiger execution report");
		//attach report to extentreports
	    reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("Base Browser", "Firefox");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Base url","http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Base Name", "chaithra");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("execution finish",true);
		//mandatory becoz this says aall test script exection is complete and finalreport can be generated
		reports.flush();
	}

}
