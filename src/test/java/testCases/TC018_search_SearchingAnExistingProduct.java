package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC018_search_SearchingAnExistingProduct extends BaseClass {
	
	@Test
	public void searchingAnExistingProduct() {
		try {
			logger.info("******** TC18 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Mac";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
		    String product="MacBook";
			for(String s:sp.getproductnames()) {
				if(s.equals(product)) {
					System.out.println(sp.getProductDescription(s));
					System.out.println(sp.getProductPrice(s));
					System.out.println(sp.getProductTaxAmount(s));
					sp.AddToCart(s);
					sp.AddToCompare(s);
					sp.AddWishList(s);
				}
			}
			logger.info("******** TC18 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC18 is FAILED **************");
			Assert.fail();
		}
	}

}
