package pageLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Helper;

public class ExistingCustomerSignIn extends Base {

	@FindBy(linkText = "Sign in")
	WebElement signinbtn;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement submit;

	@FindBy(xpath = "//a[@class='logout']")
	WebElement signout;

	// Initialise pagefactory

	public ExistingCustomerSignIn() {
		PageFactory.initElements(driver, this);
	}

	public void clickSignInbtn() {
		signinbtn.click();
	}

	public void enterEmail(String emailadd) {
		Helper.exwait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailadd);
	}

	public void enterpassword(String passwrd) {
		password.sendKeys(passwrd);
	}

	public void clickSubmitbtn() {
		submit.click();
	}

	public void clickSignoutbtn() {
		//Helper.exwait.until(ExpectedConditions.elementToBeClickable(signout));
		signout.click();
	}
}
