/* This class is for creating new account. If email id is new this class should be executed
along with CreateLoginTest for creating new account.*/

package testLibrary;

import pageLibrary.Base;
import pageLibrary.createnewaccount;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatenewaccountTest extends Base {
	Logger log = Logger.getLogger("CreatenewaccountTest");
	createnewaccount newaccount;

	@BeforeTest
	public void newaccount() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		newaccount = new createnewaccount();
	}

	@Test(priority=0)
	public void Createnewaccountdetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeContains(By.name("customer_firstname"), "name", "customer_firstname"));
		newaccount.selecttitle("Mrs");
		newaccount.entercompletename("Rajan", "Dubey");	
		newaccount.enterpassword("Rajan@123");
		newaccount.address("ggghsfhghgg");
		newaccount.city("Mumbai");
		newaccount.zipcode("00000");
		newaccount.mobileno("8976543456");
		newaccount.addressalias("hsdfghy");
		newaccount.state("Indiana");
		log.info("details entered");
	}
	
	@Test(priority=1)
	public void clickregisterbutton()
	{
		newaccount.clickregisterbutton();
		log.info("Registered Button clicked");
	}

}
