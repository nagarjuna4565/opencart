package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC033_addCart_AddToCartandViewfromBlackCart extends BaseClass{
	
	@Test
	public void testAddToCartandViewfromBlackCart() {
		try {
			logger.info("******** TC33 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Nikon D300";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
			sp.selectGridView();
		    sp.AddToCart(prod);
		    
		    String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
		    sp.clickOnBlackCart();
		    sp.clickViewCart();
		    logger.info("******** TC33 is PASSED **************");
		   
		}
		catch(Exception e) {
			logger.info("******** TC33 is FAILED **************");
			Assert.fail();
		}
	}

}
