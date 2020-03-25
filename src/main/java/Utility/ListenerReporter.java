package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ListenerReporter implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		System.out.println(("-------ON TEST START : " + result.getName()+ "-------------"));
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("ON TEST SUCCESS : " + result.getMethod().getMethodName() + " --------------------");
		test.log(LogStatus.PASS,result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		System.out.println("----------ON TEST FAILURE : " + result.getMethod().getMethodName() + " --------------------");
		test.log(LogStatus.FAIL,result.getMethod().getMethodName()+ " is Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------------------ON TEST SKIPPED : " + result.getMethod().getMethodName() + "------------------");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("--------ON START : " + context.getSuite().getName() + "--------------");
		if(extent ==null)
		{
		extent=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ListenersExtentReport.html", true);
		}
		test = extent.startTest("-------------Test started : "+context.getName()+"-------------");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(("----------ON FINISH : " +context.getSuite().getName()  + "-------------------"));
		extent.endTest(test);
		extent.flush();
		
	}

}