package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	
	@Test(groups= {"smoke","master"})
	void verify_accountregistration() {
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
		String cnfmmsg = rap.getRegConfirmText();
		
		if(cnfmmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("********* TEST FAILED ************************");
			logger.debug("****** DEBUG LOGS **********************");
			Assert.assertTrue(false);
			
		}
		
//		Assert.assertEquals(cnfmmsg,"Your Account Has Been Created");  //  this step cant be used because the hard assertion will not let the other steps to execute so we will not move into catch block.
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("********* TEST EXECUTION COMPLETED *******************");
	}
	
}
