package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogOutPage extends BasePage {

	public AccountLogOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnlgoutContinue;
	
	@FindBy(xpath="//p[contains(text(),'You have been logged off your account. It is now s')]")
	WebElement txtlogoutsuccess;
	
	public boolean validateLogoutText(String txt) {
		return (txtlogoutsuccess.getText()).equals(txt);
	}
	
	public void clickcontinue() {
		btnlgoutContinue.click();
	}
	
	

}
