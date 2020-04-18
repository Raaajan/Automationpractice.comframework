package Utility;
//sayli
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageLibrary.Base;


public class ListenerReporter extends Base implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.startTest(result.getName());
		System.out.println(("-------ON TEST START : " + result.getName()+ "-------------"));
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("ON TEST SUCCESS : " + result.getMethod().getMethodName() + " --------------------");
		test.log(LogStatus.PASS,result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		System.out.println("----------ON TEST FAILURE : " + result.getMethod().getMethodName() + " --------------------");
		String screenshotPath = Screenshot.getScreenshot(result.getMethod().getMethodName());
		test.log(LogStatus.FAIL,test.addScreenCapture(screenshotPath));
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------------------ON TEST SKIPPED : " + result.getMethod().getMethodName() + "------------------");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context.getSuite().getName());
		if(extent ==null)
		{
		extent=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ListenersExtentReport.html", true);
		}
		//test = extent.startTest(context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println((context.getSuite().getName()));
		extent.endTest(test);
		extent.flush();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

}