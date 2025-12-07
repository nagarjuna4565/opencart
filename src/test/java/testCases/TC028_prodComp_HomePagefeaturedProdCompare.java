package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparepage;
import pageObjects.ProductHeaderPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC028_prodComp_HomePagefeaturedProdCompare extends BaseClass{
	
@Test
public void testclickingHomePagefeaturedProdCompare() {
	try {
		logger.info("******** TC28 is STARTED **************");
		SearchPage sp = new SearchPage(driver);
		HomePage hp = new HomePage(driver);
		String prod="Canon EOS 5D";
		hp.clickProductCompare(prod);
		
		String txt = "Success: You have added "+prod+" to your product comparison!";
		Assert.assertTrue(sp.validateProductaddedToComparetext(txt));
		sp.clickProdCompareFromSuccessLink();
		ProductComparepage pcp = new ProductComparepage(driver);
		String txt1="Product Comparison";
		pcp.validateProductComparisonheader(txt1);
		for(String s:pcp.getProductsList()) {
			if(s.equals(prod)) {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("******** TC28 is PASSED **************");
	}
	catch(Exception e) {
		logger.info("******** TC28 is FAILED **************");
		Assert.fail();
	}
}
}