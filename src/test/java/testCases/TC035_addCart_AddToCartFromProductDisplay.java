package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC035_addCart_AddToCartFromProductDisplay extends BaseClass{
	
	@Test
	public void AddToCartFromProductDisplay() {
		try {
			logger.info("******** TC35 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Nikon D300";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
			sp.selectGridView();
		    
			sp.clickonproduct(prod);
			ProductDisplayPage pdp = new ProductDisplayPage(driver);
			Assert.assertTrue(pdp.validateProductName(prod));
			System.out.println("Hi");
			String Quantity ="2";
			pdp.setQuantity(Quantity);
			pdp.addToCart();
			String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
			
			logger.info("******** TC35 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC35 is FAILED **************");
			Assert.fail();
		}

}
}
