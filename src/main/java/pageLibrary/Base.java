package pageLibrary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
  public static WebDriver driver;
 
  public static void openbrowser()
  {
	Logger log = Logger.getLogger("Base");
	PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.properties");   
	log.info("Logger intialised");
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	log.info("Opening Browser");
	driver.get("http://automationpractice.com/");
  }
  
}
