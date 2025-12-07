package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC021_search_SortSearchResults extends BaseClass {
	@Test
	public void SortSearchResults() {
		try {
			logger.info("******** TC21 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Mac";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
			String sort="Name (Z - A)";
			sp.selectSortByFilter(sort);
		    String product="MacBook Air";
		    sp.selectListView();
			for(String s:sp.getproductnames()) {
				if(s.equals(product)) {
					sp.getProductDescription(s);
					Assert.assertEquals(sp.getProductPrice(s), "$1,202.00");
					sp.getProductTaxAmount(s);
					sp.AddToCart(s);
					sp.AddToCompare(s);
					sp.AddWishList(s);
				}
			}
			logger.info("******** TC21 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC21 is FAILED **************");
			Assert.fail();
		}
	}

}
