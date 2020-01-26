package pageLibrary;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* After sign in click on Wishlist
 * add new wishlist eg. Shirt , Tshirt, pant ,etc
 * check if all is added successfully
 * */
public class AddWishList extends Base {
	@FindBy(xpath = "//*[text()='My wishlists']")
	public static WebElement wishlist;

	@FindBy(id = "name")
	public static WebElement enteritem;

	@FindBy(id = "submitWishlist")
	public static WebElement savebtn;

	// @FindBy(xpath="//*[@id='block-history']//table/tbody/tr/td[1]")
	// public static WebElement tableelements;
	//

	// Initialising page factory
	public AddWishList() {
		PageFactory.initElements(driver, this);
	}

	public void clickWishlist() {
		wishlist.click();
	}

	public void enterItem(String item) {
		enteritem.sendKeys(item);
	}

	public void clickSaveBtn() {
		savebtn.click();
	}

	public Object[] elementsintable() {
		List<WebElement> allitems = driver.findElements(By.xpath("//*[@id='block-history']//table/tbody/tr/td[1]"));
		Object[] allitemtext = new Object[allitems.size()];
		for(int i =0; i<allitems.size();i++)
		{
			WebElement item = allitems.get(i);
			allitemtext[i] = item.getText().toString();
		}
		return allitemtext;
	}

	public void deleteallwish() throws InterruptedException {
		List<WebElement> allwish = driver.findElements(By.xpath("//*[@id='block-history']//table/tbody/tr/td[6]/a[1]"));
		int size = allwish.size();
		for (int i = 0; i < size; i++) {
			WebElement delete = allwish.get(i);
			delete.click();
			Thread.sleep(1000);
			Alert a = driver.switchTo().alert();
			a.accept();
	
		}

	}

}
