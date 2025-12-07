package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC010_RegistarationUsingActionsClass extends BaseClass{
	@Test
	public void RegistarationUsingActionsClass() {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			String fname = randomString();
			
			String lname = randomString();
			String email = randomString()+"@gmail.com";
			String telephone= randomNumber();
			String pw = randomAlphaNumeric();
			rap.registartionUsingActions(fname, lname, email, telephone, pw);
			String cnfmmsg = rap.getRegConfirmText();
			
			if(cnfmmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("********* TEST FAILED ************************");
				logger.debug("****** DEBUG LOGS **********************");
				Assert.assertTrue(false);
				
			}
			
			
	}catch(Exception e) {
		Assert.fail();
	}
		
	}

}
