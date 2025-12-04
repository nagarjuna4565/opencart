package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.NewsLetterSubscriptionaPage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC005_ValidateNewsLetterSubscription extends BaseClass {
	
	@Test
	public void ValidateNewsLetterSubscription() {
        logger.info("Test started .................");
		
		try {
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
		rap.setconfirmpassword(pw);
		rap.selectPolicy();
		rap.clickContinue();
		
		MyAccountPage map = new MyAccountPage(driver);
		map.susunsusnewsletter();
		
		NewsLetterSubscriptionaPage nlsp = new NewsLetterSubscriptionaPage(driver);
		
		Assert.assertTrue(nlsp.IsSubNoSelected());
		Assert.assertFalse(nlsp.IsSubYesSelected());
		logger.info("******  TEST FINISHED    ******");
		
		logger.info("******  TEST PASSED    ******");
		}catch(Exception e) {
            logger.info("******  TEST FINISHED    ******");
			
			logger.info("******  TEST FAILED    ******");
			Assert.fail();
			
		}
		
	}

}
