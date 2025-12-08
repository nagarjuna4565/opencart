package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductHeaderPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC034_addCart_AddToCartFromHeader extends BaseClass {
	@Test
	public void AddToCartFromProductDisplayPage() {
		try {
			logger.info("******** TC34 is STARTED **************");
			ProductHeaderPage php = new ProductHeaderPage(driver);
			php.moveToDesktops();
			php.clickOnMAC();
			SearchPage sp = new SearchPage(driver);
			String prod="iMac";
			sp.selectGridView();
		    sp.AddToCart(prod);
		    String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
		    logger.info("******** TC34 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC34 is FAILED **************");
			Assert.fail();
		}
	}

}
