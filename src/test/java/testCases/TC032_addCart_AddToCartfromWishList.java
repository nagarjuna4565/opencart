package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.WishListPage;
import testBases.BaseClass;

public class TC032_addCart_AddToCartfromWishList extends BaseClass{
	
	@Test
	public void AddToCartfromWishList() {
		try {
			logger.info("******** TC32 is STARTED **************");
			//Login
			
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(p.getProperty("email"));
			lp.Enterpassword(p.getProperty("pw"));
			lp.clickLogin();
			
			
			SearchPage sp = new SearchPage(driver);
			String prod = "Nikon D300";
			sp.enterProductinSearchbox(prod);
			sp.clickSearch();
			sp.selectGridView();
			
			sp.AddWishList(prod);
			hp.clickWishList();
			
			WishListPage wlp = new WishListPage(driver);
			wlp.clickAddToCart(prod);
			
		    String txt = "Success: You have added "+prod+" to your shopping cart!";
		    Assert.assertTrue(sp.validateHeaderText(txt));
		    sp.clickOnItemLink();
		    logger.info("******** TC32 is PASSED **************");
		   
		}
		catch(Exception e) {
			logger.info("******** TC32 is FAILED **************");
			Assert.fail();
		}
	}

}
