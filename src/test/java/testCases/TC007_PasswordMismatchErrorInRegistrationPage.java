package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC007_PasswordMismatchErrorInRegistrationPage extends BaseClass{
	
	@Test
	public void PasswordMismatchErrorInRegistrationPage() {
		try {
			logger.info("******  TEST STARTED    ******");
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();
			
			logger.info("Starting the registration page ");
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			rap.setFirstname(randomString().toUpperCase());
			rap.setLastname(randomString().toUpperCase());
			rap.setemail(randomString()+"@gmail.com");
			rap.setphonenum(randomNumber());
			String pw = randomAlphaNumeric();
			rap.setpassword(pw);
			rap.setconfirmpassword(randomString());
			rap.selectPolicy();
			rap.clickContinue();
			
			String cnfmerror="Password confirmation does not match password!";
			Assert.assertTrue(rap.validateCnfmpwError(cnfmerror));
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
