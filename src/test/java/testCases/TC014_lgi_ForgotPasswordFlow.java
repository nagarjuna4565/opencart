package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotYourPassword;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBases.BaseClass;

public class TC014_lgi_ForgotPasswordFlow extends BaseClass {
	@Test
	public void ForgotPasswordFlow() {
		logger.info("******** TC14 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			lp.clickForgotPw();
			
			ForgotYourPassword fp = new ForgotYourPassword(driver);
			
			fp.enterEmail(p.getProperty("email"));
			fp.clickContinue();
			String txt = "An email with a confirmation link has been sent your email address.";
			Assert.assertTrue(lp.ValidateConfirmationlinktext(txt));
			
			logger.info("******** TC14 is PASSED **************");
		}
		
		catch(Exception e) {
			logger.info("******** TC14 is FAILED **************");
			Assert.fail();
		}
	}
	

}
