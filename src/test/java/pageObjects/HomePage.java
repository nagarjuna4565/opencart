package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register_btn;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement btnlogin;
	
	
	
	public void clickMyaccount() {
		MyAccount.click();
		 try { Thread.sleep(500); } catch (Exception e) {}
	}
	
	public void Registration() {
		Register_btn.click();
	}
	
	public void Login() {
		btnlogin.click();
	}


}
