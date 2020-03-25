/* This class is for creating new account. If email id is new this class should be executed
along with CreateLoginTest for creating new account.*/

package testLibrary;

import pageLibrary.Base;
import pageLibrary.createnewaccount;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelReader;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatenewaccountTest extends Base {
	Logger log = Logger.getLogger("CreatenewaccountTest");
	createnewaccount newaccount;
	String sheetName = "CreateAccount";

	@BeforeTest
	public void newaccount() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		newaccount = new createnewaccount();	
	}

	@DataProvider
	public Object[][] enterdetails()
	{
		Object[][] data = ExcelReader.getTestData(sheetName);
		return data;
	}
	@Test(priority=0,dataProvider="enterdetails")
	public void Createnewaccountdetails(String mrmrs,String fn, String ln, String passwrd, String add,String city, String zip, String mobile, String addalias, String state ) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeContains(By.name("customer_firstname"), "name", "customer_firstname"));
		newaccount.selecttitle(mrmrs);
		newaccount.entercompletename(fn, ln);	
		newaccount.enterpassword(passwrd);
		newaccount.address(add);
		newaccount.city(city);
		newaccount.zipcode(zip);
		newaccount.mobileno(mobile);
		newaccount.addressalias(addalias);
		newaccount.state(state);
		log.info("details entered");
	}
	
	@Test(priority=1)
	public void clickregisterbutton()
	{
		newaccount.clickregisterbutton();
		log.info("Registered Button clicked");
	}

}
