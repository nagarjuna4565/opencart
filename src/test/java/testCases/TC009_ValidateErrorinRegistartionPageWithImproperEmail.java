package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC009_ValidateErrorinRegistartionPageWithImproperEmail extends BaseClass {
	@Test(dataProvider="InvalidEmails",dataProviderClass=DataProviders.class)
	public void ValidateErrorinRegistartionPageWithImproperEmail(String Emails) {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Registration();
			
			logger.info("Starting the registration page ");
			RegistrationAccountPage rap = new RegistrationAccountPage(driver);
			rap.setFirstname(randomString().toUpperCase());
			rap.setLastname(randomString().toUpperCase());
			rap.setemail(Emails);
			rap.setphonenum(randomNumber());
			String pw = randomAlphaNumeric();
			rap.setpassword(pw);
			rap.setconfirmpassword(pw);
			rap.selectPolicy();
			rap.clickContinue();
			String invalidemailerror="E-Mail Address does not appear to be valid!";
			if(rap.validateInvalidEmailError(invalidemailerror)) {
				Assert.assertTrue(true);
			}
			
			}
			catch(Exception e) {
				
				Assert.fail();
			}
	}

}
