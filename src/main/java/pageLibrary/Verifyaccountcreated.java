package pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verifyaccountcreated extends Base{
	Logger log = Logger.getLogger("Verifyaccountcreated");
	
	@FindBy(xpath="//*[text()='My personal information']")
	WebElement mypersonalinfo;
	
	@FindBy(id="id_gender1")
	WebElement mr;
	
	@FindBy(id="id_gender2")
	WebElement mrs;
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement email;
	
	//Initialise pagefactory
	
	public Verifyaccountcreated()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickMypersonalinfo()
	{
		mypersonalinfo.click();
	}
	
	public boolean getMrmrs()
	{	
		boolean chk = mr.isSelected();
		System.out.println("mrmrs : "+chk);
		return chk;
	}
	public String getFirstname()
	{
		String fn = firstname.getAttribute("value");
		return fn;
	}
	public String getLastname()
	{
		String ln = lastname.getAttribute("value");
		return ln;
	}
	public String getEmail()
	{
		String eml = email.getAttribute("value");
		return eml;
	}
}
