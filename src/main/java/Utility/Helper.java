package Utility;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import pageLibrary.Base;

public class Helper extends Base {
	
	public static WebDriverWait exwait = new WebDriverWait(driver,120);
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	public static void pageloadtimeout()
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}


}
