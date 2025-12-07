package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC013_lgi_ValidateInvalidCredsWarning extends BaseClass{
	@Test
	public void ValidateInvalidCredsWarning() {
		
		logger.info("******** TC13 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(randomString());
			lp.Enterpassword(randomString());
			lp.clickLogin();
			
			String s = "Warning: No match for E-Mail Address and/or Password.";
			Assert.assertTrue(lp.ValidateHeaderInvalidcredswarning(s));
			
			logger.info("******** TC13 is PASSED **************");
		}
		
		catch(Exception e) {
			logger.info("******** TC13 is FAILED **************");
			Assert.fail();
		}
	}
		
	}


