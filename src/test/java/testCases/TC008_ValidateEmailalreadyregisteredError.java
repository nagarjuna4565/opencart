package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC008_ValidateEmailalreadyregisteredError extends BaseClass {
	
	@Test
	public void ValidateEmailalreadyregisteredError() {
		try {
			logger.info("******  TEST STARTED    ******");
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();
			
			logger.info("Starting the registration page ");
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			rap.setFirstname(randomString().toUpperCase());
			rap.setLastname(randomString().toUpperCase());
			rap.setemail(p.getProperty("email"));
			rap.setphonenum(randomNumber());
			String pw = randomAlphaNumeric();
			rap.setpassword(pw);
			rap.setconfirmpassword(pw);
			rap.selectPolicy();
			rap.clickContinue();
			
			String reemailerror="Warning: E-Mail Address is already registered!";
			Assert.assertTrue(rap.validatealreadyregisteredemailerror(reemailerror));
            logger.info("******  TEST FINISHED    ******");
			
			logger.info("******  TEST PASSED    ******");
		}
			catch(Exception e) {
				logger.info("******  TEST FINISHED    ******");
				
				logger.info("******  TEST FAILED    ******");
				Assert.fail();
			}
			
			logger.info("********* TEST EXECUTION COMPLETED *******************");
	}

}
