package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductComparepage;
import pageObjects.ProductHeaderPage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC027_prodComp_ListModeCompareProdfromHeaderDesktops extends BaseClass {
	
	@Test
	public void clickingListModeCompareProdfromHeaderDesktops() {
		try {
			logger.info("******** TC27 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			
			ProductHeaderPage php = new ProductHeaderPage(driver);
			php.moveToDesktops();
			php.clickShowAllDesktops();
			sp.selectListView();
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
			
			logger.info("******** TC27 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC27 is FAILED **************");
			Assert.fail();
		}
	}

}
