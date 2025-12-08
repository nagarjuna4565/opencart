package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDisplayPage;
import pageObjects.ProductHeaderPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC036_addCart_AddtoCartFromHeaders extends BaseClass{
	@Test
	public void testAddtoCartFromHeaders() {
		try {
			logger.info("******** TC36 is STARTED **************");
			ProductHeaderPage hp = new ProductHeaderPage(driver);
			hp.moveToDesktops();
			hp.clickOnMAC();
			
			SearchPage sp = new SearchPage(driver);
			String prod = "iMac";
			sp.selectGridView();
			sp.AddToCart(prod);
			String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
			sp.clickOnItemLink();
			logger.info("******** TC36 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC36 is FAILED **************");
			Assert.fail();
		}
	}

}
