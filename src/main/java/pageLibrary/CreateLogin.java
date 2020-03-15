package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLogin extends Base {
	 
	@FindBy(linkText="Sign in")
	WebElement signinbtn;
	
	@FindBy(id="email_create")
	WebElement enteremailtext;
	
	
	@FindBy(id="SubmitCreate")
	WebElement createaccountbtn;
	
	@FindBy(xpath="//*[text()='Your personal information']")
	WebElement personalinfomationText;
	
	//Initialise pagefactory
	
	public CreateLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonsigninbtn()
	{
		signinbtn.click();	
	}
	
	public void enteremailadd(String emailadd)
	{
		enteremailtext.sendKeys(emailadd);
	}
	
	public void clickoncreatebtn()
	{
		createaccountbtn.click();
	}
	
	public String verifyLogincreatepage()
	{
		//String createaccttext = driver.findElement(By.xpath("//*[text()='Your personal information']")).getText();
		String createaccttext = personalinfomationText.getText();
		return createaccttext;
	}
	
	public String emailalreadyexist()
	{	
		boolean emailexisttext ;
		try
		{
			emailexisttext = driver.findElement(By.id("create_account_error")).isDisplayed();
		}
		catch(Exception e)
		{
			 emailexisttext = false;
		}
		if (emailexisttext)
		{
		String emailexist = driver.findElement(By.xpath("//*[text()='Already registered?']")).getText();
		return emailexist;
		}
		else
		{
			return driver.findElement(By.xpath("//*[text()='Your personal information']")).getText();
		}
	}
	

}
