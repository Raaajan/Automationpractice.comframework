package testLibrary;

import org.testng.annotations.Test;

import pageLibrary.AddWishList;
import pageLibrary.Base;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;

public class AddWishListTest extends Base {

	AddWishList wishlist;
	ExistingCustomerSignInTest existingsign;
	Object[] orgitem;

	@BeforeTest
	public void addwishlist() throws InterruptedException {
		existingsign = new ExistingCustomerSignInTest();
		existingsign.openpage();
		existingsign.ExistingSignIn();
		wishlist = new AddWishList();
		Thread.sleep(2000);
	}
	
	@Test(priority = 0)
	public void deletealreadypresentwish() throws InterruptedException
	{
		wishlist.clickWishlist();
		wishlist.deleteallwish();
	}

	@Test(priority = 1)
	public void enterWishList() throws InterruptedException {
		orgitem = new Object[4];
		wishlist.clickWishlist();
		for (int i = 0; i <= 3; i++) {
			wishlist.enterItem("shirt" + "_" + i);
			wishlist.clickSaveBtn();
			orgitem[i] = "shirt" + "_" + i;
			Thread.sleep(1000);
		}
	}

	@Test(priority = 2)
	public void verifyWishList() {
		Object[] items = wishlist.elementsintable();

		for (int i = 0; i <= 3; i++) {
			Object itementered = orgitem[i];
			System.out.println("itementered = " + itementered);
			Object listitem = items[i];
			System.out.println("listitem = " + listitem);
			assertEquals(itementered, listitem);
		}
	}

}
