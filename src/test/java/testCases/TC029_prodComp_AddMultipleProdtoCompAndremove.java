package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductComparepage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC029_prodComp_AddMultipleProdtoCompAndremove extends BaseClass{
	
	@Test
	public void testAddMultipleProdtoCompAndremove() {
		try {
			logger.info("******** TC29 is STARTED **************");
			SearchPage sp = new SearchPage(driver);
			String prod = "Mac";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
			sp.selectGridView();
		    String product1="MacBook";
		    String product2="MacBook Air";
			for(String s:sp.getproductnames()) {
				
				if(s.equals(product1)) {
					sp.AddToCompare(s);	
				}
			}
			
			String txt1 = "Success: You have added "+product1+" to your product comparison!";
			Assert.assertTrue(sp.validateProductaddedToComparetext(txt1));
			
			sp.closeSuccesMessageComp();
				for(String s:sp.getproductnames()) {
					if(s.equals(product2)) {
						
						sp.AddToCompare(s);
					}
				}
			
			
			String txt2 = "Success: You have added "+product2+" to your product comparison!";
			Assert.assertTrue(sp.validateProductaddedToComparetext(txt2));
			sp.clickProdCompareFromSuccessLink();
			ProductComparepage pcp = new ProductComparepage(driver);
			String txt3="Product Comparison";
			pcp.validateProductComparisonheader(txt3);
			for(String s:pcp.getProductsList()) {
				if(s.equals(product1) || s.equals(product2) ) {
					Assert.assertTrue(true);
				}
				else {
					Assert.fail();
				}
			}
			
			pcp.removeRemoveProductFromComp(product2);
			String txt4="Success: You have modified your product comparison!";
			Assert.assertTrue(pcp.validateCompProdRemoved(txt4));
			
			pcp.removeRemoveProductFromComp(product1);
			Assert.assertTrue(pcp.validateCompProdRemoved(txt4));
			
			logger.info("******** TC29 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC29 is FAILED **************");
			Assert.fail();
		}
	}

}
