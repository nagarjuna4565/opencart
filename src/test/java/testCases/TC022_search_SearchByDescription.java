package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC022_search_SearchByDescription extends BaseClass{
	
	@Test
	public void SortSearchResults() {
		try {
			logger.info("******** TC22 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			sp.clickSearch();
			String des = "MacBook Air is ultrathin, ultraportable, and ultra unlike anything else";
			sp.enterProductDescriptiontext(des);
			sp.selectSearchInProductDescription();
			sp.clickSearchByDescription();
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
			logger.info("******** TC22 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC22 is FAILED **************");
			Assert.fail();
		}
	}

}
