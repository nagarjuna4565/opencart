package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserRegisterAccountthroughLoginPage extends BasePage {

	public NewUserRegisterAccountthroughLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfPassword;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	public void enterFistName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterTelephone(String pnum) {
		txtTelephone.sendKeys(pnum);
	}
	
	public void enterpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void entercnfpassword(String pwd) {
		txtCnfPassword.sendKeys(pwd);
	}
	
	
	
	public void selectpolicy() {
		if(btnpolicy.isSelected()) {
			return;
		}
		
		else{
			btnpolicy.click();
		}
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	

}
