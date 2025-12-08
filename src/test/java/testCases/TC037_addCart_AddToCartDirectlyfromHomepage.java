package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC037_addCart_AddToCartDirectlyfromHomepage extends BaseClass{
	
	@Test
	public void testAddToCartDirectlyfromHomepage() {
		try {
			logger.info("******** TC37 is STARTED **************");
			HomePage hp= new HomePage(driver);
			String prod = "iPhone";
			hp.addToCart(prod);
			SearchPage sp = new SearchPage(driver);
			String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
			sp.clickOnItemLink();
			logger.info("******** TC37 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC37 is FAILED **************");
			Assert.fail();
		}

}
}
