package testLibrary;

import org.testng.annotations.Test;

import pageLibrary.Base;
import pageLibrary.ExistingCustomerSignIn;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class ExistingCustomerSignInTest extends Base {
	
	ExistingCustomerSignIn signin;
	Logger log = Logger.getLogger("ExistingCustomerSignInTest");
	@BeforeTest
	public void openpage() throws InterruptedException {
		Base.openbrowser();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		signin = new ExistingCustomerSignIn();
		log.info("Clicked on Sign in button");
		Thread.sleep(1000);
	}

	@Test
	public void ExistingSignIn() 
	{
		signin.clickSignInbtn();
		signin.enterEmail(" ");
		signin.enterpassword("Rajan@123");
		signin.clickSubmitbtn();
		log.info("Sign in done");
	}

	@AfterTest
	public void signout() {
		/*signin.clickSignoutbtn();
		log.info("Sign out done");
		driver.close();
		log.info("driver closed");*/
	}

}
