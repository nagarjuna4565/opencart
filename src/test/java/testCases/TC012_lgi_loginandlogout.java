package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC012_lgi_loginandlogout extends BaseClass {
	@Test
	public void loginandlogout() {
		logger.info("******** TC12 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(p.getProperty("email"));
			lp.Enterpassword(p.getProperty("pw"));
			lp.clickLogin();
			
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertTrue(map.myaccountText());
			
			
			hp.clickMyaccount();
			hp.Logoutfromheader();
			
			AccountLogOutPage alp = new AccountLogOutPage(driver);
			String txt = "You have been logged off your account. It is now safe to leave the computer.";
			Assert.assertTrue(alp.validateLogoutText(txt));
			alp.clickcontinue();
			
		}
		
		catch(Exception e) {
			logger.info("******** TC12 is FAILED **************");
			Assert.fail();
		}
	}

}
