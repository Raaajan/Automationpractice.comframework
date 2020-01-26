package testLibrary;

import org.testng.annotations.Test;

import pageLibrary.Base;
import pageLibrary.ExistingCustomerSignIn;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;

public class ExistingCustomerSignInTest extends Base {

	ExistingCustomerSignIn signin;
	@BeforeTest
	public void openpage() throws InterruptedException {
		Base.openbrowser();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		signin = new ExistingCustomerSignIn();
		Thread.sleep(1000);
	}

	@Test
	public void ExistingSignIn() 
	{
		signin.clickSignInbtn();
		signin.enterEmail("rajandube@gmail.com");
		signin.enterpassword("Rajan@123");
		signin.clickSubmitbtn();
	}

	@AfterTest
	public void afterTest() {
	//	driver.close();
	}

}
