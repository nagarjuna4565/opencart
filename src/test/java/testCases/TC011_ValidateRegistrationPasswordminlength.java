package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC011_ValidateRegistrationPasswordminlength extends BaseClass  {
	@Test (dataProvider = "Invalidpws",dataProviderClass=DataProviders.class)
	public void ValidateRegistrationPasswordminlength(String pw) {
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
//			String pw = randomAlphaNumeric();
			rap.setpassword(pw);
			rap.setconfirmpassword(pw);
			rap.selectPolicy();
			rap.clickContinue();
			
			String error="Password must be between 4 and 20 characters!";
			Assert.assertTrue(rap.validatepwlengtherror(error));
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
