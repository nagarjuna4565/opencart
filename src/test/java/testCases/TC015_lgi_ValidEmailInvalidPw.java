package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBases.BaseClass;

public class TC015_lgi_ValidEmailInvalidPw extends BaseClass{
	
	@Test
	public void ValidateInvalidCredsWarning() {
		
		logger.info("******** TC15 is STARTED **************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.Login();
			
			LoginPage lp = new LoginPage(driver);
			
			lp.Enteremail(p.getProperty("email"));
			lp.Enterpassword(randomString());
			lp.clickLogin();
			
			String s = "Warning: No match for E-Mail Address and/or Password.";
			Assert.assertTrue(lp.ValidateHeaderInvalidcredswarning(s));
			
			logger.info("******** TC15 is PASSED **************");
		}
		
		catch(Exception e) {
			logger.info("******** TC15 is FAILED **************");
			Assert.fail();
		}
	}

}
