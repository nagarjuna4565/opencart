package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductComparepage;
import pageObjects.SearchPage;
import testBases.BaseClass;

public class TC030_prodComp_AddToCartbasedOnPrice extends BaseClass{
	
	@Test
	public void testAddToCartbasedOnPrice() {
		try {
			logger.info("******** TC30 is STARTED **************");
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
		
			String a = pcp.getProductPrice(product1);
			String b = pcp.getProductPrice(product2);
			
			
			int prod1price = convertStringToInt(a);
			int prod2price = convertStringToInt(b);

			if (prod1price > prod2price) {
			    pcp.addProducttoCartFromComp(product1);
			} else {
			    pcp.addProducttoCartFromComp(product2);
			}
			
			logger.info("******** TC30 is PASSED **************");
		}
		catch(Exception e) {
			logger.info("******** TC30 is FAILED **************");
			Assert.fail();
		}

}
}
