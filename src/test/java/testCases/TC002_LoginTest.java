package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"sanity","master"})
	public void verifyLogin() {
		logger.info("******** TC02 is STARTED **************");
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
			
			
			
		}
		
		catch(Exception e) {
			logger.info("******** TC02 is FAILED **************");
			Assert.fail();
		}
	}

}
