package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC038_addCart_AddProductToCartDDT extends BaseClass{
	@Test(dataProvider="ListOfProducts",dataProviderClass=DataProviders.class)
	public void testAddProductToCartDDT(String prod) {
		try {
			logger.info("******** TC31 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			sp.enterProductinSearchbox(prod);
			sp.clickSearch(); 
			sp.selectGridView();
		    sp.AddToCart(prod);
		    
		    String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
		    sp.clickOnItemLink();
		    logger.info("******** TC31 is PASSED **************");
		   
		}
		catch(Exception e) {
			logger.info("******** TC31 is FAILED **************");
			Assert.fail();
		}
	}

}
