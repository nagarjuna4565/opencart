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
	
	
	

}
