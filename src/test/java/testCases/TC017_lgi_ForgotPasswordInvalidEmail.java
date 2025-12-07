package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotYourPassword;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBases.BaseClass;

public class TC017_lgi_ForgotPasswordInvalidEmail extends BaseClass{

	
	@Test
	public void ForgotPasswordInvalidEmail() {
	logger.info("******** TC17 is STARTED **************");
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.Login();
		
		LoginPage lp = new LoginPage(driver);
		lp.clickForgotPw();
		
		ForgotYourPassword fp = new ForgotYourPassword(driver);
		
		fp.enterEmail(randomString());
		fp.clickContinue();
		String txt = "Warning: The E-Mail Address was not found in our records, please try again!";
		Assert.assertTrue(fp.ValidateInvalidEmailWarning(txt));
		
		logger.info("******** TC17 is PASSED **************");
	}
	
	catch(Exception e) {
		logger.info("******** TC17 is FAILED **************");
		Assert.fail();
	
}
}
}
