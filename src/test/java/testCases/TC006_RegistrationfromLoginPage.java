package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewUserRegisterAccountthroughLoginPage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;

public class TC006_RegistrationfromLoginPage extends BaseClass{
	
	@Test
	public void RegistrationfromLoginPage() {
		logger.info("******** TC06 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			lp.newUserContinue();
			
			NewUserRegisterAccountthroughLoginPage newuser = new NewUserRegisterAccountthroughLoginPage(driver);
			newuser.enterFistName(randomString().toUpperCase());
			newuser.enterLastName(randomString().toUpperCase());
			newuser.enterEmail(randomString()+"@gmail.com");
			newuser.enterTelephone(randomNumber());
			String pw = randomAlphaNumeric();
			newuser.enterpassword(pw);
			newuser.entercnfpassword(pw);
			newuser.selectpolicy();
			newuser.clickContinue();
			
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			String cnfmmsg = rap.getRegConfirmText();
			
			if(cnfmmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				
				Assert.assertTrue(false);
				
			}
			logger.info("******  TEST FINISHED    ******");
			
			logger.info("******  TEST PASSED    ******");
			
		}
		
		catch(Exception e) {
			logger.info("******  TEST FINISHED    ******");
			
			logger.info("******  TEST FAILED    ******");
			Assert.fail();
		}
	}
	

}
