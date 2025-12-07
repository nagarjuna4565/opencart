package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC016_lgi_LoginFromRegistrationpage extends BaseClass {
	
	@Test
	public void LoginFromRegistrationpage() {
		
		logger.info("******** TC16 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();
			
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			rap.LoginViaRegistrationpageusingLoginLink();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(p.getProperty("email"));
			lp.Enterpassword(p.getProperty("pw"));
			lp.clickLogin();
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertTrue(map.myaccountText());
			
			logger.info("******** TC16 is PASSED **************");
		}
		
		catch(Exception e) {
			logger.info("******** TC16 is FAILED **************");
			Assert.fail();
		}
	}

}
