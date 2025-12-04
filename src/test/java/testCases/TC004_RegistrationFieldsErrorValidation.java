package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import pageObjects.RegistrationFieldErrorPage;
import testBases.BaseClass;

public class TC004_RegistrationFieldsErrorValidation extends BaseClass {
	
	@Test
	public void validateRegistrationPageErrors() {
		logger.info("******  TEST STARTED    ******");
		
		try {
			
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();
			
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			rap.clickContinue();
			RegistrationFieldErrorPage rpe = new RegistrationFieldErrorPage(driver);
			
			String firstNameErrorText="First Name must be between 1 and 32 characters!";
			String lastNameErrorText ="Last Name must be between 1 and 32 characters!";
			String emailErrorText    ="E-Mail Address does not appear to be valid!";
			String telephoneErrorText="Telephone must be between 3 and 32 characters!";
			String passwordErrorValidation="Password must be between 4 and 20 characters!";
			
			Assert.assertTrue(rpe.FirstNameErrorValidation(firstNameErrorText));
			Assert.assertTrue(rpe.LastNameErrorValidation(lastNameErrorText));
			Assert.assertTrue(rpe.EmailErrorValidation(emailErrorText));
			Assert.assertTrue(rpe.TelephoneErrorValidation(telephoneErrorText));
			Assert.assertTrue(rpe.passwordErrorValidation(passwordErrorValidation));
			
			
			logger.info("******  TEST FINISHED    ******");
			
			logger.info("******  TEST PASSED    ******");
		}
		catch (Exception e) {
			logger.info("******  TEST FINISHED    ******");
			logger.info("******  TEST FAILED    ******");
			Assert.fail();
		}
	}

}
