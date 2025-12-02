package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups= {"master","regression"})
	public void verifyLoginDDT(String email,String pw,String res) {
		logger.info("******** TC03 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(email);
			lp.Enterpassword(pw);
			lp.clickLogin();
			
			MyAccountPage map = new MyAccountPage(driver);
			
			boolean b = map.myaccountText();
			
			if(res.equalsIgnoreCase("valid")) {
				
				if(b) {
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
				
			}
			
           if(res.equalsIgnoreCase("invalid")) {
				
				if(b) {
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
				
			}
			
	
			
		}
		
		catch(Exception e) {
			logger.info("******** TC03 is FAILED **************");
			Assert.fail();
		}
		
		logger.info("******** TC03 is COMPLETED **************");
	}

}
