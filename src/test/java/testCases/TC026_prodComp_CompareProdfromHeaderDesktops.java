package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductComparepage;
import pageObjects.ProductHeaderPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC026_prodComp_CompareProdfromHeaderDesktops extends BaseClass {
	
	@Test
	public void clickingCompareProdfromHeaderDesktops() {
		try {
			logger.info("******** TC26 is STARTED **************");
			ProductHeaderPage php = new ProductHeaderPage(driver);
			php.moveToDesktops();
			php.clickShowAllDesktops();
			SearchPage sp = new SearchPage(driver);
		    String product="Canon EOS 5D";
			for(String s:sp.getproductnames()) {
				if(s.equals(product)) {
					sp.AddToCompare(s);
				}
			}
			
			String txt = "Success: You have added "+product+" to your product comparison!";
			Assert.assertTrue(sp.validateProductaddedToComparetext(txt));
			sp.clickProdCompareFromSuccessLink();
			ProductComparepage pcp = new ProductComparepage(driver);
			String txt1="Product Comparison";
			pcp.validateProductComparisonheader(txt1);
			for(String s:pcp.getProductsList()) {
				if(s.equals(product)) {
					Assert.assertTrue(true);
				}
			}
			
			logger.info("******** TC26 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC26 is FAILED **************");
			Assert.fail();
		}
	}

}
