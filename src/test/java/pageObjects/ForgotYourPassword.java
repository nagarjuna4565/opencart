package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotYourPassword extends BasePage{

	public ForgotYourPassword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement txtInavalidEmail;
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public boolean ValidateInvalidEmailWarning(String Txt) {
		return(txtInavalidEmail.getText()).equals(Txt);
	}

}
