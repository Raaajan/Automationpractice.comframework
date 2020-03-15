//To check if email address already exist or it is new and account can be created.
package testLibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageLibrary.Base;
import pageLibrary.CreateLogin;



public class CreateLoginTest extends Base {
	int flag =0;
	CreateLogin login;
	Logger log = Logger.getLogger("CreateLoginTest");
	@BeforeTest
	public void openpage()
	{
		Base.openbrowser(); 
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		login = new CreateLogin();
		
	}
	
	@Test(priority=0)
	public void createnewaccount() throws InterruptedException 
	{
		login.clickonsigninbtn();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.attributeContains(By.name("email_create"), "name", "email_create"));
		login.enteremailadd("rajannndubbeeyy@gmail.com");
		log.info("email id entered");
		login.clickoncreatebtn();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void verifylogincreatepage()
	{
		
		String emailexist = login.emailalreadyexist();
		if(emailexist.equalsIgnoreCase("Already registered?"))
		{
			System.out.println("*****Either email already exist or email entered is Invalid*****");
			flag =1;
		}
		else if (emailexist.equalsIgnoreCase("Your personal information"))
		{
			System.out.println("***This is new user***");
		}
		else
		{
			throw new NotFoundException("This is invalid page");
		}
		

	}
	@AfterTest
	public void closebrowser()
	{
		if(flag==1)
		{
			log.info("Already/Invalid Email exist, Hence closing browser");
			driver.close();
		}
	}
	
}
