package pageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
  public static WebDriver driver;
  
  public static void openbrowser()
  {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\framework\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com/");
  }
  
}
