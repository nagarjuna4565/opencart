package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC019_search_SearchingNonExistingProducts extends BaseClass {
	
	@Test
	public void searchingNonExistingProducts() {
		try {
			logger.info("******** TC19 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			sp.clickSearch();
		    String txt="There is no product that matches the search criteria.";
			Assert.assertTrue(sp.ValidateNoProdMessage(txt));
			logger.info("******** TC19 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC19 is FAILED **************");
			Assert.fail();
		}
	}

}


