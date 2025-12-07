package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductComparepage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC025_prodComp_clickingProdCompinSuccessMessage extends BaseClass{
	
	@Test
	public void clickingProdCompinSuccessMessage() {
		try {
			logger.info("******** TC25 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Mac";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
		    String product="MacBook";
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
			
			logger.info("******** TC25 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC25 is FAILED **************");
			Assert.fail();
		}
	}

}
