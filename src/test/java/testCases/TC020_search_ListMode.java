package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC020_search_ListMode extends BaseClass {


	@Test
	public void searchingAnExistingProductinListMode() {
		try {
			logger.info("******** TC20 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Mac";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
		    String product="MacBook";
		    sp.selectListView();
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
			logger.info("******** TC20 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC20 is FAILED **************");
			Assert.fail();
		}
	}

}
