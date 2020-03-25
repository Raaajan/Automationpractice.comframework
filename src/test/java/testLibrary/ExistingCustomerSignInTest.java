package testLibrary;

import org.testng.annotations.Test;

import Utility.ExcelReader;
import Utility.Helper;
import pageLibrary.Base;
import pageLibrary.ExistingCustomerSignIn;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

public class ExistingCustomerSignInTest extends Base {
	
	ExistingCustomerSignIn signin;
	String sheetName = "EmailExiting";
	Logger log = Logger.getLogger("ExistingCustomerSignInTest");
	@BeforeTest
	public void openpage() throws InterruptedException {
		Base.openbrowser();
		Helper.pageloadtimeout();
		Helper.implicitwait();
		signin = new ExistingCustomerSignIn();
		Thread.sleep(1000);
	}

	@DataProvider
	public Object[][] enteremail()
	{
		Object[][] data = ExcelReader.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "enteremail")
	public void ExistingSignIn(String email,String password) 
	{
		signin.clickSignInbtn();
		log.info("Clicked on Sign in button");
		signin.enterEmail(email);
		signin.enterpassword(password);
		signin.clickSubmitbtn();
		log.info("Sign in done");
	}

	@AfterTest
	public void signout() {
		signin.clickSignoutbtn();
		log.info("Sign out done");
		//driver.close();
		//log.info("driver closed");
	}

}
