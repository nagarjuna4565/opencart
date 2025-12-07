package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(xpath="//div[contains(text(),'Password confirmation does not match password!')]")
	WebElement txtcnfmPasswordError;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement txtalreadyregisteredemailerror;
	
	//errors
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	WebElement InvalidEmailError;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	WebElement pwlengtherror;
	
	@FindBy(xpath="//a[normalize-space()='login page']")
	WebElement lnkLoginHyperLink;
	
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
	
	public boolean validateCnfmpwError(String cnfmerror) {
		return ((txtcnfmPasswordError).getText()).equals(cnfmerror);
	}
	
	public boolean validatealreadyregisteredemailerror(String regemailerror) {
		return ((txtalreadyregisteredemailerror).getText()).equals(regemailerror);
	}
	
	public boolean validateInvalidEmailError(String error) {
		return (InvalidEmailError.getText()).equals(error);
	}
	
	//Using actions class
	
	public void registartionUsingActions(String fname,String lname,String email,String telephone,String password) {
		Actions a = new Actions(driver);
		
		//System.out.println(txtlastname.getAttribute("placeholder"));
		
		a.moveToElement(txtfirstname)
		 .click()
		 .sendKeys(fname)
		 .moveToElement(txtlastname)
		 .click()
		 .sendKeys(lname)
		 .moveToElement(txtemail)
		 .click()
		 .sendKeys(email)
		 .moveToElement(txttelephone)
		 .click()
		 .sendKeys(telephone)
		 .moveToElement(txtpassword)
		 .click()
		 .sendKeys(password)
		 .moveToElement(txtconfirmpassword)
		 .click()
		 .sendKeys(password)
		 .moveToElement(chkpolicyagree)
		 .click()
		 .sendKeys(Keys.ENTER)
		 .perform();
		 
	
	}
	
	public boolean validatepwlengtherror(String pw) {
		return (pwlengtherror.getText()).equals(pw);
	}
	
	public void LoginViaRegistrationpageusingLoginLink() {
		lnkLoginHyperLink.click();
	}
	
	
	
	

}
