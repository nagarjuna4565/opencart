package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnNewUserContinue;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement txtHeaderInvalidcredswarning;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement lnkforgotpw;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txtconfirmationlinktext;
	
	public void Enteremail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void Enterpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void newUserContinue() {
		btnNewUserContinue.click();
	}
	
	public boolean ValidateHeaderInvalidcredswarning(String txt) {
		return (txtHeaderInvalidcredswarning.getText()).equals(txt);
	}
	
	public void clickForgotPw() {
		lnkforgotpw.click();
	}
	
	public boolean ValidateConfirmationlinktext(String txt) {
		return (txtconfirmationlinktext.getText()).equals(txt);
	}
	
	
	

}
