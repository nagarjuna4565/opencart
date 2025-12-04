package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFieldErrorPage extends BasePage {

	public RegistrationFieldErrorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	WebElement txtFirstNameError;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	WebElement txtLastNameError;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement txtEmailError;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	WebElement txtTelephoneError;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement txtPasswordError;
	
	
	
	public boolean FirstNameErrorValidation (String firstNameErrorText) {
		boolean b = (txtFirstNameError.getText()).equals(firstNameErrorText);
		return b;
	}
	
	public boolean LastNameErrorValidation (String lastNameErrorText) {
		boolean b = (txtLastNameError.getText()).equals(lastNameErrorText);
		return b;
	}
	
	public boolean EmailErrorValidation (String emailErrorText) {
		boolean b = (txtEmailError.getText()).equals(emailErrorText);
		return b;
	}
	
	public boolean TelephoneErrorValidation (String telephoneErrorText) {
		boolean b = (txtTelephoneError.getText()).equals(telephoneErrorText);
		return b;
	}
	
	public boolean passwordErrorValidation (String passwordErrorText) {
		boolean b = (txtPasswordError.getText()).equals(passwordErrorText);
		return b;
	}
	
	
	

}
