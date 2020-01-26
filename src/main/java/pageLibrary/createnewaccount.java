package pageLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createnewaccount extends Base {
	
	@FindBy(id="id_gender1")
	WebElement selectMr;
	
	@FindBy(id="id_gender2")
	WebElement selectMrs;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy(id="customer_lastname")
	WebElement lastname;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="postcode")
	WebElement zipcode;
	
	@FindBy(id="phone_mobile")
	WebElement mobileno;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="alias")
	WebElement addressalias;
	
	@FindBy(id="submitAccount")
	WebElement registerbtn;
	
	public createnewaccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selecttitle(String Mr)
	{
		if(Mr=="Mr")
		{
			selectMr.click();
		}
		else
		{
			selectMrs.click();
		}
	}
	
	public void entercompletename(String first, String last)
	{
		firstname.sendKeys(first);
		lastname.sendKeys(last);
	}
	
	public void enterpassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	
	public void address(String add)
	{
		address.sendKeys(add);
	}
	
	public void city(String cty)
	{
		city.sendKeys(cty);
	}
	
	public void zipcode(String zip)
	{
		zipcode.sendKeys(zip);
	}
	
	public void mobileno(String mobile)
	{
		mobileno.sendKeys(mobile);
	}
	
	public void state(String st)
	{
		Select s = new Select(state);
		s.selectByVisibleText(st);
	}
	
	public void addressalias(String addalias)
	{
		addressalias.clear();
		addressalias.sendKeys(addalias);
	}
	
	public void clickregisterbutton()
	{
		registerbtn.click();
	}
	
}
