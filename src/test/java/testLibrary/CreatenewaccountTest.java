package testLibrary;

import pageLibrary.Base;
import pageLibrary.CreateLogin;
import pageLibrary.createnewaccount;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CreatenewaccountTest extends Base {

	createnewaccount newaccount;

	@BeforeTest
	public void beforeTest() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		newaccount = new createnewaccount();
	}

	@Test(priority=0)
	public void Createnewaccountdetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeContains(By.name("customer_firstname"), "name", "customer_firstname"));
		newaccount.selecttitle("Mr");
		newaccount.entercompletename("Rajan", "Dubey");	
		newaccount.enterpassword("Rajan@123");
		newaccount.address("ggghsfhghgg");
		newaccount.city("Mumbai");
		newaccount.zipcode("00000");
		newaccount.mobileno("8976543456");
		newaccount.addressalias("hsdfghy");
		newaccount.state("Indiana");
	}
	
	@Test(priority=1)
	public void clickregisterbutton()
	{
		newaccount.clickregisterbutton();
	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
