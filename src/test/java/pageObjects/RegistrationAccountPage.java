package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationAccountPage extends BasePage{

	public RegistrationAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicyagree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtaccountcreatedmsg;
	
	public void setFirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setphonenum(String phonenum) {
		txttelephone.sendKeys(phonenum);
	}
	
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void setconfirmpassword(String password) {
		txtconfirmpassword.sendKeys(password);
	}
	
	public void selectPolicy() {
		chkpolicyagree.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getRegConfirmText() {
		try {
		return txtaccountcreatedmsg.getText();
		}
		
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	
	
	
	

}
