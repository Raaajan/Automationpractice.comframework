package testLibrary;

import pageLibrary.Verifyaccountcreated;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


public class VerifyaccountcreatedTest {
	Verifyaccountcreated acctcreated ;
	Logger log = Logger.getLogger("VerifyaccountcreatedTest");
	@BeforeTest 
	public void personalinfo() 
	{	
		 acctcreated = new Verifyaccountcreated();
		 acctcreated.clickMypersonalinfo();
		 log.info("My personal info clicked");
	}

	@Test(priority = 0)
	public void verifypersonalinfo() {
		log.info("Taking personal info");
		String radiosel;
		boolean mrmrs = acctcreated.getMrmrs();
		if(mrmrs==true)
		{
			radiosel = "Mr";
		}
		else
		{
			radiosel = "Mrs";
		}
		String fn = acctcreated.getFirstname();
		log.info("Firstname : "+fn);
		String ln =acctcreated.getLastname();
		log.info("Lastname : "+ln);
		String emal = acctcreated.getEmail();
		log.info("email : "+emal);
		
		System.out.println("Mr/Mrs= "+radiosel+" Firstname= "+fn+" "+"Lastname= "+ln+" "+"Email= "+emal);
	}
}
